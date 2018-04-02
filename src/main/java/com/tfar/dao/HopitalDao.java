/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

/**
 *
 * @author hatem
 */

import com.tfar.entity.Hopitale;
import java.util.List;

public interface HopitalDao {
    
    public List <Hopitale> getAllHopital();
    
    public void add(Hopitale newhopital);
    
    public void update(Hopitale hopital);
    
    public Hopitale getHopitalParNom(String nomHop);
    
    public Hopitale getHopitalParNum (Integer numHop);
    
    public void delete(Hopitale hopital);
    
}

