/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.services;

import com.tfar.entity.Cousin;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface CousinService {
    public List <Cousin> getAllCousin();
    
    public void add(Cousin newCousin);
    
    public void update(Cousin cousin);
    
    public Cousin getCousinParnCousin(String nCousin);
    
    public List <Cousin> getListCousinParnDossier(String nDossier);
    
    public void delete(Cousin cousin);
}
