/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;


import com.tfar.dao.FrereDao;
import com.tfar.entity.Frere;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class FrereDaoImpl implements FrereDao{

    private Frere newfrere;
    private Frere frere;
    private EntityManager em;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
    
    @Override
    public List <Frere> getAllFrere(){
        @SuppressWarnings("unchecked")
        List <Frere>  DaoAllFrere = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllFrere  = (List<Frere>) session.createCriteria(Frere.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllFrere;
    }        
    
    @Override
    public void add(Frere newfrere){
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newfrere);  
            session.flush();    
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            session.getTransaction().rollback();  
        }  
        session.close();
    }        

    @Override
    public void update(Frere frere){        
        Session session = sessionFactory.openSession(); 
        try  
        {  
            // begin a transaction   
            session.beginTransaction();
    
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
    public List<Frere> getFreresParNDossier (String numDossier){
     List<Frere> freres = new ArrayList<Frere>();  
     Session session = sessionFactory.openSession();
    System.out.println("getFreresParNDossier:----------------------");
        try  
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Frere.class);
           // criteria.add(Restrictions.eq("frerePK.nDossierF", numDossier));
           //criteria.add(Restrictions.eq("atteint", "oui"));
           // Frere F = (Frere) criteria.uniqueResult();
            DetachedCriteria query = DetachedCriteria.forClass(Frere.class)
                .add( Restrictions.eq("frerePK.nDossierF", numDossier) );
                
            System.out.println("query:"+query.toString());            
            freres = query.getExecutableCriteria(session).list();
            
           //freres.add(F);
            System.out.println("DaoFreresParNDossier:"+freres.toString());
            session.getTransaction().commit(); 
        
        
        }
        catch (Exception e)  
        {  
            session.getTransaction().rollback();  
        }         
            session.flush(); 
            session.close();
        return freres;
    }
    
    public void delete(Frere frere){
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(frere);
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
