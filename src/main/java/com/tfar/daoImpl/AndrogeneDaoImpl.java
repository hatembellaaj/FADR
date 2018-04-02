/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;
  
import com.tfar.dao.AndrogeneDao;
import com.tfar.entity.Androgene;
import java.util.ArrayList;
import java.util.List;

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
    
public class AndrogeneDaoImpl implements AndrogeneDao{

    private Androgene newAndrogene;
    private Androgene androgene;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Androgene newAndrogene) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newAndrogene);  
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
    public void update(Androgene androgene) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(androgene);  
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
    public List<Androgene> getAllAndrogene() {
        
        @SuppressWarnings("unchecked")
        List <Androgene>  DaoAllAndrogene = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllAndrogene  = (List<Androgene>) session.createCriteria(Androgene.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllAndrogene;
    }    
    
    
    
    
    @Override
    public List<Androgene> getListAndrogeneParnDossier(String nDossier) {
        
        @SuppressWarnings("unchecked")
        List <Androgene>  DaoAllAndrogene = new ArrayList<Androgene>();
        Session session = sessionFactory.openSession();
        try  
        {
            System.out.println("DAO ------ getListAndrogeneParnDossier ........."); 
            session.beginTransaction();
            
            
            DetachedCriteria query = DetachedCriteria.forClass(Androgene.class)
                .add( Restrictions.eq("androgenePK.nDossierPa", nDossier) );
                
            System.out.println("query:"+query.toString());            
            DaoAllAndrogene = query.getExecutableCriteria(session).list();
            
           //freres.add(F);
            System.out.println("DaoAndrogeneParNDossier:"+DaoAllAndrogene.toString());
            session.getTransaction().commit(); 

        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllAndrogene;
    }

    @Override
    public void delete(Androgene androgene) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(androgene);
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

