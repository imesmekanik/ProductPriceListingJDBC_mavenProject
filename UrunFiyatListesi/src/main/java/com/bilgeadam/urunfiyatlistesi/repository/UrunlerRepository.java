/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.urunfiyatlistesi.repository;

import com.bilgeadam.urunfiyatlistesi.entity.Urunler;
import com.bilgeadam.urunfiyatlistesi.utility.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author musty
 */
public class UrunlerRepository  implements ICrud<Urunler>{

    @Override
    public void save(Urunler t) {
        String sql="insert into tblurunfiyat (urunno,grup,urunismi,listefiyati) values( ?,?,?,? )";
    
        try {    
            PreparedStatement ps= DbConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getUrunNo());
            ps.setString(2, t.getGrup());
            ps.setString(3, t.getUrunIsmi());
            ps.setLong(4, t.getListeFiyati());

            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(UrunlerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    @Override
    public void update(Urunler t, long id) {
            String sql = "update tblmusteri "
		+ "set urunno='"+t.getUrunNo()+"', "
		+ "grup='"+t.getGrup()+"',"
		+ "urunismi='"+t.getUrunIsmi()+"', "
		+ "listefiyati='"+t.getListeFiyati()+"',"
		+ " where id="+id;
            PreparedStatement ps;            
            try {
                ps = DbConnection.getInstance().getConnection().prepareStatement(sql);
                ps.executeQuery();
            } catch (SQLException ex) {
            Logger.getLogger(UrunlerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void delete(long id) {
        String sql="delete from tblurunfiyat where id="+id;
        PreparedStatement ps;
        try {
            ps = DbConnection.getInstance().getConnection().prepareStatement(sql);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UrunlerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Urunler> findAll() {
                        ResultSet rs;
        		List<Urunler> mlist = new ArrayList();
                        String sql="select * from tblurunfiyat order by id";
                        
		try {
                        PreparedStatement ps= DbConnection.getInstance().getConnection().prepareStatement(sql);
                        rs=ps.executeQuery();
			while(rs.next()) {
				String urunNo = rs.getString("urunno"); // rs.getInt(1);
				String grup= rs.getString("grup");//  rs.getInt(2);
				String urunIsmi = rs.getString("urunismi");
				int fiyat = rs.getInt("listefiyati");
				mlist.add(new Urunler(urunNo,grup, urunIsmi, fiyat));
			}
		}catch (Exception e) {
			System.out.println("Müşteri TAblosu Okuma hatası...: "+ e.toString());
		}
		
		
		return mlist;
    }

    @Override
    public void saveAll(List<Urunler> t) {
        String sql="insert into tblurunfiyat (urunno,grup,urunismi,listefiyati) values( ?,?,?,? )";
        
        t.forEach(s ->{
       
        try {    
            PreparedStatement ps= DbConnection.getInstance().getConnection().prepareStatement(sql);
            
            ps.setString(1, s.getUrunNo());
            ps.setString(2, s.getGrup());
            ps.setString(3, s.getUrunIsmi());
            ps.setLong(4,s.getListeFiyati());
            ps.executeUpdate();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(UrunlerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } );
        
        
        
        
    }
    
}
