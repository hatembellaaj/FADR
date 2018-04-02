/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

import com.tfar.dao.CousinDao;
import com.tfar.entity.Cousin;

import com.tfar.services.CousinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author hatem
 */
public class CousinServiceImpl implements CousinService {

    @Autowired
    private CousinDao cousinDao;    

    public CousinDao getCousinDao() {
        return cousinDao;
    }

    public void setCytogenetiqueDao(CousinDao cousinDao) {
        this.cousinDao = cousinDao;
    }
    
    @Override
    public void add(Cousin newCousin) 
    {
        cousinDao.add(newCousin);

    }

    @Override
    public void update(Cousin cousin) 
    {
        cousinDao.update(cousin);
    }

    @Override
     public Cousin getCousinParnCousin(String nCousin){
        return cousinDao.getCousinParnCousin(nCousin);
    }

    @Override
    public List<Cousin> getAllCousin() {
        return cousinDao.getAllCousin();
    }    

    @Override
    public List<Cousin> getListCousinParnDossier(String nDossier) {
        return cousinDao.getListCousinParnDossier(nDossier);
    }

    @Override
    public void delete(Cousin cousin) {
        cousinDao.delete(cousin);
    }    
    
}
