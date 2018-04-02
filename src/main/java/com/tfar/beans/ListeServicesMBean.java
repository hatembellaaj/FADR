/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import com.tfar.entity.Service;
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

/**
 *
 * @author hatem
 */

@ManagedBean (name="ListeServicesBean")
@SessionScoped
public class ListeServicesMBean implements Serializable{
    
    @ManagedProperty("#{ServiceService}")
    private ServiceService serviceService;
    
    private Service service = new Service();
    private List <Service> listServices;
    
    public String data = "1";
    private long minimum=200;    
    
    private Service newservice = new Service();
    
    public List <Service> getListServices ()
    {
        if (listServices==null)
        {
            setListServices(this.serviceService.getAllService());
            
        }
        
        return listServices;
    }    
    
    public void showResult(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("service"); 
        System.out.println("Service " +data +" successfully loaded" );
        service = serviceService.getServiceParNom(data);
        //return "ChargerHopital?faces-redirect=true";
    }
        

   public void ShowResults (Service service)
    {
        this.service = service;
        System.err.println("Service num: " + service.getNomService());
    }
   
    
    public String update()
    {
        serviceService.update(service);
        System.out.println("Service "+ service.getNomService() +" successfully updated");
        
        return "Welcome?faces-redirect=true";
    }
   

   public String getData() {
      return this.data;
   }

   public void setData(String data) {
      this.data = data;
   }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    public void setListServices(List <Service> listServices) {
        this.listServices = listServices;
    }
    public long getMinimum() {
        return (this.minimum);
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }
    
        public String add()  {  
        
        serviceService.add(newservice); 
        System.out.println("Hopital " +newservice.getNomService()+ " successfully saved.");   
        newservice = new Service();
        return "Welcome?faces-redirect=true";

    }
        
    public Service getNewservice() {
        return newservice;
    }

    public void setNewservice(Service newservice) {
        this.newservice = newservice;
    }     
    
    public void showResultloading(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("service"); 
        System.out.println("Service " +data +" successfully loaded" );
        service = serviceService.getServiceParNom(data);
        //return "ChargerHopital?faces-redirect=true";
    }

        public void showResultModification(){
       
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("service"); 
        System.err.println(data);
        service = serviceService.getServiceParNom(data);
        
        //return "ModifierHopital?faces-redirect=true";
    }    
        
        
    public void Delete(Service service)
    {
        String nomService = service.getNomService();
        
        serviceService.delete(serviceService.getServiceParNom(nomService));
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Supprimer", "le service "+ nomService +" est supprimée avec succès" );  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        System.out.println("Service " +nomService+ " successfully deleted.");
        
    }
        
        
        
}
