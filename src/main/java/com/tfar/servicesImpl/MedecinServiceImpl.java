/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

import com.tfar.dao.MedecinDao;
import com.tfar.entity.Medecin;
import com.tfar.services.MedecinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class MedecinServiceImpl implements MedecinService {

    @Autowired
    private MedecinDao medecinDao;

    public MedecinDao getMedecinDao() {
        return medecinDao;
    }

    @Override
    public void add(Medecin newmedecin) {
        
        medecinDao.add(newmedecin);
    }

    @Override
    public void update(Medecin medecin) {
        
        medecinDao.update(medecin);
    }

    @Override
    public Medecin getMedecinParNom(String nomMedecin) {
        
        return medecinDao.getMedecinParNom(nomMedecin);
    }

    @Override
    public List<Medecin> getAllMedecin() {
        
        return medecinDao.getAllMedecin();
    }

    @Override
    public Medecin getMedecinParCIN(Integer cinMedecin) {
        return  medecinDao.getMedecinParCIN(cinMedecin);
    }

    @Override
    public void delete(Medecin medecin) {
        
        medecinDao.delete(medecin);
    }
    @Override
    public Medecin getMedecinByLoginPassword(String login, String Password) {
        return getMedecinDao().getMedecinByLoginPassword(login, Password);
                
    }
}