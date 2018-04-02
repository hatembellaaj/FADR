/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

import com.tfar.entity.Fiche;

import java.util.List;
import java.util.Map;
/**
 *
 * @author hatem
 */
public interface FicheDao {
    
    public List <Fiche> getAllFiche();
    
    public List <Fiche> getFicheParnService(int nService);
    
    public void add(Fiche newFiche);
    
    public void update(Fiche fiche);
    
    public Fiche getFicheParnDossier(String nDossier);
    
    public void delete(Fiche fiche);
    
    public Map <String,Number> getFicheParCritere(String critere);
    
    public Map <String,String> getKM();
}
