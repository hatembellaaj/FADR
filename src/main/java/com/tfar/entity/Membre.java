/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatem
 */
@Entity
@Table(name = "membre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m"),
    @NamedQuery(name = "Membre.findByNDossierM", query = "SELECT m FROM Membre m WHERE m.membrePK.nDossierM = :nDossierM"),
    @NamedQuery(name = "Membre.findByIdMembre", query = "SELECT m FROM Membre m WHERE m.membrePK.idMembre = :idMembre"),
    @NamedQuery(name = "Membre.findByPrenomM", query = "SELECT m FROM Membre m WHERE m.prenomM = :prenomM"),
    @NamedQuery(name = "Membre.findByLienParente", query = "SELECT m FROM Membre m WHERE m.lienParente = :lienParente"),
    @NamedQuery(name = "Membre.findByTypeCancerM", query = "SELECT m FROM Membre m WHERE m.typeCancerM = :typeCancerM"),
    @NamedQuery(name = "Membre.findByAgeDecouverteM", query = "SELECT m FROM Membre m WHERE m.ageDecouverteM = :ageDecouverteM")})
public class Membre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MembrePK membrePK;
    @Size(max = 30)
    @Column(name = "Prenom_M", length = 30)
    private String prenomM;
    @Size(max = 30)
    @Column(name = "Lien_Parente", length = 30)
    private String lienParente;
    @Size(max = 30)
    @Column(name = "Type_Cancer_M", length = 30)
    private String typeCancerM;
    @Column(name = "Age_Decouverte_M")
    private Integer ageDecouverteM;

    public Membre() {
    }

    public Membre(MembrePK membrePK) {
        this.membrePK = membrePK;
    }

    public Membre(String nDossierM, int idMembre) {
        this.membrePK = new MembrePK(nDossierM, idMembre);
    }

    public MembrePK getMembrePK() {
        return membrePK;
    }

    public void setMembrePK(MembrePK membrePK) {
        this.membrePK = membrePK;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public void setPrenomM(String prenomM) {
        this.prenomM = prenomM;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }

    public String getTypeCancerM() {
        return typeCancerM;
    }

    public void setTypeCancerM(String typeCancerM) {
        this.typeCancerM = typeCancerM;
    }

    public Integer getAgeDecouverteM() {
        return ageDecouverteM;
    }

    public void setAgeDecouverteM(Integer ageDecouverteM) {
        this.ageDecouverteM = ageDecouverteM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membrePK != null ? membrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membre)) {
            return false;
        }
        Membre other = (Membre) object;
        if ((this.membrePK == null && other.membrePK != null) || (this.membrePK != null && !this.membrePK.equals(other.membrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Membre[ membrePK=" + membrePK + " ]";
    }
    
}
