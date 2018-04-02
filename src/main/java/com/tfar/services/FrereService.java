/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.services;

import com.tfar.entity.Frere;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface FrereService {
    public List <Frere> getAllFrere();
    
    public void add(Frere newFrere);
    
    public void update(Frere frere);
    
    
    public List <Frere> getListFrereParnDossier(String nDossier);
    
    public void delete(Frere frere);
}
