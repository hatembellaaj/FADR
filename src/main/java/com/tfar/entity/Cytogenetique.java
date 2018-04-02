/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatem
 */
@Entity
@Table(name = "cytogenetique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cytogenetique.findAll", query = "SELECT c FROM Cytogenetique c"),
    @NamedQuery(name = "Cytogenetique.findByNDossierPatient", query = "SELECT c FROM Cytogenetique c WHERE c.cytogenetiquePK.nDossierPatient = :nDossierPatient"),
    @NamedQuery(name = "Cytogenetique.findByNEtudeCyto", query = "SELECT c FROM Cytogenetique c WHERE c.cytogenetiquePK.nEtudeCyto = :nEtudeCyto"),
    @NamedQuery(name = "Cytogenetique.findByLymphocytes", query = "SELECT c FROM Cytogenetique c WHERE c.lymphocytes = :lymphocytes"),
    @NamedQuery(name = "Cytogenetique.findByDateSang", query = "SELECT c FROM Cytogenetique c WHERE c.dateSang = :dateSang"),
    @NamedQuery(name = "Cytogenetique.findByLaboratoire", query = "SELECT c FROM Cytogenetique c WHERE c.laboratoire = :laboratoire"),
    @NamedQuery(name = "Cytogenetique.findByAgentPontant", query = "SELECT c FROM Cytogenetique c WHERE c.agentPontant = :agentPontant"),
    @NamedQuery(name = "Cytogenetique.findByInstabilite", query = "SELECT c FROM Cytogenetique c WHERE c.instabilite = :instabilite"),
    @NamedQuery(name = "Cytogenetique.findByInstabilitePourcentage", query = "SELECT c FROM Cytogenetique c WHERE c.instabilitePourcentage = :instabilitePourcentage"),
    @NamedQuery(name = "Cytogenetique.findByIr", query = "SELECT c FROM Cytogenetique c WHERE c.ir = :ir"),
    @NamedQuery(name = "Cytogenetique.findByIRPourcentage", query = "SELECT c FROM Cytogenetique c WHERE c.iRPourcentage = :iRPourcentage"),
    @NamedQuery(name = "Cytogenetique.findByMoelle", query = "SELECT c FROM Cytogenetique c WHERE c.moelle = :moelle"),
    @NamedQuery(name = "Cytogenetique.findByDateMoelle", query = "SELECT c FROM Cytogenetique c WHERE c.dateMoelle = :dateMoelle"),
    @NamedQuery(name = "Cytogenetique.findByResultatMoelle", query = "SELECT c FROM Cytogenetique c WHERE c.resultatMoelle = :resultatMoelle")})
public class Cytogenetique implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CytogenetiquePK cytogenetiquePK;
    @Size(max = 9)
    @Column(name = "Lymphocytes", length = 9)
    private String lymphocytes;
    @Size(max = 10)
    @Column(name = "Date_Sang")
    @Temporal(TemporalType.DATE)
    private Date dateSang;    
    @Size(min = 1, max = 30)
    @Column(name = "Laboratoire", length = 30)
    private String laboratoire;
    @Size(max = 4)
    @Column(name = "AgentPontant", length = 4)
    private String agentPontant;
    @Size(max = 4)
    @Column(name = "Instabilite", length = 4)
    private String instabilite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "InstabilitePourcentage", precision = 12)
    private Float instabilitePourcentage;
    @Size(max = 4)
    @Column(name = "IR", length = 4)
    private String ir;
    @Column(name = "IRPourcentage", precision = 12)
    private Float iRPourcentage;
    @Size(max = 30)
    @Column(name = "Moelle", length = 30)
    private String moelle;
    @Size(max = 10)
    @Column(name = "Date_Moelle")
    @Temporal(TemporalType.DATE)
    private Date dateMoelle;  
    @Size(max = 200)
    @Column(name = "Resultat_Moelle", length = 200)
    private String resultatMoelle;

    public Cytogenetique() {
    }

    public Cytogenetique(CytogenetiquePK cytogenetiquePK) {
        this.cytogenetiquePK = cytogenetiquePK;
    }

    public Cytogenetique(CytogenetiquePK cytogenetiquePK, String laboratoire) {
        this.cytogenetiquePK = cytogenetiquePK;
        this.laboratoire = laboratoire;
    }

    public Cytogenetique(String nDossierPatient, int nEtudeCyto) {
        this.cytogenetiquePK = new CytogenetiquePK(nDossierPatient, nEtudeCyto);
    }

    public CytogenetiquePK getCytogenetiquePK() {
        return cytogenetiquePK;
    }

    public void setCytogenetiquePK(CytogenetiquePK cytogenetiquePK) {
        this.cytogenetiquePK = cytogenetiquePK;
    }

    public String getLymphocytes() {
        return lymphocytes;
    }

    public void setLymphocytes(String lymphocytes) {
        this.lymphocytes = lymphocytes;
    }

    public Date getDateSang() {
        return dateSang;
    }

    public void setDateSang(Date dateSang) {
        this.dateSang = dateSang;
    }

    public String getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(String laboratoire) {
        this.laboratoire = laboratoire;
    }

    public String getAgentPontant() {
        return agentPontant;
    }

    public void setAgentPontant(String agentPontant) {
        this.agentPontant = agentPontant;
    }

    public String getInstabilite() {
        return instabilite;
    }

    public void setInstabilite(String instabilite) {
        this.instabilite = instabilite;
    }

    public Float getInstabilitePourcentage() {
        return instabilitePourcentage;
    }

    public void setInstabilitePourcentage(Float instabilitePourcentage) {
        this.instabilitePourcentage = instabilitePourcentage;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public Float getIRPourcentage() {
        return iRPourcentage;
    }

    public void setIRPourcentage(Float iRPourcentage) {
        this.iRPourcentage = iRPourcentage;
    }

    public String getMoelle() {
        return moelle;
    }

    public void setMoelle(String moelle) {
        this.moelle = moelle;
    }

    public Date getDateMoelle() {
        return dateMoelle;
    }

    public void setDateMoelle(Date dateMoelle) {
        this.dateMoelle = dateMoelle;
    }

    public String getResultatMoelle() {
        return resultatMoelle;
    }

    public void setResultatMoelle(String resultatMoelle) {
        this.resultatMoelle = resultatMoelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cytogenetiquePK != null ? cytogenetiquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cytogenetique)) {
            return false;
        }
        Cytogenetique other = (Cytogenetique) object;
        if ((this.cytogenetiquePK == null && other.cytogenetiquePK != null) || (this.cytogenetiquePK != null && !this.cytogenetiquePK.equals(other.cytogenetiquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Cytogenetique[ cytogenetiquePK=" + cytogenetiquePK + " ]";
    }
    
}
