/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.services;

import com.tfar.entity.Androgene;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface AndrogeneService {
    
    public List <Androgene> getAllAndrogene();
    
    public void add(Androgene newAndrogene);
    
    public void update(Androgene androgene);
    
    public List <Androgene> getListAndrogeneParnDossier(String nDossier);
    
    public void delete(Androgene androgene);
}
