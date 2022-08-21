/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.urunfiyatlistesi.utility;

import com.bilgeadam.urunfiyatlistesi.entity.Urunler;
import com.bilgeadam.urunfiyatlistesi.entity.Urunler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtils {
    
    
    
    public static List<String> readFile(String path ){
        
        List<String> list=new ArrayList<String>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(path));
            String line="";
            
            while ((line=reader.readLine())  !=null) {
               
                list.add(line) ;
            }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  list;
        
    }
    
    public static List<Urunler>  getUrunlerList(List<String> list){
        List<Urunler> urunlers=new ArrayList<>();
        for (String string : list) {
         urunlers.add(convertToUrunler(string.split(";")));
        }
        return  urunlers;
    }
    
    
    public static  Urunler convertToUrunler(String [] array){
        
        
        Urunler urunler= new Urunler((array[0]),array[1] , array[2], Long.parseLong(array[3]) );
        
        
        return  urunler;
    }
    
    public static void main(String[] args) {
        FileUtils f=new FileUtils();
     List<Urunler> list= f.getUrunlerList(f.readFile(Constant.urunlerFile));
        
        for (Urunler urunler : list) {
            System.out.println(urunler);
            
        }
     
    }
    
}
