/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

import com.tfar.entity.Frere;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface FrereDao {
    public List <Frere> getAllFrere();
    
    public void add(Frere newfrere);
    
    public void update(Frere frere);
    

    
    public List<Frere> getFreresParNDossier (String numDossier);
    
    public void delete(Frere frere);  
}
