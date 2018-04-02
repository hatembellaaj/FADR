/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Hatem
 */
@ManagedBean
@SessionScoped
public class AjaxBean implements Serializable{
    protected Boolean tacheCafGridFlag;
    protected Boolean anomPouceGridFlag;
    protected Boolean reinEctopFlag;
    protected Boolean vergeInsufFlag;
    protected Boolean anomUrinFlag;
    protected Boolean retardPubertaireFlag;
    protected Boolean anomAutDoigtsFlag;
    protected Boolean anomOrteilFlag; 
    protected Boolean echoCoeurFlag;
    protected Boolean anomDigFlag;
    protected Boolean endocrinopathieFlag; 
    protected Boolean congelationCelluleFlag;
    protected Boolean chelationFerFlag;
    protected Boolean pourquoiNfaiteFlag; 
    protected Boolean cyclophosphamideFlag;
    protected Boolean fludarabineFlag; 
    protected Boolean busulfanFlag; 
    protected Boolean irradiationFlag; 
    protected Boolean serotherapieFlag;
    protected Boolean salFlag;
    protected Boolean complicationPulmonaireFlag;
    protected Boolean smdFlag;
    protected Boolean cancerFlag;
    protected Boolean traitementCancerFlag;
    protected Boolean evolutionCytoFlag; 

    public Boolean getEvolutionCytoFlag() {
        return evolutionCytoFlag;
    }

    public void setEvolutionCytoFlag(Boolean evolutionCytoFlag) {
        this.evolutionCytoFlag = evolutionCytoFlag;
    }

    public Boolean getTraitementCancerFlag() {
        return traitementCancerFlag;
    }

    public void setTraitementCancerFlag(Boolean traitementCancerFlag) {
        this.traitementCancerFlag = traitementCancerFlag;
    }

    public Boolean getSmdFlag() {
        return smdFlag;
    }

    public void setSmdFlag(Boolean smdFlag) {
        this.smdFlag = smdFlag;
    }

    public Boolean getCancerFlag() {
        return cancerFlag;
    }

    public void setCancerFlag(Boolean cancerFlag) {
        this.cancerFlag = cancerFlag;
    }

    public Boolean getComplicationPulmonaireFlag() {
        return complicationPulmonaireFlag;
    }

    public void setComplicationPulmonaireFlag(Boolean complicationPulmonaireFlag) {
        this.complicationPulmonaireFlag = complicationPulmonaireFlag;
    }

    public Boolean getSalFlag() {
        return salFlag;
    }

    public void setSalFlag(Boolean salFlag) {
        this.salFlag = salFlag;
    }

    public Boolean getSerotherapieFlag() {
        return serotherapieFlag;
    }

    public void setSerotherapieFlag(Boolean serotherapieFlag) {
        this.serotherapieFlag = serotherapieFlag;
    }

    public Boolean getIrradiationFlag() {
        return irradiationFlag;
    }

    public void setIrradiationFlag(Boolean irradiationFlag) {
        this.irradiationFlag = irradiationFlag;
    }

    public Boolean getBusulfanFlag() {
        return busulfanFlag;
    }

    public void setBusulfanFlag(Boolean busulfanFlag) {
        this.busulfanFlag = busulfanFlag;
    }

    public Boolean getFludarabineFlag() {
        return fludarabineFlag;
    }

    public void setFludarabineFlag(Boolean fludarabineFlag) {
        this.fludarabineFlag = fludarabineFlag;
    }

    public Boolean getCyclophosphamideFlag() {
        return cyclophosphamideFlag;
    }

    public void setCyclophosphamideFlag(Boolean cyclophosphamideFlag) {
        this.cyclophosphamideFlag = cyclophosphamideFlag;
    }

    public Boolean getPourquoiNfaiteFlag() {
        return pourquoiNfaiteFlag;
    }

    public void setPourquoiNfaiteFlag(Boolean pourquoiNfaiteFlag) {
        this.pourquoiNfaiteFlag = pourquoiNfaiteFlag;
    }

    public Boolean getChelationFerFlag() {
        return chelationFerFlag;
    }

    public void setChelationFerFlag(Boolean chelationFerFlag) {
        this.chelationFerFlag = chelationFerFlag;
    }

    public Boolean getCongelationCelluleFlag() {
        return congelationCelluleFlag;
    }

    public void setCongelationCelluleFlag(Boolean congelationCelluleFlag) {
        this.congelationCelluleFlag = congelationCelluleFlag;
    }

    public Boolean getEndocrinopathieFlag() {
        return endocrinopathieFlag;
    }

    public void setEndocrinopathieFlag(Boolean endocrinopathieFlag) {
        this.endocrinopathieFlag = endocrinopathieFlag;
    }

    public Boolean getAnomDigFlag() {
        return anomDigFlag;
    }

    public void setAnomDigFlag(Boolean anomDigFlag) {
        this.anomDigFlag = anomDigFlag;
    }

    public Boolean getEchoCoeurFlag() {
        return echoCoeurFlag;
    }

    public void setEchoCoeurFlag(Boolean echoCoeurFlag) {
        this.echoCoeurFlag = echoCoeurFlag;
    }

    public Boolean getAnomOrteilFlag() {
        return anomOrteilFlag;
    }

    public void setAnomOrteilFlag(Boolean anomOrteilFlag) {
        this.anomOrteilFlag = anomOrteilFlag;
    }

    public Boolean getAnomAutDoigtsFlag() {
        return anomAutDoigtsFlag;
    }

    public void setAnomAutDoigtsFlag(Boolean anomAutDoigtsFlag) {
        this.anomAutDoigtsFlag = anomAutDoigtsFlag;
    }

    public Boolean getRetardPubertaireFlag() {
        return retardPubertaireFlag;
    }

    public void setRetardPubertaireFlag(Boolean retardPubertaireFlag) {
        this.retardPubertaireFlag = retardPubertaireFlag;
    }

    public Boolean getAnomUrinFlag() {
        return anomUrinFlag;
    }

    public void setAnomUrinFlag(Boolean anomUrinFlag) {
        this.anomUrinFlag = anomUrinFlag;
    }

    public Boolean getVergeInsufFlag() {
        return vergeInsufFlag;
    }

    public void setVergeInsufFlag(Boolean vergeInsufFlag) {
        this.vergeInsufFlag = vergeInsufFlag;
    }

    public Boolean getReinEctopFlag() {
        return reinEctopFlag;
    }

    public void setReinEctopFlag(Boolean reinEctopFlag) {
        this.reinEctopFlag = reinEctopFlag;
    }



    public Boolean getAnomPouceGridFlag() {
        return anomPouceGridFlag;
    }

    public void setAnomPouceGridFlag(Boolean anomPouceGridFlag) {
        this.anomPouceGridFlag = anomPouceGridFlag;
    }

    public Boolean getTacheCafGridFlag() {
        //System.out.println("GET METHOD tacheCafGridFlag : " + tacheCafGridFlag );
        return tacheCafGridFlag;
    }

    public void setTacheCafGridFlag(Boolean tacheCafGridFlag) {
        this.tacheCafGridFlag = tacheCafGridFlag;
    }


    
    public void loadTypeTacheCafGrid(ValueChangeEvent evt){
        
        String tacheCafeValue = (String)evt.getNewValue();
        //System.out.println("loadTypeTacheCafGrid : " + tacheCafeValue );
        if  (tacheCafeValue.equalsIgnoreCase("oui"))
        {
            this.tacheCafGridFlag = true;
        //System.out.println("tacheCafGridFlag : " + tacheCafGridFlag );
        }
         else        
            tacheCafGridFlag = false;
    }   
    
    public void loadAnomPouceGrid(ValueChangeEvent evt){
        
        String anomPouceValue = (String)evt.getNewValue();
        //System.out.println("loadTypeTacheCafGrid : " + anomPouceValue );
        if  (anomPouceValue.equalsIgnoreCase("oui"))
        {
            this.anomPouceGridFlag = true;
        //System.out.println("anomPouceGridFlag : " + anomPouceGridFlag );
        }
         else        
            anomPouceGridFlag = false;
    }  
    
    public void loadReinEctopGrid(ValueChangeEvent evt){
        
        String reinEctopValue = (String)evt.getNewValue();
        //System.out.println("loadReinEctopGrid : " + reinEctopValue );
        if  (reinEctopValue.equalsIgnoreCase("oui"))
        {
            this.reinEctopFlag = true;
        //System.out.println("reinEctopFlag : " + reinEctopFlag );
        }
         else        
            reinEctopFlag = false;
    }  
    
        public void loadVergeInsufGrid(ValueChangeEvent evt){
        
        String vergeInsufValue = (String)evt.getNewValue();
        //System.out.println("loadReinEctopGrid : " + vergeInsufValue );
        if  (vergeInsufValue.equalsIgnoreCase("Autre"))
        {
            this.vergeInsufFlag = true;
        //System.out.println("vergeInsufFlag : " + vergeInsufFlag );
        }
         else        
            vergeInsufFlag = false;
    }  
        public void loadAnomUrinGrid(ValueChangeEvent evt){
        
        String anomUrinValue = (String)evt.getNewValue();
        //System.out.println("loadAnomUrinGrid : " + anomUrinValue );
        if  (anomUrinValue.equalsIgnoreCase("oui"))
        {
            this.anomUrinFlag = true;
        //System.out.println("anomUrinFlag : " + anomUrinFlag );
        }
         else        
            anomUrinFlag = false;
    }
    public void loadRetardPubertaireGrid(ValueChangeEvent evt){
        
        String retardPubertaireValue = (String)evt.getNewValue();
        //System.out.println("loadAnomUrinGrid : " + retardPubertaireValue );
        if  (retardPubertaireValue.equalsIgnoreCase("oui"))
        {
            this.retardPubertaireFlag = true;
        //System.out.println("retardPubertaireFlag : " + retardPubertaireFlag );
        }
         else        
            retardPubertaireFlag = false;
    }

    public void loadAnomAutDoigtsGrid(ValueChangeEvent evt){
        
        String anomAutDoigtsValue = (String)evt.getNewValue();
        if  (anomAutDoigtsValue.equalsIgnoreCase("oui"))
            this.anomAutDoigtsFlag = true;
         else        
            anomAutDoigtsFlag = false;
    }    
    public void loadAnomOrteilGrid(ValueChangeEvent evt){
        
        String anomOrteilValue = (String)evt.getNewValue();
        if  (anomOrteilValue.equalsIgnoreCase("oui"))
            this.anomOrteilFlag = true;
         else        
            anomOrteilFlag = false;
    }   
    public void loadEchoCoeurGrid(ValueChangeEvent evt){
        
        String echoCoeurValue = (String)evt.getNewValue();
        if  (echoCoeurValue.equalsIgnoreCase("oui"))
            this.echoCoeurFlag = true;
         else        
            echoCoeurFlag = false;
    }  
    public void loadAnomDigGrid(ValueChangeEvent evt){
        
        String anomDigValue = (String)evt.getNewValue();
        if  (anomDigValue.equalsIgnoreCase("oui"))
            this.anomDigFlag = true;
         else        
            anomDigFlag = false;
    }         
    public void loadEndocrinopathieGrid(ValueChangeEvent evt){
        
        String endocrinopathieValue = (String)evt.getNewValue();
        if  (endocrinopathieValue.equalsIgnoreCase("oui"))
            this.endocrinopathieFlag = true;
         else        
            endocrinopathieFlag = false;
    }      
    public void loadCongelationCelluleGrid(ValueChangeEvent evt){
        
        String congelationCelluleValue = (String)evt.getNewValue();
        if  (congelationCelluleValue.equalsIgnoreCase("faite"))
            this.congelationCelluleFlag = true;
         else        
            congelationCelluleFlag = false;
    }    
    public void loadchelationFerGrid(ValueChangeEvent evt){
        
        String chelationFerValue = (String)evt.getNewValue();
        if  (chelationFerValue.equalsIgnoreCase("oui"))
            this.chelationFerFlag = true;
         else        
            chelationFerFlag = false;
    }     
    public void loadpourquoiNfaiteGrid(ValueChangeEvent evt){
        
        String pourquoiNfaiteValue = (String)evt.getNewValue();
        if  (pourquoiNfaiteValue.equalsIgnoreCase("AutreP"))
            this.pourquoiNfaiteFlag = true;
         else        
            pourquoiNfaiteFlag = false;
    }     
    public void loadcyclophosphamideGrid(ValueChangeEvent evt){
        
        String cyclophosphamideValue = (String)evt.getNewValue();
        if  (cyclophosphamideValue.equalsIgnoreCase("oui"))
            this.cyclophosphamideFlag = true;
         else        
            cyclophosphamideFlag = false;
    }  
    public void loadfludarabineGrid(ValueChangeEvent evt){
        
        String fludarabineValue = (String)evt.getNewValue();
        if  (fludarabineValue.equalsIgnoreCase("oui"))
            this.fludarabineFlag = true;
         else        
            fludarabineFlag = false;
    }      
        public void loadBusulfanGrid(ValueChangeEvent evt){
        
        String busulfanValue = (String)evt.getNewValue();
        if  (busulfanValue.equalsIgnoreCase("oui"))
            this.busulfanFlag = true;
         else        
            busulfanFlag = false;
    }     
        public void loadirradiationGrid(ValueChangeEvent evt){
        
        String irradiationValue = (String)evt.getNewValue();
        if  (irradiationValue.equalsIgnoreCase("AutreI"))
            this.irradiationFlag = true;
         else        
            irradiationFlag = false;
    }      
    public void loadserotherapieGrid(ValueChangeEvent evt){
        
        String serotherapieValue = (String)evt.getNewValue();
        if  (serotherapieValue.equalsIgnoreCase("Faite"))
            this.serotherapieFlag = true;
         else        
            serotherapieFlag = false;
    } 
    public void loadsalGrid(ValueChangeEvent evt){
        
        String salValue = (String)evt.getNewValue();
        if  (salValue.equalsIgnoreCase("oui"))
            this.salFlag = true;
         else        
            salFlag = false;
    }   
    public void loadcomplicationPulmonaireGrid(ValueChangeEvent evt){
        
        String complicationPulmonaireValue = (String)evt.getNewValue();
        if  (complicationPulmonaireValue.equalsIgnoreCase("oui"))
            this.complicationPulmonaireFlag = true;
         else        
            complicationPulmonaireFlag = false;
    }    
    public void loadsmdGrid(ValueChangeEvent evt){
        
        String smdValue = (String)evt.getNewValue();
        if  (smdValue.equalsIgnoreCase("oui"))
            this.smdFlag = true;
         else        
            smdFlag = false;
    }  
    public void loadcancerGrid(ValueChangeEvent evt){
        
        String cancerValue = (String)evt.getNewValue();
        if  (cancerValue.equalsIgnoreCase("oui"))
            this.cancerFlag = true;
         else        
            cancerFlag = false;
    }      

    public void loadtraitementCancerGrid(ValueChangeEvent evt){
        
        String traitementCancerValue = (String)evt.getNewValue();
        if  (traitementCancerValue.equalsIgnoreCase("oui"))
            this.traitementCancerFlag = true;
         else        
            traitementCancerFlag = false;
    }     
    
    public void loadevolutionCytoGrid(ValueChangeEvent evt){
        
        String evolutionCytoValue = (String)evt.getNewValue();
        if  (evolutionCytoValue.equalsIgnoreCase("oui"))
            this.evolutionCytoFlag = true;
         else        
            evolutionCytoFlag = false;
    }         
    
}
