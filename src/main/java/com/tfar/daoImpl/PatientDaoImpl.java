/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;

import com.tfar.dao.*;


import com.tfar.entity.Patient;
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
public class PatientDaoImpl implements PatientDao{

    private Patient newPatient;
    private Patient patient;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
            
    @Override
    public void add(Patient newPatient) {
        
        Session session = sessionFactory.openSession(); 
        try  
        {  
           
            // begin a transaction   
            session.beginTransaction();            
            
            session.save(newPatient);  
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
    public void update(Patient patient) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(patient);  
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
    public Patient getPatientParnDossier(String ndossierP) {
        
        Patient patient=null;
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Patient.class);
            criteria.add(Restrictions.eq("ndossierP", ndossierP));
            patient = (Patient) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return patient;
    }

    @Override
    public List<Patient> getAllPatient() {
        
        @SuppressWarnings("unchecked")
        List <Patient>  DaoAllPatient = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllPatient  = (List<Patient>) session.createCriteria(Patient.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllPatient;
    }

    @Override
    public void delete(Patient patient) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(patient);
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
    public Map <String,Number> getPatientParCritere(String critere)
    {
        @SuppressWarnings("unchecked")
        List <Patient>  DaoAllPatientService = null;
        Session session = sessionFactory.openSession();
        Map <String,Number> mp;
        mp = new HashMap <String,Number> ();
        try  
        {
            System.out.println("Hatem Test  getPatientParCritere  attempt loading" );
            session.beginTransaction();
       //     DaoAllFicheService  = (List<Fiche>) session.createCriteria(Fiche.class).add( Restrictions.eq(critere, value ) ).list();
       //     session.getTransaction().commit(); 
String SQL_QUERY = "SELECT " + critere + ",COUNT(" + critere + ") FROM Patient GROUP BY " + critere ;
System.out.print(" SQL_QUERY = " + SQL_QUERY);
  Query query = (Query) session.createQuery(SQL_QUERY);

    
  for(Iterator it=query.iterate();it.hasNext();)
  {
   Object[] row = (Object[]) it.next();
   System.out.print("Valeur critere: " + row[0]);
   System.out.println(" | Number of critere: " + row[1]);
   mp.put(String.valueOf(row[0]), (Number)row[1]);
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
