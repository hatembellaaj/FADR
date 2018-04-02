/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import com.tfar.entity.Fiche;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hatem
 */
@ManagedBean (name="TestBean")
@SessionScoped
public class TestBean implements Serializable {
    
    private String coucou ;
    private Fiche newfiche = new Fiche();

    public Fiche getNewfiche() {
        return newfiche;
    }

    public void setNewfiche(Fiche newfiche) {
        this.newfiche = newfiche;
    }

    public String getCoucou() {
        return coucou;
    }

    public void setCoucou(String coucou) {
        this.coucou = coucou;
    }

    public void add()
    {
        System.out.println("It is a great day :) new fiche : " + newfiche.getNDossier());
    }
    
}
