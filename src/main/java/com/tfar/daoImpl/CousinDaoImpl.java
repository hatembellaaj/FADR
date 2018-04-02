/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.CousinDao;
import com.tfar.entity.Cousin;
import com.tfar.entity.Frere;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
//@Stateful
public class CousinDaoImpl implements CousinDao{

    private Cousin newCousin;
    private Cousin cousin;
    //@PersistenceContext
    private EntityManager em;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Cousin newCousin) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newCousin);  
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
    public void update(Cousin cousin) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(cousin);  
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
    public Cousin getCousinParnCousin(String nCousin){
        
        Cousin cousin=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Cousin.class);
            criteria.add(Restrictions.eq("Id_Cousin", nCousin));
            cousin = (Cousin) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return cousin;
    }

    @Override
    public List<Cousin> getAllCousin() {
        
        @SuppressWarnings("unchecked")
        List <Cousin>  DaoAllCousin = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllCousin  = (List<Cousin>) session.createCriteria(Cousin.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllCousin;
    }    
    
    
    
    
    @Override
    public List<Cousin> getListCousinParnDossier(String nDossier) {
        
        @SuppressWarnings("unchecked")
        List <Cousin>  DaoAllCousin = new ArrayList<Cousin>();  
        Session session = sessionFactory.openSession();
        try  
        {

            session.beginTransaction();
            Criteria criteria = session.createCriteria(Cousin.class);
            DetachedCriteria query = DetachedCriteria.forClass(Cousin.class)
                .add( Restrictions.eq("cousinPK.ndossierC", nDossier) );
                
            System.out.println("query:"+query.toString());            
            DaoAllCousin = query.getExecutableCriteria(session).list();
            
           //freres.add(F);
            System.out.println("DaoFreresParNDossier:"+DaoAllCousin.toString());
            session.getTransaction().commit();     
    
        }
        catch (Exception e)  
        {  
            session.getTransaction().rollback();  
        }      
        session.flush(); 
        session.close();
        return DaoAllCousin;

    }

    @Override
    public void delete(Cousin cytogenetique) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(cytogenetique);
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
