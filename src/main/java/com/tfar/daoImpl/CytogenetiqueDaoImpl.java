/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.CytogenetiqueDao;
import com.tfar.entity.Cytogenetique;
import java.util.ArrayList;
import java.util.List;
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
    
public class CytogenetiqueDaoImpl implements CytogenetiqueDao{

    private Cytogenetique newCytogenetique;
    private Cytogenetique cytogenetique;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Cytogenetique newCytogenetique) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newCytogenetique);  
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
    public void update(Cytogenetique cytogenetique) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(cytogenetique);  
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
    public List<Cytogenetique> getCytogenetiquesParNDossier (String numDossier){
     List<Cytogenetique> cytogenetiques = new ArrayList<Cytogenetique>();  
     Session session = sessionFactory.openSession();
    System.out.println("getCytogenetiqueParNDossier:----------------------");
        try  
        {
            session.beginTransaction();
            DetachedCriteria query = DetachedCriteria.forClass(Cytogenetique.class)
                .add( Restrictions.eq("cutogenetiquePK.nDossierPatient", numDossier) );
                
            System.out.println("query:"+query.toString());            
            cytogenetiques = query.getExecutableCriteria(session).list();
            
           //freres.add(F);
            System.out.println("DaoCytogenetiquesParNDossier:"+cytogenetiques.toString());
            session.getTransaction().commit(); 
        
        
        }
        catch (Exception e)  
        {  
            session.getTransaction().rollback();  
        }         
            session.flush(); 
            session.close();
        return cytogenetiques;
    }

    @Override
    public List<Cytogenetique> getAllCytogenetique() {
        
        @SuppressWarnings("unchecked")
        List <Cytogenetique>  DaoAllCytogenetique = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllCytogenetique  = (List<Cytogenetique>) session.createCriteria(Cytogenetique.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllCytogenetique;
    }    
    
    
    
    
    @Override
    public List<Cytogenetique> getListCytogenetiqueParnDossier(String nDossier) {
        
        @SuppressWarnings("unchecked")
        List <Cytogenetique>  DaoAllCytogenetique = new ArrayList<Cytogenetique>();
        Session session = sessionFactory.openSession();
        try  
        {
            System.out.println("DAO ------ getListCytogenetiqueParnDossier ........."); 
            session.beginTransaction();
            
            
            DetachedCriteria query = DetachedCriteria.forClass(Cytogenetique.class)
                .add( Restrictions.eq("cytogenetiquePK.nDossierPatient", nDossier) );
                
            System.out.println("query:"+query.toString());            
            DaoAllCytogenetique = query.getExecutableCriteria(session).list();
            
           //freres.add(F);
            System.out.println("DaoFreresParNDossier:"+DaoAllCytogenetique.toString());
            session.getTransaction().commit(); 

        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllCytogenetique;
    }

    @Override
    public void delete(Cytogenetique cytogenetique) {
        
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
