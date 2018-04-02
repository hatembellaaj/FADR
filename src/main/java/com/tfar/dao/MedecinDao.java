/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

import com.tfar.entity.Medecin;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface MedecinDao {
    
    public List <Medecin> getAllMedecin();
    
    public void add(Medecin newmedecin);
    
    public void update(Medecin medecin);
    
    public Medecin getMedecinParNom(String nomMedecin);
    
    public Medecin getMedecinParCIN (Integer cinMedecin);
    
    public void delete(Medecin medecin);

    public Medecin getMedecinByLoginPassword(String login, String password); 
}
