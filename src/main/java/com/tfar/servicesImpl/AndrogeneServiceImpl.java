/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;


import com.tfar.dao.AndrogeneDao;

import com.tfar.entity.Androgene;
import com.tfar.services.AndrogeneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class AndrogeneServiceImpl implements AndrogeneService{

    @Autowired
    private AndrogeneDao androgeneDao;    

    public AndrogeneDao getAndrogeneDao() {
        return androgeneDao;
    }

    public void setAndrogeneDao(AndrogeneDao androgeneDao) {
        this.androgeneDao = androgeneDao;
    }
    
    @Override
    public void add(Androgene newAndrogene) 
    {
        androgeneDao.add(newAndrogene);

    }

    @Override
    public void update(Androgene androgene) 
    {
        androgeneDao.update(androgene);
    }


    @Override
    public List<Androgene> getAllAndrogene() {
        return androgeneDao.getAllAndrogene();
    }    

    @Override
    public List<Androgene> getListAndrogeneParnDossier(String nDossier) {
        System.out.println("Service ---- getListAndrogeneParnDossier .........");
        return androgeneDao.getListAndrogeneParnDossier(nDossier);
    }

    @Override
    public void delete(Androgene androgene) {
        androgeneDao.delete(androgene);
    }
    
}

