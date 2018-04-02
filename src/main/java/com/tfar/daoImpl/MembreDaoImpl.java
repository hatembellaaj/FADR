/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.MembreDao;
import com.tfar.entity.Cousin;
import com.tfar.entity.Frere;
import com.tfar.entity.Membre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
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
public class MembreDaoImpl implements MembreDao{

    private Membre newMembre;
    private Membre membre;
    private EntityManager em;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Membre newMembre) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newMembre);  
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
    public void update(Membre membre) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(membre);  
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
 public Membre getMembreParnMembre(String nMembre){
        
        Membre membre=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Membre.class);
            criteria.add(Restrictions.eq("Id_Membre", nMembre));
            membre = (Membre) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return membre;
    }

    @Override
    public List<Membre> getAllMembre() {
        
        @SuppressWarnings("unchecked")
        List <Membre>  DaoAllMembre = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllMembre  = (List<Membre>) session.createCriteria(Membre.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllMembre;
    }    
    
    
    
    
    @Override
    public List <Membre> getListMembreParnDossier(String nDossier){
        @SuppressWarnings("unchecked")
        List <Membre>  DaoAllMembre = new ArrayList<Membre>();  
        Session session = sessionFactory.openSession();
        try  
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Membre.class);
            DetachedCriteria query = DetachedCriteria.forClass(Membre.class)
                .add( Restrictions.eq("membrePK.nDossierM", nDossier) );
                
            System.out.println("query:"+query.toString());            
            DaoAllMembre = query.getExecutableCriteria(session).list();

            System.out.println("DaoFreresParNDossier:"+DaoAllMembre.toString());
            session.getTransaction().commit();     
    
        }
        catch (Exception e)  
        {  
            session.getTransaction().rollback();  
        }      
        session.flush(); 
        session.close();
        return DaoAllMembre;
    }

    @Override
    public void delete(Membre membre) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(membre);
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
