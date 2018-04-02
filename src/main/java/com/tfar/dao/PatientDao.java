/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;


import com.tfar.entity.Patient;

import java.util.List;
import java.util.Map;
/**
 *
 * @author hatem
 */
public interface PatientDao {
    
    public List <Patient> getAllPatient();
    
    public void add(Patient newPatient) ;
    
    public void update(Patient patient);
    
    public Patient getPatientParnDossier(String ndossierP);
        
    public void delete(Patient patient);
    
    public Map <String,Number> getPatientParCritere(String critere);
}

