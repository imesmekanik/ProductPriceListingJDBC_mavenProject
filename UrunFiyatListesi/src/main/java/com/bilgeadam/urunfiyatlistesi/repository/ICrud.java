/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bilgeadam.urunfiyatlistesi.repository;

import java.util.List;

/**
 *
 * @author musty
 */
public interface ICrud <T> {
    
    void save(T t);
    void update(T t,long id);
    void delete(long id);
    List<T> findAll();
    void saveAll(List<T> t );
   
}
