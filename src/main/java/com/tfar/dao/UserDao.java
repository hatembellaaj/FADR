/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.dao;

/**
 *
 * @author hatem
 */
import com.tfar.entity.User;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface UserDao {
    
    public List <User> getAllUser();
    
    public void add(User newuser);
    
    public void update(User user);
    
    public User getUserParLogin(String loginUser);
    
    public User getUserParCode (Integer cUser);
    
  
    
    public void delete(User user);

    public User getUserByLoginPassword(String login, String password); 
}