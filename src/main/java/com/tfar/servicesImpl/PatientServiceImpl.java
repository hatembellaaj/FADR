/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

/**
 *
 * @author hatem
 */
import com.tfar.dao.PatientDao;
import com.tfar.entity.Patient;
import com.tfar.services.PatientService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService{
    
    @Autowired
    private PatientDao patientDao;
    
    
    public PatientDao getPatientDao() {
        return patientDao;
    }


    @Override
    public void add(Patient newPatient) {
        
        patientDao.add(newPatient);
    }

    @Override
    public void update(Patient patient) {
        
        patientDao.update(patient);
    }

    @Override
    public Patient getPatientParnDossier(String ndossierP){
        
        return patientDao.getPatientParnDossier(ndossierP);
    }

    @Override
    public List <Patient> getAllPatient() {
        
        return patientDao.getAllPatient();
    }

    
    
    @Override
    public void delete(Patient patient) {
        
        patientDao.delete(patient);
    }
    
    @Override
    public Map <String,Number> getPatientParCritere(String critere){
        return patientDao.getPatientParCritere(critere);
    }
    
}
