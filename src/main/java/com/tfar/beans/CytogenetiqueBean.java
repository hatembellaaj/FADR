/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import com.tfar.entity.Cytogenetique;
import com.tfar.entity.Fiche;
import com.tfar.services.CytogenetiqueService;
import com.tfar.services.FicheService;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author hatem
 */
@SessionScoped
public class CytogenetiqueBean implements Serializable{

    @ManagedProperty("#{FicheService}")
    private FicheService ficheService;

    @ManagedProperty("#{FicheService}")
    private CytogenetiqueService cytogenetiqueService;
    
    private Fiche fiche = new Fiche();
    private List <Cytogenetique> listCytogenetiques;
    
    public String data = "1";
    private Cytogenetique newCytogenetique1 = new Cytogenetique();
    private Cytogenetique newCytogenetique2 = new Cytogenetique();
    private Cytogenetique newCytogenetique3 = new Cytogenetique();
    private Cytogenetique newCytogenetique4 = new Cytogenetique();
    
    private Cytogenetique cytogenetique = new Cytogenetique();
    
    public CytogenetiqueService getCytogenetiqueService() {
        return cytogenetiqueService;
    }

    public void setCytogenetiqueService(CytogenetiqueService cytogenetiqueService) {
        this.cytogenetiqueService = cytogenetiqueService;
    }

    public List<Cytogenetique> getListCytogenetiques() {
        return listCytogenetiques;
    }

    public void setListCytogenetiques(List<Cytogenetique> listCytogenetiques) {
        this.listCytogenetiques = listCytogenetiques;
    }

    public Cytogenetique getNewCytogenetique1() {
        return newCytogenetique1;
    }

    public void setNewCytogenetique1(Cytogenetique newCytogenetique1) {
        this.newCytogenetique1 = newCytogenetique1;
    }

    public Cytogenetique getNewCytogenetique2() {
        return newCytogenetique2;
    }

    public void setNewCytogenetique2(Cytogenetique newCytogenetique2) {
        this.newCytogenetique2 = newCytogenetique2;
    }

    public Cytogenetique getNewCytogenetique3() {
        return newCytogenetique3;
    }

    public void setNewCytogenetique3(Cytogenetique newCytogenetique3) {
        this.newCytogenetique3 = newCytogenetique3;
    }

    public Cytogenetique getNewCytogenetique4() {
        return newCytogenetique4;
    }

    public void setNewCytogenetique4(Cytogenetique newCytogenetique4) {
        this.newCytogenetique4 = newCytogenetique4;
    }

    public Cytogenetique getCytogenetique() {
        return cytogenetique;
    }

    public void setCytogenetique(Cytogenetique cytogenetique) {
        this.cytogenetique = cytogenetique;
    }

    public void update()
    {
        if (newCytogenetique1!= null)
            cytogenetiqueService.update(newCytogenetique1);
        if (newCytogenetique2!= null)
            cytogenetiqueService.update(newCytogenetique2);
        if (newCytogenetique3!= null)
            cytogenetiqueService.update(newCytogenetique3);
        if (newCytogenetique4!= null)
            cytogenetiqueService.update(newCytogenetique4);  
    }

   public String getData() {
      return this.data;
   }

   public void setData(String data) {
      this.data = data;
   }

    public FicheService getFicheService() {
        return ficheService;
    }

    public void setFicheService(FicheService ficheService) {
        this.ficheService = ficheService;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }
 

    
    public void addCytogenetique()  {  
        if (newCytogenetique1!= null)
            cytogenetiqueService.add(newCytogenetique1);
        if (newCytogenetique2!= null)
            cytogenetiqueService.add(newCytogenetique2);
        if (newCytogenetique3!= null)
            cytogenetiqueService.add(newCytogenetique3);
        if (newCytogenetique4!= null)
            cytogenetiqueService.add(newCytogenetique4); 
    }
        
    public void Delete(Cytogenetique cytogenetique)
    {
        String nDossier = fiche.getNDossier();
       //cytogenetiqueService.delete(cytogenetiqueService.getFicheParnDossier(nDossier));
   
    }
  
    
    
}
