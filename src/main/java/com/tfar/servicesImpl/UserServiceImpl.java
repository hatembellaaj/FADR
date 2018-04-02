/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

import com.tfar.dao.UserDao;
import com.tfar.entity.User;

import com.tfar.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hatem
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void add(User newuser) {
        
        userDao.add(newuser);
    }

    @Override
    public void update(User user) {
        
        userDao.update(user);
    }


    @Override
    public User getUserParLogin(String loginUser) {
        
        return userDao.getUserParLogin(loginUser);
    }

    @Override
    public List <User> getAllUser(){
        
        return userDao.getAllUser();
    }

    @Override
    public User getUserParCode (Integer cUser) {
        return  userDao.getUserParCode(cUser);
    }
    
    @Override
    public User getUserByLoginPassword(String login, String password) {
        return  userDao.getUserByLoginPassword(login,password);
    }

    @Override
    public void delete(User user) {
        
        userDao.delete(user);
    }    




    
}
