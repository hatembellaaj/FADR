/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import com.tfar.entity.Medecin;

import com.tfar.services.MedecinService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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


/**
 *
 * @author hatem
 */

@ManagedBean (name="ListeMedecinsBean")
@SessionScoped

public class ListeMedecinsMBean implements Serializable{

    @ManagedProperty("#{MedecinService}")
    private MedecinService medecinService;
    
    private Medecin medecin = new Medecin();
    private List <Medecin> listMedecins;
    
    public String data = "1";
    private long minimum=200;    
    
    private Medecin newmedecin = new Medecin();
    
    private static final int BUFFER_SIZE = 6124;    


    
    public  FileUploadView fuv;

    public void setFuv(FileUploadView fuv) {
        this.fuv = fuv;
    }

    public FileUploadView getFuv() {
        return fuv;
    }
    
    public List <Medecin> getListMedecins ()
    {
        if (listMedecins==null)
            setListMedecins(this.medecinService.getAllMedecin());
        return listMedecins;
    }    
    
    public void showResult(){        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("medecin"); 
        System.out.println("Medecin " +data +" successfully loaded" );
        medecin = medecinService.getMedecinParNom(data);
        //return "ChargerHopital?faces-redirect=true";
    }
        

   public void ShowResults (Medecin medecin)
    {
        this.medecin = medecin;
        System.err.println("Medecin num: " + medecin.getCin());
    }
   
    
    public String update()
    {
        medecinService.update(medecin);
        System.out.println("Medecin "+ medecin.getNomMedecin() +" successfully updated");
        
        return "Welcome?faces-redirect=true";
    }
   

   public String getData() {
      return this.data;
   }

   public void setData(String data) {
      this.data = data;
   }

    public MedecinService getMedecinService() {
        return medecinService;
    }

    public void setMedecinService(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
    
    public void setListMedecins(List <Medecin> listMedecins) {
        this.listMedecins = listMedecins;
    }
    public long getMinimum() {
        return (this.minimum);
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }
    
    public String addMedecin(FileUploadView f)  {  
         
        this.handleFileUpload();
        medecinService.add(newmedecin); 
        System.out.println("Medecin " +newmedecin.getNomMedecin()+ " successfully saved.");   
        newmedecin = new Medecin();
        return "Welcome?faces-redirect=true";

    }
        
    public Medecin getNewmedecin() {
        return newmedecin;
    }

    public void setNewmedecin(Medecin newmedecin) {
        this.newmedecin = newmedecin;
    }     
    
    public void showResultloading(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("medecin"); 
        System.out.println("Medecin " +data +" successfully loaded" );
        medecin = medecinService.getMedecinParNom(data);
        //return "ChargerHopital?faces-redirect=true";
    }

        public void showResultModification(){
       
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("medecin"); 
        System.err.println(data);
        medecin = medecinService.getMedecinParNom(data);
        
        //return "ModifierHopital?faces-redirect=true";
    }    
        
        
    public void Delete(Medecin medecin)
    {
        Integer cinMedecin = medecin.getCin();
        String nomMedecin = medecin.getNomMedecin();
        medecinService.delete(medecinService.getMedecinParCIN(cinMedecin));
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "Le Medecin "+ nomMedecin +" est supprimée avec succès" );  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        System.out.println("Medecin " +nomMedecin+ " successfully deleted.");
        
    }
        
   public void handleFileUpload() {
       
    File fff = new File("/Users/hatem/NetBeansProjects/TFAR/target/TFAR-2.0/files/temp.png");
    try {

    FileInputStream fileInputStream = new FileInputStream(fff);
    int byteLength=(int)fff.length(); //bytecount of the file-content
    byte[] filecontent = new byte[byteLength];
    fileInputStream.read(filecontent,0,byteLength); 
    newmedecin.setImage(filecontent);
                } catch (IOException e) {
                e.printStackTrace();

                FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                               "The files were not uploaded!", "");
                FacesContext.getCurrentInstance().addMessage(null, error);
            }       
   }
}
