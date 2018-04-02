/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;
import com.tfar.entity.Service;
import java.util.List;
/**
 *
 * @author hatem
 */
public interface ServiceDao {
        
    public List <Service> getAllService();
    
    public void add(Service newservice);
    
    public void update(Service service);
    
    public Service getServiceParNom(String nomService);
    
    public Service getServiceParNum (Integer numService);
    
    public void delete(Service service);
    
}