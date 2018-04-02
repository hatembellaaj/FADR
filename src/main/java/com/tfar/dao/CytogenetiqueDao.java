/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

import com.tfar.entity.Cytogenetique;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface CytogenetiqueDao {
    
    public List <Cytogenetique> getAllCytogenetique();
    
    public void add(Cytogenetique newCytogenetique);
    
    public void update(Cytogenetique cytogenetique);
    
    public List<Cytogenetique> getCytogenetiquesParNDossier (String numDossier);
    
    public List <Cytogenetique> getListCytogenetiqueParnDossier(String nDossier);
    
    public void delete(Cytogenetique cytogenetique);
}
