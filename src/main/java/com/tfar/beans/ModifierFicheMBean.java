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

import com.tfar.entity.Cousin;
import com.tfar.entity.Cytogenetique;
import com.tfar.entity.Androgene;
import com.tfar.services.FicheService;
import com.tfar.services.PatientService;
import com.tfar.services.HopitalService;
import com.tfar.services.ServiceService;
import com.tfar.services.MedecinService;

import com.tfar.entity.Fiche;
import com.tfar.entity.Frere;
import com.tfar.entity.CousinPK;
import com.tfar.entity.FrerePK;
import com.tfar.entity.Patient;
import com.tfar.entity.Hopitale;
import com.tfar.entity.Service;
import com.tfar.entity.Medecin;
import com.tfar.entity.Membre;
import com.tfar.services.CousinService;
import com.tfar.services.CytogenetiqueService;
import com.tfar.services.AndrogeneService;
import com.tfar.services.FrereService;
import com.tfar.services.MembreService;
import com.tfar.entity.CytogenetiquePK;
import com.tfar.entity.AndrogenePK;


import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Asus
 */

@ManagedBean (name="ModifierFicheBean")
@SessionScoped
public class ModifierFicheMBean implements Serializable {
    
     //inject spring bean via DI
    @ManagedProperty("#{HopitalService}")
    private HopitalService hopitalService;

    public String getMedecin() {
        return medecin;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }
    
    public String getNomMedecin()
    {
        System.out.println("Nom Medecin : " + medecinService.getMedecinParCIN(Integer.valueOf(newfiche.getMedecin())).getNomMedecin());
        return medecinService.getMedecinParCIN(Integer.valueOf(newfiche.getMedecin())).getNomMedecin();
    }
    
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
    
    @ManagedProperty("#{AndrogeneService}")
    private AndrogeneService androgeneService;


    
    @ManagedProperty("#{FrereService}")
    private FrereService frereService;

    @ManagedProperty("#{CousinService}")
    private CousinService cousinService;
    
    public String hopital;
    public String service; 
    public String medecin;

    public CousinService getCousinService() {
        return cousinService;
    }

    public void setCousinService(CousinService cousinService) {
        this.cousinService = cousinService;
    }
    
    public FrereService getFrereService() {
        return frereService;
    }

    public void setFrereService(FrereService frereService) {
        this.frereService = frereService;
    }

    public MembreService getMembreService() {
        return membreService;
    }

    public void setMembreService(MembreService membreService) {
        this.membreService = membreService;
    }
    
    @ManagedProperty("#{MembreService}")
    private MembreService membreService;     
    
    public String data = "1";
    public int nbFreres = 0; 
    public int nbFreresUpdate=0;
    public int nbCousins = 0 ;
    public int nbCousinsUpdate = 0 ;
    public int nbMembres = 0 ;
    public int nbMembresUpdate = 0 ;
    
    public int nbCytogenetiques = 0; 
    public int nbAndrogenes = 0; 
    

    public CytogenetiqueService getCytogenetiqueService() {
        return cytogenetiqueService;
    }

    public void setCytogenetiqueService(CytogenetiqueService cytogenetiqueService) {
        this.cytogenetiqueService = cytogenetiqueService;
    }
        
    private Fiche newfiche = new Fiche();
    private Fiche fiche = new Fiche();

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
    public List<Cytogenetique> cytogenetiques = new ArrayList();
    public List<Androgene> androgenes = new ArrayList();
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

    
    public List<Androgene> getAndrogenes() {
        return androgenes;
    }

    public void setAndrogenes(List<Androgene> androgenes) {
        this.androgenes = androgenes;
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
    

    public String update()  
    {  

        System.out.println("File " +newfiche.getNDossier()+ " starting update.");
        //hopitalService.add(newhopital); 
        //serviceService.add(newservice, newhopital);
        //medecinService.add(newmedecin, newservice); 
   //     newfiche.setMedecin(String.valueOf(medecinService.getMedecinParNom(newfiche.getMedecin()).getCin()));
        
             
        ficheService.update(newfiche);
        patientService.update(newpatient);
        System.out.println("Freres : "+freres.toString());

         
        System.out.println("File " +newfiche.getNDossier()+ " successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement de la fiche", "Enregistrée avec succès.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        //newhopital = new Hopital();
        //newservice = new Service();
        //newmedecin = new Medecin();

        return "Welcome?faces-redirect=true";

    }
    public void treatnbfrere()
    { 

        int nbTraitement = 0; 
        System.out.println("......treatnbfrere ...");
        //freres = frereService.getListFrereParnDossier(newfiche.getNDossier());
        this.nbFreresUpdate =  (this.newfiche.getNbVivant() + newfiche.getNbMort()) - this.nbFreres;
        System.out.println("......nbFreresUpdate =  " + nbFreresUpdate);
        if (this.nbFreres < this.newfiche.getNbVivant() + newfiche.getNbMort())
            if (freres ==null)
            {
                freres = new ArrayList<Frere>();
                System.out.println("......Traitement : freres = new ArrayList(); ...");
                nbTraitement = this.newfiche.getNbVivant() + newfiche.getNbMort();
            }
            else
                nbTraitement =  (this.newfiche.getNbVivant()+this.newfiche.getNbMort()) - this.nbFreres;
                
        for (int i = 0; i < nbTraitement; i++)
        {
            System.out.println("Adding frere"+i);
            Frere f = new Frere();
            //f.setPrenomfrere("Test "+i);
            freres.add(f);
        } 
        
        
        System.out.println("updatenbvivant : Nombre vivant : " + String.valueOf(this.newfiche.getNbVivant()));
    }
    
    public void treatnbCousin()
    {
        System.out.println("Modifier Fiche - Treat Cousins");
        cousins = cousinService.getListCousinParnDossier(newfiche.getNDossier());
        System.out.println("Modifier Fiche - Treat Cousins for update");            

        int nbTraitement = 0; 
        System.out.println("......treatnbCousin ...");
        
        this.nbCousinsUpdate =  this.newfiche.getCousin() - this.nbCousins;
        System.out.println("......nbCousinsUpdate =  " + nbCousinsUpdate);
        if (this.nbCousinsUpdate > 0)
            if (cousins ==null)
                cousins = new ArrayList<Cousin>();
                System.out.println("......Traitement : cousins = new ArrayList(); ...");
                nbTraitement = this.newfiche.getCousin();
                
        for (int i = 0; i < this.nbCousinsUpdate; i++)
        {
            System.out.println("Adding frere"+i);
            Cousin c = new Cousin();
            cousins.add(c);
        } 
        
        
        System.out.println("Update cousins : " + String.valueOf(this.nbCousinsUpdate));







    }
    
    public void treatnbMembre()
    {
        System.out.println("Modifier Membres - Treat Nb Membre");
        membres = membreService.getListMembreParnDossier(newfiche.getNDossier());
        System.out.println("Modifier Membres - Treat membre for update");    
    }
    
    public int validfreres()
    {
        if (!freres.isEmpty())
        {
            ListIterator<Frere> lf = freres.listIterator();
            int i=0;
            System.out.println("Nombre FRERES : "+ freres.size());
            System.out.println("FRERES : "+freres.toString());
            while(lf.hasNext()){
                Frere f = lf.next();
                System.out.println("nbFreres "+this.nbFreres);
                if (i< this.nbFreres )
                {
                    FrerePK fpk = new FrerePK(this.newfiche.getnDossier(),f.getPlacefratrie());
                    f.setFrerePK(fpk);
                    frereService.update(f);
                    System.out.println("Update frere "+f.getPrenomfrere());
                }
                else
                {
                    System.out.println("Num Dossier :"+this.newfiche.getnDossier());
                    System.out.println("Place Fraterie :"+f.getPlacefratrie());
                    System.out.println("Before Adding frere "+f.getPrenomfrere());
                    FrerePK fpk = new FrerePK(this.newfiche.getnDossier(),f.getPlacefratrie());
                    f.setFrerePK(fpk);
                    frereService.add(f);
                    System.out.println("Add frere "+f.getPrenomfrere());
                }
                i++;
            }
        this.nbFreres = this.newfiche.getNbVivant() + newfiche.getNbMort();
        System.out.println("MAJ nb frere "+this.nbFreres);
        }
        RequestContext.getCurrentInstance().closeDialog(null);
        return 0; 

    }
    public void validcousins(){
        
        if (!cousins.isEmpty())
        {
            ListIterator<Cousin> lc = cousins.listIterator();
            int i=0;
            System.out.println("Nombre Cousins : "+ cousins.size());
            System.out.println("COUSINS : "+cousins.toString());
            while(lc.hasNext()){
                Cousin c = lc.next();
                System.out.println("nbCousins "+this.nbCousins);
                if (i< this.nbCousins )
                {
                    CousinPK cpk = new CousinPK(this.newfiche.getnDossier(),c.getCousinPK().getIdCousin());
                    c.setCousinPK(cpk);
                    cousinService.update(c);
                    System.out.println("Update cousin "+c.getPrenomCousin());
                }
                else
                {
                    System.out.println("Num Dossier :"+this.newfiche.getnDossier());
                    System.out.println("Place Cousin :"+c.getPlaceCousin());
                    System.out.println("Before Adding cousin "+c.getPrenomCousin());
                    CousinPK cpk = new CousinPK(this.newfiche.getnDossier(),i);
                    c.setCousinPK(cpk);
                    cousinService.add(c);
                    System.out.println("Add cousin "+c.getPrenomCousin());
                }
                i++;
            }
        
        
        }
        RequestContext.getCurrentInstance().closeDialog(null);
  
    }
    public void validMembres()
    {

    } 
    
    
    public int validCytogenetique()
    {
        
        if (!cytogenetiques.isEmpty())
        {
            ListIterator<Cytogenetique> lc = cytogenetiques.listIterator();
            int i=0;
            System.out.println("Nombre cytogenetiques : "+ cytogenetiques.size());
            System.out.println("cytogenetiques : "+cytogenetiques.toString());
            while(lc.hasNext()){
                Cytogenetique c = lc.next();
                System.out.println("nbCytogenetiques "+this.nbCytogenetiques);
                if (i< this.nbCytogenetiques )
                {
                    CytogenetiquePK cpk = new CytogenetiquePK(this.newfiche.getnDossier(),i+1);
                    c.setCytogenetiquePK(cpk);                    
                    cytogenetiqueService.update(c);
                    System.out.println("Update Cytogenetique "+c.getCytogenetiquePK().getNEtudeCyto());
                }
                else
                {
                    System.out.println("Nouvelles données cytogénétiques");

                    CytogenetiquePK cpk = new CytogenetiquePK(this.newfiche.getnDossier(),i+1);
                    c.setCytogenetiquePK(cpk);
                    cytogenetiqueService.add(c);
                    System.out.println("Add cytogenetique "+c.getCytogenetiquePK().toString());
                }
                i++;
            }
        this.nbCytogenetiques = cytogenetiques.size() ;
        System.out.println("MAJ nb cytogenetique "+this.nbCytogenetiques);
        }
        RequestContext.getCurrentInstance().closeDialog(null);
        return 0; 

    }  
    
    public void treatAndrogene()
    {
        int i;
        for (i=0; i<this.nbAndrogenes; i++)
        {
            Androgene a = androgenes.get(i);
            System.out.println("Date : " + a.toString());
        }        
        for (int j=i; j<30; j++)
        {
            Androgene a = new Androgene();
            androgenes.add(a);
        }
        System.out.println("Treat Androgene => Open dialog");
    }      
    
        public int validAndrogene()
    {
        
        if (!androgenes.isEmpty())
        {
            ListIterator<Androgene> la = androgenes.listIterator();
            int i=0;
            System.out.println("Nombre androgenes : "+ androgenes.size());
            System.out.println("androgenes : "+androgenes.toString());
            while(la.hasNext()){
                Androgene a = la.next();
                System.out.println("nbAndrogenes "+this.nbAndrogenes);
                if (i< this.nbAndrogenes )
                {
                    //AndrogenePK apk = new AndrogenePK(this.newfiche.getnDossier(),i+3);
                    AndrogenePK apk;
                    if (i==0)
                        apk = new AndrogenePK(this.newfiche.getnDossier(),3);
                    else
                        apk = new AndrogenePK(this.newfiche.getnDossier(),6*i);
                    a.setAndrogenePK(apk);                    
                    androgeneService.update(a);
                    System.out.println("Update Androgene "+a.getAndrogenePK().getMois());
                }
                else
                {
                    System.out.println("Nouvelles données cytogénétiques");
                    AndrogenePK apk;
                    if (i==0)
                        apk = new AndrogenePK(this.newfiche.getnDossier(),3);
                    else
                        apk = new AndrogenePK(this.newfiche.getnDossier(),6*i);
                    
                    a.setAndrogenePK(apk);                    
                    androgeneService.add(a);
                    System.out.println("Add Androgene "+a.getAndrogenePK().getMois());
                }
                i++;
            }
        this.nbAndrogenes = androgenes.size() ;
        System.out.println("MAJ nb androgenes "+this.nbAndrogenes);
        }
        RequestContext.getCurrentInstance().closeDialog(null);
        return 0; 

    }  
    
    public void treatCytogenetique()
    {
        int i;
        for (i=0; i<this.nbCytogenetiques; i++)
        {
            Cytogenetique c = cytogenetiques.get(i);
            System.out.println("Date : " + c.toString());
        }        
        for (int j=i; j<4; j++)
        {
            Cytogenetique c = new Cytogenetique();
            cytogenetiques.add(c);
        }
        System.out.println("Treat cytogenetique => Open dialog");
    }    

    public void formFrere()
    {
        System.out.println("Form FRERE : Nombre vivant : " + String.valueOf(this.newfiche.getNbVivant()));
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
        System.out.println("getListFrereParnDossier(" + frereService.toString());
        freres = frereService.getListFrereParnDossier(data);
        this.nbFreres = freres.size();
        
        cousins = cousinService.getListCousinParnDossier(data);
        this.nbCousins= cousins.size();
        
        membres = membreService.getListMembreParnDossier(data);
        this.nbMembres = membres.size();
        
        hopital = hopitalService.getHopitalParNum(newfiche.getHopital()).getNomHopitale();
        service = serviceService.getServiceParNum(newfiche.getService()).getNomService();
        
        
        this.cytogenetiques = cytogenetiqueService.getListCytogenetiqueParnDossier(data);
        this.nbCytogenetiques = this.cytogenetiques.size();
        
        this.androgenes = androgeneService.getListAndrogeneParnDossier(data);
        this.nbAndrogenes = this.androgenes.size();
        
        System.out.println("***** MEDECIN = " + newfiche.getMedecin());
        medecin = medecinService.getMedecinParCIN(Integer.valueOf(newfiche.getMedecin())).getNomMedecin();
                
        System.out.println("Hopital =======" + hopital);
        //return "ModifierFiche?faces-redirect=true"; 
        return "modifyTest?faces-redirect=true"; 
        
        
    }

    public String getHopital() {
        return hopital;
    }

    public void setHopital(String hopital) {
        this.hopital = hopital;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    public void converter(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        //data =  params.get("codefiche"); 
        //System.out.println("Fiche " + data +" successfully loaded" );
        
    }
    
    public boolean checkboxConverter(String value){
        String str = new String("oui");
        System.out.println("check box converter : " + value + "compare " + value.compareTo(str) );

        return value.compareTo(str)==1;
        
        
    }
    
    public AndrogeneService getAndrogeneService() {
        return androgeneService;
    }

    public void setAndrogeneService(AndrogeneService androgeneService) {
        this.androgeneService = androgeneService;
    }
}
