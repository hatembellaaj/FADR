/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.MedecinDao;
import com.tfar.entity.Medecin;
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
public class MedecinDaoImpl implements MedecinDao{

    private Medecin newmedecin;
    private Medecin medecin;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Medecin newmedecin) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newmedecin);  
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
    public void update(Medecin medecin) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(medecin);  
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
    public Medecin getMedecinParNom(String nomMedecin) {
        
        Medecin medecin=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Medecin.class);
            criteria.add(Restrictions.eq("nomMedecin", nomMedecin));
            medecin = (Medecin) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return medecin;
    }

    @Override
    public List<Medecin> getAllMedecin() {
        
        @SuppressWarnings("unchecked")
        List <Medecin>  DaoAllMedecin = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllMedecin  = (List<Medecin>) session.createCriteria(Medecin.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllMedecin;
    }

    @Override
    public Medecin getMedecinParCIN(Integer cinMedecin) {
        
        Medecin medecin=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Medecin.class);
            criteria.add(Restrictions.eq("cin", cinMedecin));
            medecin = (Medecin) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return medecin;
    }

    @Override
    public void delete(Medecin medecin) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(medecin);
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
    public Medecin getMedecinByLoginPassword(String login, String password) {
        System.out.println(login);
        System.out.println(password);

        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Medecin.class);
            criteria.add(Restrictions.eq("Login", login));
            criteria.add(Restrictions.eq("Passwd", password));            
            medecin = (Medecin) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return medecin;        
        
    }    
    
}
