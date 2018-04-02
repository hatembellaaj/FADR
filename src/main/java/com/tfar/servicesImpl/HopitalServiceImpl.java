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
import com.tfar.dao.HopitalDao;
import com.tfar.entity.Hopitale;
import com.tfar.services.HopitalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Asus
 */
public class HopitalServiceImpl implements HopitalService{
    
    @Autowired
    private HopitalDao hopitalDao;
    
    
    public HopitalDao getHopitalDao() {
        return hopitalDao;
    }


    @Override
    public void add(Hopitale newhopital) {
        
        hopitalDao.add(newhopital);
    }

    @Override
    public void update(Hopitale hopital) {
        
        hopitalDao.update(hopital);
    }

    @Override
    public Hopitale getHopitalParNom(String nomHop) {
        
        return hopitalDao.getHopitalParNom(nomHop);
    }

    @Override
    public List<Hopitale> getAllHopital() {
        
        return hopitalDao.getAllHopital();
    }

    @Override
    public Hopitale getHopitalParNum(Integer numHop) {
        System.out.println("HopitalServiceImpl - numHopital : " + numHop);
        return  hopitalDao.getHopitalParNum(numHop);
    }

    @Override
    public void delete(Hopitale hopital) {
        
        hopitalDao.delete(hopital);
    }
    
}