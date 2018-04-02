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
import com.tfar.entity.Patient;

import com.tfar.services.PatientService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;


@ManagedBean (name="ListePatientsBean")
@SessionScoped

public class ListePatientsMBean implements Serializable{

    @ManagedProperty("#{PatientService}")
    private PatientService patientService;
    
    private Patient patient = new Patient();
    private List <Patient> listPatients;
    
    public String data = "1";
   
    
    private Patient newPatient = new Patient();
    
    public List <Patient> getListPatients ()
    {
        if (listPatients==null)
            setListPatients(this.patientService.getAllPatient());
        return listPatients;
    }    
    
    public void showResult(){        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("patient"); 
        System.out.println("Patient " +data +" successfully loaded" );
        patient = patientService.getPatientParnDossier(data);
        //return "ChargerHopital?faces-redirect=true";
    }
        

   public void ShowResults (Patient patient)
    {
        this.patient = patient;
        System.err.println("Patient num: " + patient.getNdossierP());
    }
   
    
    public String update()
    {
        patientService.update(patient);
        System.out.println("Patient "+ patient.getNdossierP() +" successfully updated");
        
        return "Welcome?faces-redirect=true";
    }
   

   public String getData() {
      return this.data;
   }

   public void setData(String data) {
      this.data = data;
   }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public void setListPatients(List <Patient> listPatients) {
        this.listPatients = listPatients;
    }

/*    
    public String addPatient()  {  
         
       
        patientService.add(newPatient); 
        System.out.println("Patient " +newPatient.getNdossierP()+ " successfully saved.");   
        newPatient = new Patient();
        return "Welcome?faces-redirect=true";

    }
*/        
    public Patient getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(Patient newPatient) {
        this.newPatient = newPatient;
    }     
    
    public void showResultloading(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("patient"); 
        System.out.println("Patient " +data +" successfully loaded" );
        patient = patientService.getPatientParnDossier(data);
        //return "ChargerHopital?faces-redirect=true";
    }

        public void showResultModification(){
       
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("patient"); 
        System.err.println(data);
        patient = patientService.getPatientParnDossier(data);
        
        //return "ModifierHopital?faces-redirect=true";
    }    
        
        
    public void Delete(Patient patient)
    {
        String nDossier = patient.getNdossierP();
        patientService.delete(patientService.getPatientParnDossier(data));
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "La Fiche "+ nDossier +" est supprimée avec succès" );  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        System.out.println("Patient " +nDossier+ " successfully deleted.");
        
    }
        


}

