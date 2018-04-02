/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

import com.tfar.dao.FrereDao;
import com.tfar.entity.Frere;

import com.tfar.services.FrereService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author hatem
 */
public class FrereServiceImpl implements FrereService {

    @Autowired
    private FrereDao frereDao;    

    public FrereDao getFrereDao() {
        return frereDao;
    }

    public void setCytogenetiqueDao(FrereDao frereDao) {
        this.frereDao = frereDao;
    }
    
    @Override
    public void add(Frere newFrere) 
    {
        frereDao.add(newFrere);

    }

    @Override
    public void update(Frere frere) 
    {
        frereDao.update(frere);
    }



    @Override
    public List<Frere> getAllFrere() {
        return frereDao.getAllFrere();
    }    

    @Override
    public List<Frere> getListFrereParnDossier(String nDossier) {
        System.out.println("getListFrereParnDossier:----------------------");
        return frereDao.getFreresParNDossier(nDossier);
    }

    @Override
    public void delete(Frere frere) {
        frereDao.delete(frere);
    }    
    
}
