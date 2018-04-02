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

import static com.sun.javafx.logging.PulseLogger.addMessage;
import com.tfar.entity.Cousin;
import com.tfar.entity.Cytogenetique;
import com.tfar.services.FicheService;
import com.tfar.services.PatientService;
import com.tfar.services.HopitalService;
import com.tfar.services.ServiceService;
import com.tfar.services.MedecinService;

import com.tfar.entity.Fiche;
import com.tfar.entity.Frere;
import com.tfar.entity.Patient;
import com.tfar.entity.Hopitale;
import com.tfar.entity.Service;
import com.tfar.entity.Medecin;
import com.tfar.entity.Membre;
import com.tfar.services.CousinService;
import com.tfar.services.CytogenetiqueService;
import com.tfar.services.FrereService;
import com.tfar.services.MembreService;
import java.io.IOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Asus
 */

@ManagedBean (name="AjouterFicheBean")
@SessionScoped
public class AjouterFicheMBean implements Serializable {
    
     //inject spring bean via DI
    @ManagedProperty("#{HopitalService}")
    private HopitalService hopitalService;
    
    @ManagedProperty("#{ServiceService}")
    private ServiceService serviceService;
    
    @ManagedProperty("#{MedecinService}")
    private MedecinService medecinService;
    
    @ManagedProperty("#{FicheService}")
    private FicheService ficheService;
    
    @ManagedProperty("#{PatientService}")
    private PatientService patientService;    

    @ManagedProperty("#{CytogenetiqueService}")
    private CytogenetiqueService cytogenetiqueService;  
    
    @ManagedProperty("#{FrereService}")
    private FrereService frereService;
    
    @ManagedProperty("#{MembreService}")
    private MembreService membreService;    
    

    private Fiche newfiche = new Fiche();
    
    private Fiche fiche = new Fiche();
    
    @PostConstruct
    public void init() {
        // Put original constructor code here.
       
        System.out.println("*** Construction du FicheMBean ++++++ ");
        
    }
    

    public MembreService getMembreService() {
        return membreService;
    }

    public void setMembreService(MembreService membreService) {
        this.membreService = membreService;
    }

    public FrereService getFrereService() {
        return frereService;
    }

    public void setFrereService(FrereService frereService) {
        this.frereService = frereService;
    }

    public CousinService getCousinService() {
        return cousinService;
    }

    public void setCousinService(CousinService cousinService) {
        this.cousinService = cousinService;
    }
    
    @ManagedProperty("#{CousinService}")
    private CousinService cousinService;
    
    public String data = "1";
    public int nbFreres = 0; 
    public int nbCousins = 0 ;
    public int nbMembres = 0 ;


    public CytogenetiqueService getCytogenetiqueService() {
        return cytogenetiqueService;
    }

    public void setCytogenetiqueService(CytogenetiqueService cytogenetiqueService) {
        this.cytogenetiqueService = cytogenetiqueService;
    }
        


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }
    private Patient newpatient = new Patient();
    
    
    public List<String> values = new ArrayList();
    public List<Frere> freres = new ArrayList();
    public List<Cytogenetique> cytogenetiques = new ArrayList(4);
    public List<Cousin> cousins = new ArrayList();
    public List<Membre> membres = new ArrayList();

    public int getNbMembres() {
        return nbMembres;
    }

    public void setNbMembres(int nbMembres) {
        this.nbMembres = nbMembres;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    public int getNbFreres() {
        return nbFreres;
    }

    public void setNbFreres(int nbFreres) {
        this.nbFreres = nbFreres;
    }

    public int getNbCousins() {
        return nbCousins;
    }

    public void setNbCousins(int nbCousins) {
        this.nbCousins = nbCousins;
    }

    public List<Cousin> getCousins() {
        return cousins;
    }

    public void setCousins(List<Cousin> cousins) {
        this.cousins = cousins;
    }

    public List<Cytogenetique> getCytogenetiques() {
        return cytogenetiques;
    }

    public void setCytogenetiques(List<Cytogenetique> cytogenetiques) {
        this.cytogenetiques = cytogenetiques;
    }

    
    public List<Frere> getFreres() {
        return freres;
    }

    public void setFreres(List<Frere> freres) {
        this.freres = freres;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public Patient getNewpatient() {
        return newpatient;
    }

    public void setNewpatient(Patient newpatient) {
        this.newpatient = newpatient;
    }
    
    private List <Hopitale> ListHopitals;

    public void setListHopitals(List<Hopitale> ListHopitals) {
        this.ListHopitals = ListHopitals;
    }

    public void setListServices(List<Service> ListServices) {
        this.ListServices = ListServices;
    }

    public void setListMedecins(List<Medecin> ListMedecins) {
        this.ListMedecins = ListMedecins;
    }
    private List <Service> ListServices;
    private List <Medecin> ListMedecins;
    
    public List <Hopitale> getListHopitals()
    {
        return ListHopitals = hopitalService.getAllHopital();
    }
    
    public List <Service> getListServices ()
    {
        return  ListServices=serviceService.getAllService();
    }
    
    public List <Medecin> getListMedecins ()
    {
        return ListMedecins=medecinService.getAllMedecin();
    }
    

    public String ajouterFiche()  
    {  
        System.out.println("Saving new form ...."); 
         FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        System.out.println("CodeFiche ++++++ " + session.getAttribute("numdossier"));
        if(newfiche.getNDossier()!=null)
        {
        //hopitalService.add(newhopital); 
        //serviceService.add(newservice, newhopital);
        //medecinService.add(newmedecin, newservice); 
     //   int idhopital = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("hopital");
        //newfiche.setHopital(hopitals);
        System.out.println("Hopital =====> " + newfiche.getHopital() + "*******" );
        System.out.println("Service =====> " + newfiche.getService());
        System.out.println("Date enregistrement =====> " + newfiche.getDateEnregistrement());
        
        newfiche.setMedecin(String.valueOf(medecinService.getMedecinParNom(newfiche.getMedecin()).getCin()));
        
        ficheService.add(newfiche);
        newpatient.setNdossierP(newfiche.getNDossier());
        patientService.add(newpatient);
        
        if (!freres.isEmpty())
        {
            ListIterator<Frere> lf = freres.listIterator();
            while(lf.hasNext()){
                Frere f = lf.next();
                frereService.add(f);
            }
        }
            
        if (!cousins.isEmpty())
        {
            ListIterator<Cousin> lc = cousins.listIterator();
            while(lc.hasNext()){
                Cousin c = lc.next();
                cousinService.add(c);
            }
            
      }
        if (!cytogenetiques.isEmpty())
        {
            ListIterator<Cytogenetique> cys = cytogenetiques.listIterator();
            while(cys.hasNext()){
                Cytogenetique cy = cys.next();
                cytogenetiqueService.add(cy);
            }
            
      }
       
        if (!membres.isEmpty())
        {
            ListIterator<Membre> mems = membres.listIterator();
            while(mems.hasNext()){
                Membre m = mems.next();
                membreService.add(m);
            }
            
      }        

        System.out.println("File " +newfiche.getNDossier()+ " successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement de la fiche", "Enregistrée avec succès.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        //newhopital = new Hopital();
        //newservice = new Service();
        //newmedecin = new Medecin();
        }
        return "Welcome?faces-redirect=true";

    }
    public void treatnbfrere()
    {
        if (this.nbFreres != this.newfiche.getNbVivant() + newfiche.getNbMort())
        {
            freres = new ArrayList();
            this.nbFreres = this.newfiche.getNbVivant() + newfiche.getNbMort(); 
             System.out.println("updatenbvivant : Nombre vivant : " + String.valueOf(this.newfiche.getNbVivant()));
       
            for (int i = 0; i < this.newfiche.getNbVivant()+this.newfiche.getNbMort(); i++)
            {
                 System.out.println("Adding frere"+i);
                Frere f = new Frere();
                freres.add(f);
            }
        }
    }
    
    public void treatnbCousin()
    {
        System.out.println("Treat Cousins");
            cousins = new ArrayList();
            this.nbCousins = this.newfiche.getCousin(); 
             System.out.println("cousins :  " + this.nbCousins);       
            for (int i = 0; i < this.nbCousins; i++)
            {
                 System.out.println("Adding Cousins"+i);
                Cousin c = new Cousin();
                cousins.add(c);
            }
    }
    
    public void treatnbMembre()
    {
        System.out.println("Treat Membres");
            membres = new ArrayList();
            this.nbMembres = this.newfiche.getMembre(); 
             System.out.println("membres :  " + this.nbMembres);       
            for (int i = 0; i < this.nbMembres; i++)
            {
                 System.out.println("Adding Membres"+i);
                Membre m = new Membre();
                membres.add(m);
            }
    }
    
    public void validfreres()
    {

    }
    public void validcousins(){
        
    }
    public void validMembres()
    {

    }    
    public void treatCytogenetique()
    {
        System.out.println("Treat cytogenetique");
        for (int i=0; i<4; i++)
        {
            Cytogenetique c = new Cytogenetique();
            cytogenetiques.add(c);
        }
    }    

    public void formFrere()
    {
       // System.out.println("Form FRERE : Nombre vivant : " + String.valueOf(this.newfiche.getNbVivant()));
        System.out.println("coucou test");
    }
    public void submitFormFrere()
    {
        
        
    }    
 
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

    public MedecinService getMedecinService() {
        return medecinService;
    }

    public void setMedecinService(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    public FicheService getFicheService() {
        return ficheService;
    }

    public void setFicheService(FicheService ficheService) {
        this.ficheService = ficheService;
    }

   



    public Fiche getNewfiche() {
        return newfiche;
    }

    public void setNewfiche(Fiche newfiche) {
        this.newfiche = newfiche;
    }




    private String valueChange;

    public String getValueChange() {
        return valueChange;
    }

    public void setValueChange(String valueChange) {
        this.valueChange = valueChange;
    }
    
    public void handleChange(ValueChangeEvent event){  
    System.out.println("New value: " + event.getNewValue());
}
    
    public String ModifierFiche(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("codefiche"); 
        System.out.println("Fiche " + data +" successfully loaded" );
        
        newfiche=ficheService.getFicheParnDossier(data);
        newpatient=patientService.getPatientParnDossier(data);
        
        return "AjouterFiche?faces-redirect=true"; 
        
        
    }
        public void buttonAction(ActionEvent actionEvent) {
            System.out.println("Welcome to Primefaces!!");
        addMessage("Welcome to Primefaces!!");
        
    }
}
