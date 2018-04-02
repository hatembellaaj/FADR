/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

import com.tfar.dao.CytogenetiqueDao;

import com.tfar.entity.Cytogenetique;
import com.tfar.services.CytogenetiqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class CytogenetiqueServiceImpl implements CytogenetiqueService{

    @Autowired
    private CytogenetiqueDao cytogenetiqueDao;    

    public CytogenetiqueDao getCytogenetiqueDao() {
        return cytogenetiqueDao;
    }

    public void setCytogenetiqueDao(CytogenetiqueDao cytogenetiqueDao) {
        this.cytogenetiqueDao = cytogenetiqueDao;
    }
    
    @Override
    public void add(Cytogenetique newCytogenetique) 
    {
        cytogenetiqueDao.add(newCytogenetique);

    }

    @Override
    public void update(Cytogenetique cytogenetique) 
    {
        cytogenetiqueDao.update(cytogenetique);
    }

    @Override
    public List<Cytogenetique> getCytogenetiquesParNDossier (String numDossier){
        return cytogenetiqueDao.getCytogenetiquesParNDossier(numDossier);
    }

    @Override
    public List<Cytogenetique> getAllCytogenetique() {
        return cytogenetiqueDao.getAllCytogenetique();
    }    

    @Override
    public List<Cytogenetique> getListCytogenetiqueParnDossier(String nDossier) {
        System.out.println("Service ---- getListCytogenetiqueParnDossier .........");
        return cytogenetiqueDao.getListCytogenetiqueParnDossier(nDossier);
    }

    @Override
    public void delete(Cytogenetique cytogenetique) {
        cytogenetiqueDao.delete(cytogenetique);
    }
    
}
