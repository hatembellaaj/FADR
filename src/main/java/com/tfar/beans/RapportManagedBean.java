/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import static com.lowagie.text.xml.simpleparser.EntitiesToSymbol.map;
import com.tfar.entity.Fiche;
import com.tfar.entity.Patient;
import com.tfar.services.FicheService;
import com.tfar.services.PatientService;
import com.tfar.services.ServiceService;
import java.io.Serializable;
import java.lang.reflect.Field;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.naming.NamingException;

import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hatem
 */
@ManagedBean(name = "rapportMB")
@SessionScoped
public class RapportManagedBean implements Serializable {
    

    private Fiche f = new Fiche(); 
    private Patient p = new Patient();
    private List parameters = new ArrayList();
    private List parametersPatient = new ArrayList();

    public List getParametersPatient() {
        return parametersPatient;
    }

    public void setParametersPatient(List parametersPatient) {
        this.parametersPatient = parametersPatient;
    }
    private String criterium ; 
    private String criteriumPatient;

    public String getCriteriumPatient() {
        return criteriumPatient;
    }

    public void setCriteriumPatient(String criteriumPatient) {
        this.criteriumPatient = criteriumPatient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getCriterium() {
        return criterium;
    }

    public void setCriterium(String criterium) {
        this.criterium = criterium;
    }
    private String TypeGraph ; 
    private String TypeGraphPatient  ; 

    public String getTypeGraphPatient() {
        return TypeGraphPatient;
    }

    public void setTypeGraphPatient(String TypeGraphPatient) {
        this.TypeGraphPatient = TypeGraphPatient;
    }
    private PieChartModel pieChartModel=new PieChartModel();
    private PieChartModel pieChartModelPatient = new PieChartModel();

    public PieChartModel getPieChartModelPatient() {
        return pieChartModelPatient;
    }

    public void setPieChartModelPatient(PieChartModel pieChartModelPatient) {
        this.pieChartModelPatient = pieChartModelPatient;
    }

    public PieChartModel getPieChartModel() {
        return pieChartModel;
    }

    public void setPieChartModel(PieChartModel pieChartModel) {
        this.pieChartModel = pieChartModel;
    }

    public String getTypeGraph() {
        return TypeGraph;
    }

    public void setTypeGraph(String TypeGraph) {
        this.TypeGraph = TypeGraph;
    }

    public List getParameters() {
        return parameters;
    }

    public void setParameters(List parameters) {
        this.parameters = parameters;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
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

    public FicheService getFicheService() {
        return ficheService;
    }

    public void setFicheService(FicheService ficheService) {
        this.ficheService = ficheService;
    }
    
    @ManagedProperty("#{ServiceService}")
    private ServiceService serviceService;  
    
    
    private Fiche fiche = new Fiche();
    private Patient patient = new Patient();
    
    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
        
    private BarChartModel barModel= new BarChartModel();
    private BarChartModel barModelPatient= new BarChartModel();

    public BarChartModel getBarModelPatient() {
        return barModelPatient;
    }

    public void setBarModelPatient(BarChartModel barModelPatient) {
        this.barModelPatient = barModelPatient;
    }
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        //createBarModels();
        Class<?> c = fiche.getClass();
        Field[] fields = c.getDeclaredFields();

        for( Field field : fields ){
        try {
            parameters.add(field.getName());
            System.out.println(field.getName());
        } catch (IllegalArgumentException e1) {}
        }
        
        
        Class<?> d = patient.getClass();
        Field[] fieldsPatient = d.getDeclaredFields();

        for( Field field : fieldsPatient ){
        try {
            parametersPatient.add(field.getName());
            System.out.println(field.getName());
        } catch (IllegalArgumentException e1) {}
        }
    }
    
   
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }     

 
    public BarChartModel initBarModel() {
        //CartesianChartModel model = new CartesianChartModel();
       BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
         
         boys.setLabel("Nombre de patients");
         
        for (int i = 0; i < serviceService.getAllService().size(); i++) {
            System.out.println(serviceService.getAllService().get(i).getNomService());
            System.out.println(ficheService.getFicheParnService(serviceService.getAllService().get(i).getCodeService()));
      boys.set(serviceService.getAllService().get(i).getNomService(),ficheService.getFicheParnService(serviceService.getAllService().get(i).getCodeService()).size());
        }
        model.addSeries(boys);
     
        return model;
    }
    
    
    public void afficheStat()
    {
        System.out.println("Affiche Stat START ******");
        if(this.criterium!=null)
        {
            System.out.println("Affiche Stat IN ******");
            Map <String,Number> lf= ficheService.getFicheParCritere(this.criterium);
            
           // if ("PieChar".equals(this.TypeGraph))
            //{       
               // pieChartModel.clear();
                pieChartModel.setData(lf);
                pieChartModel.setTitle(this.criterium);
                pieChartModel.setLegendPosition("e");
                pieChartModel.setFill(true);
                pieChartModel.setShowDataLabels(true);
                pieChartModel.setDiameter(450);
                //RequestContext context = RequestContext.getCurrentInstance();
                //context.execute("PF('dlg1').show();");
                RequestContext.getCurrentInstance().update("form1:pieChart");
            /*}
            else 
            {*/
                ChartSeries cs = new ChartSeries();
                cs.setLabel(this.criterium);
                Set cles = lf.keySet();
                Iterator it = cles.iterator();
                while (it.hasNext()){
                    Object cle = it.next(); // tu peux typer plus finement ici
                    cs.set(cle,lf.get(cle)); // tu peux typer plus finement ici
                }
                barModel.clear();
                barModel.addSeries(cs);                
                barModel.setTitle(this.criterium);
                barModel.setLegendPosition("ne");
                barModel.setAnimate(true);
                //     RequestContext context = RequestContext.getCurrentInstance();
                //     System.out.println("Call DLG2 ******");
                //context.execute("PF('dlg2').show();");
                RequestContext.getCurrentInstance().update("form1:barChart");
 
            //}
    }
    }
    
    
    public void afficheStatPatient()
    {
        System.out.println("Affiche Stat Patient START ******");
        if(this.criteriumPatient!=null)
        {
            System.out.println("Affiche Stat Patient IN ******");
            Map <String,Number> lf= patientService.getPatientParCritere(this.criteriumPatient);
            
            //if ("PieChar".equals(this.TypeGraphPatient))
            //{      
                pieChartModelPatient = new PieChartModel();
                pieChartModelPatient.setData(lf);
                pieChartModelPatient.setTitle(this.criteriumPatient);
                pieChartModelPatient.setLegendPosition("e");
                pieChartModelPatient.setFill(true);
                pieChartModelPatient.setShowDataLabels(true);
                pieChartModelPatient.setDiameter(450);
                
                //RequestContext context = RequestContext.getCurrentInstance();
                 //System.out.println("Call DLG1Patient  ******");
                // context.update(":form1:PCmodelpatient");
                //context.execute("PF('dlg1Patient').show();");
                RequestContext.getCurrentInstance().update("form2:pieChartPatient");
            //}
            //else 
            //{
                int nbItems = 0 ; 
                ChartSeries cs = new ChartSeries();
                cs.setLabel(this.criteriumPatient);
                Set cles = lf.keySet();
                Iterator it = cles.iterator();
                while (it.hasNext()){
                    Object cle = it.next(); // tu peux typer plus finement ici
                    cs.set(cle,lf.get(cle)); // tu peux typer plus finement ici
                }
                barModelPatient.clear();
                barModelPatient.addSeries(cs);                
                barModelPatient.setTitle(this.criteriumPatient);
                barModelPatient.setLegendPosition("ne");
                barModelPatient.setAnimate(true);
                if (nbItems > 5)
                {
                    Axis xAxis = barModelPatient.getAxis(AxisType.X);
                    xAxis.setTickAngle(-30);
                }
                //     RequestContext context = RequestContext.getCurrentInstance();
                //     System.out.println("Call DLG2 ******");
                //context.execute("PF('dlg2Patient').show();");
                RequestContext.getCurrentInstance().update("form2:barChartPatient");
                //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form1:grid2:Bmodelpatient");

            //}
    }
    }
    
    
    
    public void refreshChart()
    {
        afficheStatPatient();
    }
    
    
    
    public void afficheMonoStat() throws NamingException{
       System.out.println("afficheMonoStat =========== TEST 8032017");
      Map <String,Number> lf= ficheService.getFicheParCritere(this.criterium);
      pieChartModel.setData(lf);
      pieChartModel.setTitle(this.criterium);
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(true);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(500);
       
    }

     
    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
    

    
    
        public void ComputeKM() throws IOException, InterruptedException
    {
        System.out.println("Compute KM START ****** Version 17-03_2018-9:45");

            
            Map <String,String> lf= ficheService.getKM();
            String E = "";
            String T = "";
            String index = "";
            
            Set cles = lf.keySet();
            Iterator it = cles.iterator();
            int i = 0;
            while (it.hasNext()){                   
                Object cle = it.next(); // tu peux typer plus finement ici
                Object valeur = lf.get(cle); // tu peux typer plus finement ici
                System.out.println("INSERTION LIGNE : CLE : " + cle.toString() + " VALEUR : " + valeur.toString());
                E += cle.toString() + " ";
                T += valeur.toString() + " "; 
                index += String.valueOf(i) + " ";
                i++;
            }
            createFile(E, "/var/www/vhosts/fanconi-tunisie.net/E.txt");
            createFile(T, "/var/www/vhosts/fanconi-tunisie.net/T.txt");
            createFile(index, "/var/www/vhosts/fanconi-tunisie.net/index.txt");
            


            Runtime.getRuntime().exec("python /var/www/vhosts/fanconi-tunisie.net/KapMeier.py");
            
        System.out.println("Début du programme");
        try {
            String[] commande = {"pwd "};
            Process p = Runtime.getRuntime().exec(commande);
            p.waitFor();
        } catch (IOException | InterruptedException e) {
        }
        Thread.sleep(4000);
        System.out.println("Fin du programme");
    




    }

    public void createFile(String text, String PathFile)
    {
        try{
            // Create new file
            String content = text;
            String path=PathFile;
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(content);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    
    }
/*    
    <p:dialog id="TraceGraph1" widgetVar="$TraceGraph1" header="Cherger fichier" modal="true" hideEffect="explode" appendTo="@(body)" resizable="false" draggable="false" closeOnEscape="true">
                <h:form enctype="multipart/form-data">
                    <p:chart type="pie" model="#{rapportMB.pieChartModel}" style="height:300px"/>                </h:form>    
            </p:dialog>   

        <p:chart type="bar" model="#{rapportMB.barModel}" style="height:300px"/>
 
<p:chart type="bar" model="#{rapportMB.horizontalBarModel}" style="height:300px"/>

<p:dialog header="Bar char" widgetVar="dlg2" minHeight="40">
    <h:outputText value="Resistance to PrimeFaces is futile!" />
    <p:chart type="bar" model="#{rapportMB.barModel}" style="height:300px"/>                              
</p:dialog> 
                    
                    
        
   <p:dialog header="Statistiques Fiches" widgetVar="dlg1" minHeight="40">
    <p:chart type="pie" model="#{rapportMB.pieChartModel}" style="height:550px;width: 550px"/>                                  
</p:dialog>         

<p:dialog header="Statistiques Fiches" widgetVar="dlg2" minHeight="40">
    <p:chart type="bar" model="#{rapportMB.barModel}" style="height:550px;width: 550px"/>                             
</p:dialog>     


                <p:dialog header="Statistiques Patients" widgetVar="dlg1Patient" minHeight="40">
        <p:chart type="pie" model="#{rapportMB.pieChartModelPatient}" style="height:550px;width: 550px"/>                                  
</p:dialog>        

<p:dialog header="Statistiques Patients" widgetVar="dlg2Patient" minHeight="40">
    <p:chart type="bar" model="#{rapportMB.barModelPatient}" style="height:550px;width: 550px"/>                             
</p:dialog>     

*/
