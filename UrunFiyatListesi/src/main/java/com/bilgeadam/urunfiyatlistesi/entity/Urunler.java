/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.urunfiyatlistesi.entity;

/**
 *
 * @author MONSTER
 */
public class Urunler {
    private String urunNo;
    private String grup;
    private String urunIsmi;
    private long listeFiyati;

    public Urunler(String urunNo, String grup, String urunIsmi, long listeFiyati) {
        this.urunNo = urunNo;
        this.grup = grup;
        this.urunIsmi = urunIsmi;
        this.listeFiyati = listeFiyati;
    }

    public String getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(String urunNo) {
        this.urunNo = urunNo;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public long getListeFiyati() {
        return listeFiyati;
    }

    public void setListeFiyati(long listeFiyati) {
        this.listeFiyati = listeFiyati;
    }

    @Override
    public String toString() {
        return "Urunler{" + "urunNo=" + urunNo + ", grup=" + grup + ", urunIsmi=" + urunIsmi + ", listeFiyati=" + listeFiyati + '}';
    }

    
    
    
}
