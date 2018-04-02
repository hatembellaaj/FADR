/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

import com.tfar.entity.Membre;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface MembreDao {

    public List <Membre> getAllMembre();
    
    public void add(Membre newMembre);
    
    public void update(Membre membre);
    
    public Membre getMembreParnMembre(String nMembre);
    
    public List <Membre> getListMembreParnDossier(String nDossier);
    
    public void delete(Membre membre);
}
