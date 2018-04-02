/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

import com.tfar.dao.ServiceDao;
import com.tfar.entity.Service;
import com.tfar.services.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class ServiceServiceImpl implements ServiceService{
    
    @Autowired
    private ServiceDao serviceDao;

    public ServiceDao getServiceDao() {
        return serviceDao;
    }

    @Override
    public void add(Service newservice) {
        
        serviceDao.add(newservice);
    }

    @Override
    public void update(Service service) {
        
        serviceDao.update(service);
    }

    @Override
    public Service getServiceParNom(String nomService) {
        
        return serviceDao.getServiceParNom(nomService);
    }

    @Override
    public List<Service> getAllService() {
        
        return serviceDao.getAllService();
    }

    @Override
    public Service getServiceParNum(Integer numService) {
        return  serviceDao.getServiceParNum(numService);
    }

    @Override
    public void delete(Service service) {
        
        serviceDao.delete(service);
    }
    
}
