/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.ServiceDao;
import com.tfar.entity.Service;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class ServiceDaoImpl implements ServiceDao{
    private Service newservice;
    private Service service;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Service newservice) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newservice);  
            session.flush();    
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();
    }

    @Override
    public void update(Service service) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(service);  
            session.flush();    
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();
        
    }

    @Override
    public Service getServiceParNom(String nomService) {
        
        Service service=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Service.class);
            criteria.add(Restrictions.eq("Nom_Service", nomService));
            service = (Service) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return service;
    }

    @Override
    public List<Service> getAllService() {
        
        @SuppressWarnings("unchecked")
        List <Service>  DaoAllService = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllService  = (List<Service>) session.createCriteria(Service.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllService;
    }

    @Override
    public Service getServiceParNum(Integer numService) {
        
        Service service=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Service.class);
            criteria.add(Restrictions.eq("codeService", numService));
            service = (Service) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return service;
    }

    @Override
    public void delete(Service service) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(service);
            session.getTransaction().commit(); 
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();
    }
    
    
}
