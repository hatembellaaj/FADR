/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

    
import com.tfar.dao.MembreDao;
import com.tfar.entity.Membre;

import com.tfar.services.MembreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author hatem
 */
public class MembreServiceImpl implements MembreService {

    @Autowired
    private MembreDao membreDao;    

    public MembreDao getCousinDao() {
        return membreDao;
    }

    public void setCytogenetiqueDao(MembreDao membreDao) {
        this.membreDao = membreDao;
    }
    
    @Override
    public void add(Membre newMembre) 
    {
        membreDao.add(newMembre);

    }

    @Override
    public void update(Membre membre) 
    {
        membreDao.update(membre);
    }

    @Override
    public Membre getMembreParnMembre(String nMembre)
    {
        return membreDao.getMembreParnMembre(nMembre);
    }
    
    @Override
    public List <Membre> getListMembreParnDossier(String nDossier)
    {
        return membreDao.getListMembreParnDossier(nDossier);
    }
    @Override
    public void delete(Membre membre)
    {
        membreDao.delete(membre);
    }
    @Override
    public List <Membre> getAllMembre()
    {
        return membreDao.getAllMembre();
    }
    
}
