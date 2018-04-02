/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

/**
 *
 * @author hatem
 */

import com.tfar.entity.Fiche;

import com.tfar.services.FicheService;
import com.tfar.services.PatientService;
import com.tfar.services.HopitalService;
import com.tfar.services.ServiceService;

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


@ManagedBean (name="ListeFichesBean")
@SessionScoped

public class ListeFichesMBean implements Serializable{

    @ManagedProperty("#{FicheService}")
    private FicheService ficheService;

    @ManagedProperty("#{PatientService}")
    private PatientService patientService;

    @ManagedProperty("#{HopitalService}")
    private HopitalService hopitalService;    

    public HopitalService getHopitalService() {
        return hopitalService;
    }

    public void setHopitalService(HopitalService hopitalService) {
        this.hopitalService = hopitalService;
    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
    
    @ManagedProperty("#{ServiceService}")
    private ServiceService serviceService;    
    
    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
    
    private Fiche fiche = new Fiche();
    private List <Fiche> listFiches;
    
    public String data = "1";
   
    
    private Fiche newfiche = new Fiche();
    
    public List <Fiche> getListFiches ()
    {
        if (listFiches==null)
            setListFiches(this.ficheService.getAllFiche());
        return listFiches;
    }    
    
    public void showResult(){        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("fiche"); 
        System.out.println("Fiche " +data +" successfully loaded" );
        fiche = ficheService.getFicheParnDossier(data);
        //return "ChargerHopital?faces-redirect=true";
    }
        

   public void ShowResults (Fiche fiche)
    {
        this.fiche = fiche;
        System.err.println("Medecin num: " + fiche.getNDossier());
    }
   
    
    public String update()
    {
        ficheService.update(fiche);
        System.out.println("fiche "+ fiche.getNDossier() +" successfully updated");
        
        return "Welcome?faces-redirect=true";
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
    
    public void setListFiches(List <Fiche> listFiches) {
        this.listFiches = listFiches;
    }

    
    public String addFiche()  {  
         
       
        ficheService.add(newfiche); 
        System.out.println("Fiche " +newfiche.getNDossier()+ " successfully saved.");   
        newfiche = new Fiche();
        return "Welcome?faces-redirect=true";

    }
        
    public Fiche getNewfiche() {
        return newfiche;
    }

    public void setNewfiche(Fiche newfiche) {
        this.newfiche = newfiche;
    }     
    
    public void showResultloading(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("fiche"); 
        System.out.println("Fiche " +data +" successfully loaded" );
        fiche = ficheService.getFicheParnDossier(data);
        //return "ChargerHopital?faces-redirect=true";
    }

        public void showResultModification(){
       
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("fiche"); 
        System.err.println(data);
        fiche = ficheService.getFicheParnDossier(data);
        
        //return "ModifierHopital?faces-redirect=true";
    }    
        
        
    public void Delete(Fiche fiche)
    {
        String nDossier = fiche.getNDossier();
        ficheService.delete(ficheService.getFicheParnDossier(nDossier));
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "La Fiche "+ nDossier +" est supprimée avec succès" );  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        System.out.println("Fiche " +nDossier+ " successfully deleted.");
        
    }
    public String getNomPatientParnDossier(String nDossier)
    {
        return patientService.getPatientParnDossier(nDossier).getNom();
    }
    public String getPrenomPatientParnDossier(String nDossier)
    {
        return patientService.getPatientParnDossier(nDossier).getPrenom();
    }
    public String getNomServiceParNService(int numService)
    {
        System.out.println("ListeFicheMBean - numService : " + numService);
        return serviceService.getServiceParNum(numService).getNomService();
        //return "test";
    }    
    public String getNomHopitalParNHopital(int numHopital)
    {
        System.out.println("ListeFicheMBean - numHopital : " + numHopital);
        return hopitalService.getHopitalParNum(numHopital).getNomHopitale();
        //return "test";
    }        
    
    
}

