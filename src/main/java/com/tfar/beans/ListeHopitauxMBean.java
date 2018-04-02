/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import com.tfar.entity.Hopitale;
import com.tfar.services.HopitalService;    
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

    
@ManagedBean (name="ListeHopitauxBean")
@SessionScoped
public class ListeHopitauxMBean implements Serializable{
    
    @ManagedProperty("#{HopitalService}")
    private HopitalService hopitalService;
    
    private Hopitale hopital = new Hopitale();
    private List <Hopitale> listHopitals;
    
    public String data = "1";
    private long minimum=200;    
    
    private Hopitale newhopital = new Hopitale();
    
    public List <Hopitale> getListHopitals ()
    {
        if (listHopitals==null)
        {
            setListHopitals(this.hopitalService.getAllHopital());
            System.out.println("Liste hopitux ...........Test");
        }
        System.out.println("Tentatives +++");
        return listHopitals;
    }    
    
    public void showResult(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("hopitale"); 
        System.out.println("Hopital " +data +" successfully loaded" );
        hopital = hopitalService.getHopitalParNom(data);
        //return "ChargerHopital?faces-redirect=true";
    }
        

   public void ShowResults (Hopitale hopital)
    {
        this.hopital = hopital;
        System.err.println("Hopital num: " + hopital.getNomHopitale());
    }
   
    
    public String update()
    {
        hopitalService.update(hopital);
        System.out.println("Hopital "+ hopital.getNomHopitale() +" successfully updated");
        
        return "Welcome?faces-redirect=true";
    }
   

   public String getData() {
      return this.data;
   }

   public void setData(String data) {
      this.data = data;
   }

    public HopitalService getHopitalService() {
        return hopitalService;
    }

    public void setHopitalService(HopitalService hopitalService) {
        this.hopitalService = hopitalService;
    }

    public Hopitale getHopital() {
        return hopital;
    }

    public void setHopital(Hopitale hopital) {
        this.hopital = hopital;
    }
    
    public void setListHopitals(List <Hopitale> listHopitals) {
        this.listHopitals = listHopitals;
    }
    public long getMinimum() {
        return (this.minimum);
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }
    
        public String add()  {  
        
        hopitalService.add(newhopital); 
        System.out.println("Hopital " +newhopital.getNomHopitale()+ " successfully saved.");   
        newhopital = new Hopitale();
        return "Welcome?faces-redirect=true";

    }
        
    public Hopitale getNewhopital() {
        return newhopital;
    }

    public void setNewhopital(Hopitale newhopital) {
        this.newhopital = newhopital;
    }     
    
    public void showResultloading(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("hopital"); 
        System.out.println("Hopital " +data +" successfully loaded" );
        hopital = hopitalService.getHopitalParNom(data);
        //return "ChargerHopital?faces-redirect=true";
    }

        public void showResultModification(){
       
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("hopital"); 
        System.err.println(data);
        hopital = hopitalService.getHopitalParNom(data);
        
        //return "ModifierHopital?faces-redirect=true";
    }    
        
        
    public void Delete(Hopitale hopital)
    {
        String nomHop = hopital.getNomHopitale();
        
        hopitalService.delete(hopitalService.getHopitalParNom(nomHop));
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "L'hopital "+ nomHop +" est supprimée avec succès" );  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        System.out.println("Hopital " +nomHop+ " successfully deleted.");
        
    }
    
    public String getHopitalParNum (Integer numHop){
        return hopitalService.getHopitalParNum(numHop).getNomHopitale();
    }
        
        
        
}