/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

/**
 *
 * @author hatem
 */
import com.tfar.dao.HopitalDao;
import com.tfar.entity.Hopitale;
//import Entity.Service;
import java.util.List;
import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Asus
 */
public class HopitalDaoImpl implements HopitalDao{

    private Hopitale newhopital;
    private Hopitale hopital;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Hopitale newhopital) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newhopital);  
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
    public void update(Hopitale hopital) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(hopital);  
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
    public Hopitale getHopitalParNom(String nomHop) {
        
        Hopitale hopital=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Hopitale.class);
            criteria.add(Restrictions.eq("Nom_Hopitale", nomHop));
            hopital = (Hopitale) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return hopital;
    }

    @Override
    public List<Hopitale> getAllHopital() {
        
        @SuppressWarnings("unchecked")
        List <Hopitale>  DaoAllHopital = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllHopital  = (List<Hopitale>) session.createCriteria(Hopitale.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllHopital;
    }

    @Override
    public Hopitale getHopitalParNum(Integer numHop) {
        System.out.println("HopitalDao - numHopital : " + numHop);
        Hopitale hopital=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Hopitale.class);
            System.out.println("HopitalDao - Code_hopitale 1");
            criteria.add(Restrictions.eq("codehopitale", numHop));
            System.out.println("HopitalDao - Code_hopitale 2");
            hopital = (Hopitale) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return hopital;
    }

    @Override
    public void delete(Hopitale hopital) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(hopital);
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
