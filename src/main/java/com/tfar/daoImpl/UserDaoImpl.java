/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.daoImpl;


import com.tfar.entity.User;
import java.util.List;

import com.tfar.dao.UserDao;
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
public class UserDaoImpl implements UserDao{
    
    private User newuser;
    private User user;
    
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    @Autowired
    private SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());
    
    
 
    @Override
    public List<User> getAllUser() {
        
        @SuppressWarnings("unchecked")
        List <User>  DaoAllUser = null;
        Session session = sessionFactory.openSession();
        try  
        {
            
            session.beginTransaction();
            DaoAllUser  = (List<User>) session.createCriteria(User.class).list();
            session.getTransaction().commit(); 
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return DaoAllUser;
    }    
    

    @Override
    public void add(User newuser) 
    {
        Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.saveOrUpdate(newuser);  
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
    public void update(User user) 
    {
        
         Session session = sessionFactory.openSession(); 
        try  
        {  
             
            // begin a transaction   
            session.beginTransaction();
            session.update(user);  
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
    public User getUserParLogin(String loginUser) {
        System.out.println(loginUser);


        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", loginUser));           
            user = (User) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return user;        
        
    }                
    
    
    @Override
    public User getUserParCode (Integer cUser){
        System.out.println(cUser);


        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("Code", cUser));           
            user = (User) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return user;        
        
    }     
    


    @Override
    public void delete(User user) {
        
        Session session = sessionFactory.openSession();  
        try            
        {
            session.beginTransaction();
            session.delete(user);
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
    public User getUserByLoginPassword(String login, String password) {
        System.out.println(login);
        System.out.println(password);

        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("Login", login));
            criteria.add(Restrictions.eq("Passwd", password));            
            user = (User) criteria.uniqueResult();
            session.getTransaction().commit();
            
        }
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        } 
        session.close();
        return user;        
        
    }    
    
}
