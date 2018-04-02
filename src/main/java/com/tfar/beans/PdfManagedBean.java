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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.tfar.entity.Cousin;
import com.tfar.entity.Cytogenetique;
import com.tfar.services.FicheService;

import com.tfar.services.HopitalService;
import com.tfar.services.ServiceService;


import com.tfar.entity.Fiche;
import com.tfar.entity.Frere;
import com.tfar.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;

import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.BaseFont;
import static com.lowagie.text.pdf.PdfDictionary.FONT;
import com.lowagie.text.pdf.PdfFormField;

import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RadioCheckField;


import com.tfar.services.MedecinService;
import com.tfar.services.PatientService;


/**
 *
 * @author hatem
 */
@ManagedBean(name = "pdfMB")
@ViewScoped
public class PdfManagedBean implements Serializable {
    
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

    public FicheService getFicheService() {
        return ficheService;
    }

    public void setFicheService(FicheService ficheService) {
        this.ficheService = ficheService;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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




    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<Frere> getFreres() {
        return freres;
    }

    public void setFreres(List<Frere> freres) {
        this.freres = freres;
    }

    public List<Cytogenetique> getCytogenetiques() {
        return cytogenetiques;
    }

    public void setCytogenetiques(List<Cytogenetique> cytogenetiques) {
        this.cytogenetiques = cytogenetiques;
    }

    public List<Cousin> getCousins() {
        return cousins;
    }

    public void setCousins(List<Cousin> cousins) {
        this.cousins = cousins;
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
    
    @ManagedProperty("#{ServiceService}")
    private ServiceService serviceService;

    @ManagedProperty("#{MedecinService}")
    private MedecinService medecinService;

    public MedecinService getMedecinService() {
        return medecinService;
    }

    public void setMedecinService(MedecinService medecinService) {
        this.medecinService = medecinService;
    }
    
    @ManagedProperty("#{FicheService}")
    private FicheService ficheService;
    @ManagedProperty("#{PatientService}")
    private PatientService patientService;   

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
   

 
    



   
    
    public String data = "1";
    public int nbFreres = 0; 
    public int nbCousins = 0 ;

    

    private Fiche fiche = new Fiche();
    private Patient patient = new Patient();    
    
    public List<String> values = new ArrayList();
    public List<Frere> freres = new ArrayList();
    public List<Cytogenetique> cytogenetiques = new ArrayList(4);
    public List<Cousin> cousins = new ArrayList();
   
    
    public String hopital;
    public String service; 
    @PostConstruct
    public void init() {

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
        data =  params.get("codefiche"); 
        System.out.println("Fiche " + data +" successfully loaded" );
        
        fiche=ficheService.getFicheParnDossier(data);
        patient=patientService.getPatientParnDossier(data);



        
        hopital = hopitalService.getHopitalParNum(fiche.getHopital()).getNomHopitale();
        System.out.println("Hopital =======" + hopital);

    }
    


    
    
    
        public void creatpdf() throws IOException {
            System.out.println("TEST 1 -- Coucou");
            

        try {

            Document document = new Document();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") +  "fiche.pdf";
            System.out.println(path);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            
      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
          BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);            
      
            PdfPTable t0 = new PdfPTable(4);
          
            t0.getDefaultCell().setBorder(0);
            t0.setSpacingBefore(25);
            
            PdfPCell cell0 = new PdfPCell(new Phrase("FICHE PATIENT"));
            cell0.setColspan(4);
            cell0.setBackgroundColor(Color.LIGHT_GRAY);
            t0.addCell(cell0);
            
            t0.addCell("  ");
            t0.addCell("  ");
            t0.addCell("  ");
            t0.addCell("  "); 
            
            PdfPCell cell;
            cell = new PdfPCell(new Paragraph("Hopital"));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setBorder(0);
            //t0.addCell("Hôpital");
            t0.addCell(cell);
            
            t0.addCell(hopitalService.getHopitalParNum(fiche.getHopital()).getNomHopitale());
            PdfPCell cell_1;
            cell_1 = new PdfPCell(new Paragraph("Service"));
            cell_1.setBackgroundColor(Color.LIGHT_GRAY);
            cell_1.setBorder(0);            
            t0.addCell(cell_1);
            
            t0.addCell(serviceService.getServiceParNum(fiche.getService()).getNomService());
            
            t0.addCell("  ");
            t0.addCell("  ");            
            t0.addCell("  ");
            t0.addCell("  ");
            
            PdfPCell cell_2;
            cell_2 = new PdfPCell(new Paragraph("Diagnostique"));
            cell_2.setBackgroundColor(Color.LIGHT_GRAY);
            cell_2.setBorder(0);            
            t0.addCell(cell_2);            
            
            t0.addCell(fiche.getDateDiagnostic().toString());            
            
            PdfPCell cell_3;
            cell_3 = new PdfPCell(new Paragraph("Enregistrement"));
            cell_3.setBackgroundColor(Color.LIGHT_GRAY);
            cell_3.setBorder(0);            
            t0.addCell(cell_3);             
            
            t0.addCell(fiche.getDateEnregistrement().toString());            
            
            t0.addCell("  ");
            t0.addCell("  ");
            t0.addCell("  ");
            t0.addCell("  ");
            
            PdfPCell cell_4;
            cell_4 = new PdfPCell(new Paragraph("Enqueteur"));
            cell_4.setBackgroundColor(Color.LIGHT_GRAY);
            cell_4.setBorder(0);            
            t0.addCell(cell_4);                        
            
            t0.addCell(medecinService.getMedecinParCIN(Integer.valueOf(fiche.getMedecin())).getNomMedecin() + medecinService.getMedecinParCIN(Integer.valueOf(fiche.getMedecin())).getPrenomMedecin());            
            t0.addCell("  ");
            t0.addCell("  ");
                        
            document.add(t0);              
            
            PdfPTable t1 = new PdfPTable(4);
            t1.setSpacingBefore(25);
            t1.setSpacingAfter(25);
            t1.getDefaultCell().setBorder(0);
            
            PdfPCell cell1 = new PdfPCell(new Phrase("IDENTIFICATION DU PATIENT"));
            cell1.setColspan(4);
            cell1.setBackgroundColor(Color.LIGHT_GRAY);
            t1.addCell(cell1);

            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");            

            PdfPCell cell_5;
            cell_5 = new PdfPCell(new Paragraph("Numéro dossier"));
            cell_5.setBackgroundColor(Color.LIGHT_GRAY);
            cell_5.setBorder(0);            
            t1.addCell(cell_5);             
            
            t1.addCell(fiche.getNDossier());

            PdfPCell cell_6;
            cell_6 = new PdfPCell(new Paragraph("Nom"));
            cell_6.setBackgroundColor(Color.LIGHT_GRAY);
            cell_6.setBorder(0);            
            t1.addCell(cell_6);               

            t1.addCell(patient.getNom());
           
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");

            PdfPCell cell_7;
            cell_7 = new PdfPCell(new Paragraph("Prénom"));
            cell_7.setBackgroundColor(Color.LIGHT_GRAY);
            cell_7.setBorder(0);            
            t1.addCell(cell_7); 
            
            
            t1.addCell(patient.getPrenom());
            
            PdfPCell cell_8;
            cell_8 = new PdfPCell(new Paragraph("Sexe"));
            cell_8.setBackgroundColor(Color.LIGHT_GRAY);
            cell_8.setBorder(0);            
            t1.addCell(cell_8);            
            
            t1.addCell(String.valueOf(patient.getSexe()));
            
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            
            PdfPCell cell_9;
            cell_9 = new PdfPCell(new Paragraph("Date de naissance: "));
            cell_9.setBackgroundColor(Color.LIGHT_GRAY);
            cell_9.setBorder(0);            
            t1.addCell(cell_9);              
            
            t1.addCell(patient.getDateNaissance().toString());  
            
            PdfPCell cell_10;
            cell_10 = new PdfPCell(new Paragraph("Lieu de naissance: "));
            cell_10.setBackgroundColor(Color.LIGHT_GRAY);
            cell_10.setBorder(0);            
            t1.addCell(cell_10);            

            t1.addCell(patient.getLieuNaissance());            

            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");

            PdfPCell cell_11;
            cell_11 = new PdfPCell(new Paragraph("Adresse: "));
            cell_11.setBackgroundColor(Color.LIGHT_GRAY);
            cell_11.setBorder(0);            
            t1.addCell(cell_11);             
            
            t1.addCell(patient.getAdresse());            
            
            PdfPCell cell_12;
            cell_12 = new PdfPCell(new Paragraph("Repères éventuelles (épicier, écolle, ...: "));
            cell_12.setBackgroundColor(Color.LIGHT_GRAY);
            cell_12.setBorder(0);            
            t1.addCell(cell_12);             

            t1.addCell(patient.getReperes()); 
            
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            
            
            PdfPCell cell_13;
            cell_13 = new PdfPCell(new Paragraph("Gouvernorat: "));
            cell_13.setBackgroundColor(Color.LIGHT_GRAY);
            cell_13.setBorder(0);            
            t1.addCell(cell_13);              

            t1.addCell(patient.getGouvernorat());            
            
            PdfPCell cell_14;
            cell_14 = new PdfPCell(new Paragraph("Tel: "));
            cell_14.setBackgroundColor(Color.LIGHT_GRAY);
            cell_14.setBorder(0);            
            t1.addCell(cell_14);              
            
            t1.addCell(patient.getTel());    
            
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            
            PdfPCell cell_15;
            cell_15 = new PdfPCell(new Paragraph("Prénom du père: "));
            cell_15.setBackgroundColor(Color.LIGHT_GRAY);
            cell_15.setBorder(0);            
            t1.addCell(cell_15);              
            
            t1.addCell(patient.getPrenomPere());            
            
            PdfPCell cell_16;
            cell_16 = new PdfPCell(new Paragraph("Nom de la grande mère paternelle: "));
            cell_16.setBackgroundColor(Color.LIGHT_GRAY);
            cell_16.setBorder(0);            
            t1.addCell(cell_16);              

            t1.addCell(patient.getNomGMP()); 
            
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            
            PdfPCell cell_17;
            cell_17 = new PdfPCell(new Paragraph("Prénom de la mère: "));
            cell_17.setBackgroundColor(Color.LIGHT_GRAY);
            cell_17.setBorder(0);            
            t1.addCell(cell_17);              
            
            t1.addCell(patient.getPrenomMere()); 
            
            PdfPCell cell_18;
            cell_18 = new PdfPCell(new Paragraph("Nom de la mère: "));
            cell_18.setBackgroundColor(Color.LIGHT_GRAY);
            cell_18.setBorder(0);            
            t1.addCell(cell_18);              

            t1.addCell(patient.getNomMere()); 
            
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");
            t1.addCell("  ");            
            
            PdfPCell cell_19;
            cell_19 = new PdfPCell(new Paragraph("Nom de la grande mère maternelle: "));
            cell_19.setBackgroundColor(Color.LIGHT_GRAY);
            cell_19.setBorder(0);            
            t1.addCell(cell_19);              

            t1.addCell(patient.getNomGMM());  
            t1.addCell("  ");
            t1.addCell("  ");
            
            document.add(t1); 
            
            PdfPTable t2 = new PdfPTable(2);
            t2.setSpacingBefore(25);
            t2.setSpacingAfter(25);
            t2.getDefaultCell().setBorder(0);
            
            PdfPCell cell20 = new PdfPCell(new Phrase("IDENTIFICATION DU PATIENT"));
            cell20.setColspan(2);
            cell20.setBackgroundColor(Color.LIGHT_GRAY);
            t2.addCell(cell20);            

            PdfPCell cell21 = new PdfPCell(new Phrase("Degré de consanguinité des parents:"));
            cell21.setBackgroundColor(Color.LIGHT_GRAY);
            cell21.setBorder(0); 
            t2.addCell(cell21);
            
            t2.addCell(fiche.getDegConsang());
                         
            document.add(t2);           
 
            PdfPTable t3 = new PdfPTable(3);
            t3.setSpacingBefore(25);
            t3.setSpacingAfter(25);
            t3.getDefaultCell().setBorder(0);

            /*
            PdfPCell cell1 = new PdfPCell(new Phrase("Degré de consanguinité des parents:"));
            cell21.setBackgroundColor(Color.LIGHT_GRAY);
            cell21.setBorder(0); 
            t3.addCell(cell21);            
              */           
            document.add(t3);      
            


           /* t0.addCell("Région (Nord/Sud/Centre)");
            t0.addCell(fiche.getMedecin().getRegion());
            t0.addCell("Secteur privé (Oui/Non)");
            t0.addCell(fiche.getMedecin().getSecteur());*/            
            

            
/*            PdfPTable t = new PdfPTable(2);
            t.setSpacingBefore(25);            t0.addCell("Date de diagnostique");
            t0.addCell(fiche.getDateDiagnostic().toString());
            t.setSpacingAfter(25);
*/            
/*            PdfPCell cell = new PdfPCell(new Phrase("Informations Personelles"));
            cell.setColspan(2);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
*/                        document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("./fiche.pdf");
 
        /**
         * --------------- FIN PDF -------------------------------------------
         */
    }
    public Fiche getFiche() {           
        return fiche;
    }
    

    }





