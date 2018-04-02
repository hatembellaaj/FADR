/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.*;

import com.tfar.entity.Fiche;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
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
public class FicheDaoImpl implements FicheDao{

    private Fiche newfiche;
    private Fiche fiche;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Fiche newFiche) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newFiche);  
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
    public void update(Fiche fiche) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(fiche);  
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
    public Fiche getFicheParnDossier(String nDossier) {
        
        Fiche fiche=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Fiche.class);
            criteria.add(Restrictions.eq("nDossier", nDossier));
            fiche = (Fiche) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return fiche;
    }

    @Override
    public List<Fiche> getAllFiche() {
        
        @SuppressWarnings("unchecked")
        List <Fiche>  DaoAllFiche = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllFiche  = (List<Fiche>) session.createCriteria(Fiche.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllFiche;
    }

    @Override
    public void delete(Fiche fiche) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(fiche);
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
    public List <Fiche> getFicheParnService(int nService)
    {
        @SuppressWarnings("unchecked")
        List <Fiche>  DaoAllFicheService = null;
        Session session = sessionFactory.openSession();
        try  
        {
            System.out.println("Hatem Test 1635-------- getPatientParnService  attempt loading" );
            session.beginTransaction();
            DaoAllFicheService  = (List<Fiche>) session.createCriteria(Fiche.class).add( Restrictions.eq("service", nService ) ).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllFicheService;        
    }

    @Override
    public Map <String,Number> getFicheParCritere(String critere)
    {
        @SuppressWarnings("unchecked")
        List <Fiche>  DaoAllFicheService = null;
        Session session = sessionFactory.openSession();
        Map <String,Number> mp;
        mp = new HashMap <String,Number> ();
        try  
        {
            System.out.println("Hatem Test  getFicheParCritere  attempt loading" );
            session.beginTransaction();
       //     DaoAllFicheService  = (List<Fiche>) session.createCriteria(Fiche.class).add( Restrictions.eq(critere, value ) ).list();
       //     session.getTransaction().commit(); 
String SQL_QUERY = "SELECT " + critere + ",COUNT(" + critere + ") FROM Fiche GROUP BY " + critere ;
System.out.print(" SQL_QUERY = " + SQL_QUERY);
  Query query = (Query) session.createQuery(SQL_QUERY);

    
  for(Iterator it=query.iterate();it.hasNext();)
  {
   Object[] row = (Object[]) it.next();
   System.out.print("Valeur critere: " + row[0]);
   System.out.println(" | Number of critere: " + row[1]);
   mp.put((String) row[0], (Number)row[1]);
  }
  session.getTransaction().commit();

        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return mp;        
    }
    
    
    @Override
    public Map <String,String> getKM()
    {
        @SuppressWarnings("unchecked")
        List <Fiche>  DaoAllFicheService = null;
        Session session = sessionFactory.openSession();
        Map <String,String>  mp;
        mp = new HashMap <String,String>  ();
        try  
        {
            System.out.println("Hatem Test  getKM  attempt loading" );
            session.beginTransaction();
            String SQL_QUERY = "SELECT survieGlobale, statut, code FROM Fiche where statut <> '-1' and survieGlobale <> '-1' order by code " ;
            System.out.print(" SQL_QUERY = " + SQL_QUERY);
            Query query = (Query) session.createQuery(SQL_QUERY);

    
            for(Iterator it=query.iterate();it.hasNext();)
            {
             Object[] row = (Object[]) it.next();
             if ("Decede".equals(row[1].toString()))
                mp.put(String.valueOf(row[0]), "0");
             else 
                 mp.put(String.valueOf(row[0]), "1");
             
             
            }
            session.getTransaction().commit();

        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return mp;        
    }
    
}
