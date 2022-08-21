/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.urunfiyatlistesi.main;

import com.bilgeadam.urunfiyatlistesi.entity.Urunler;
import com.bilgeadam.urunfiyatlistesi.repository.UrunlerRepository;
import com.bilgeadam.urunfiyatlistesi.utility.Constant;
import com.bilgeadam.urunfiyatlistesi.utility.FileUtils;
import java.util.Scanner;

/**
 *   
 * @author musty
 */
public class ManagerUrunler {
     
    UrunlerRepository urunlerRepository;

    public ManagerUrunler() {
    this.urunlerRepository=new UrunlerRepository();
    
    }
    
    
    
    public void menu (){
        Scanner scanner=new Scanner(System.in);
        int input=0;
        do {            
            System.out.println("0-Çıkış ");
            System.out.println("1-Dosyadan Database'e Urunleri Aktarma");
            System.out.println("2-Urun ekle");
            System.out.println("3-Urun güncelle");
            System.out.println("4-Urun Sil");
            System.out.println("5-Urunleri getir");
            
            
            input=Integer.parseInt(scanner.nextLine());
            
            switch(input){
                case 1:
                    urunlerRepository.saveAll(FileUtils.getUrunlerList(FileUtils.readFile(Constant.urunlerFile)));  
                    break;
                case 2:
                    System.out.println("Urun no giriniz: ");
                    String urunno=scanner.nextLine();
                    System.out.println("Urun grubu giriniz:");
                    String grup=scanner.nextLine();
                    System.out.println("Urun ismi giriniz:");
                    String urunIsim=scanner.nextLine();
                    System.out.println("Urun liste fiyatini giriniz:");
                    int fiyat = scanner.nextInt();
                    urunlerRepository.save(new Urunler(urunno, grup, urunIsim, fiyat));
                    break;
                case 3:
               
                    System.out.println("Urun no giriniz: ");
                    urunno=scanner.nextLine();
                    System.out.println("Urun grubu giriniz:");
                    grup=scanner.nextLine();
                    System.out.println("Urun ismi giriniz:");
                    urunIsim=scanner.nextLine();
                    System.out.println("Urun liste fiyatini giriniz:");
                    fiyat = scanner.nextInt();
                    System.out.println("Degistirmek istediginiz urunun id sini giriniz:");
                    int id=scanner.nextInt();
                    urunlerRepository.update(new Urunler(urunno, grup, urunIsim, fiyat),id);
                    break; 
                    
                case 4:
                    System.out.println("Silmek istediginiz urunun id sini giriniz:");
                    id=scanner.nextInt();
                    urunlerRepository.delete(id);
                    break;
                
                case 5:
                    urunlerRepository.findAll();
                    break;
                case 0:
                    System.exit(0);
                    break;
                    
                
                
                
                
            }
            
            
            
            
            
        } while (true);
        
        
        
    }
    
    
    public static void main(String[] args) {
        ManagerUrunler m=new ManagerUrunler();
        m.menu();
    }
    
}
