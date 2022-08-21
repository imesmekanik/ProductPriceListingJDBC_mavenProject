/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.urunfiyatlistesi.utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


// connection yararan bir metot olsun cretaeConnection()

public class DbConnection {

    
    private  Connection connection;
    private static DbConnection instance;
    
    
    private DbConnection() {
        createConnection();
    }

    public  Connection getConnection() {
        return connection;
    }

    public  void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public static DbConnection getInstance(){
        
        if (instance==null) {
            
            instance=new DbConnection();
            
        }else try {
            if(instance.getConnection().isClosed()){
                
                 instance=new DbConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return  instance;
    }
    
    
    
    public  Connection createConnection(){
        
    
        try {
            Driver.class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection(Constant.DBURL,Constant.USERNAME,Constant.PASSWORD);
            System.out.println("Bağlantı Başarılı");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        
        return  connection;
        
    }
    
  
}
