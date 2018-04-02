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
@Table(name = "androgene")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Androgene.findAll", query = "SELECT a FROM Androgene a"),
    @NamedQuery(name = "Androgene.findByNDossierPa", query = "SELECT a FROM Androgene a WHERE a.androgenePK.nDossierPa = :nDossierPa"),
    @NamedQuery(name = "Androgene.findByMois", query = "SELECT a FROM Androgene a WHERE a.androgenePK.mois = :mois"),
    @NamedQuery(name = "Androgene.findByReponse", query = "SELECT a FROM Androgene a WHERE a.reponse = :reponse")})
public class Androgene implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AndrogenePK androgenePK;
    @Size(max = 5)
    @Column(name = "Reponse", length = 5)
    private String reponse;

    public Androgene() {
    }

    public Androgene(AndrogenePK androgenePK) {
        this.androgenePK = androgenePK;
    }

    public Androgene(String nDossierPa, int mois) {
        this.androgenePK = new AndrogenePK(nDossierPa, mois);
    }

    public AndrogenePK getAndrogenePK() {
        return androgenePK;
    }

    public void setAndrogenePK(AndrogenePK androgenePK) {
        this.androgenePK = androgenePK;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (androgenePK != null ? androgenePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Androgene)) {
            return false;
        }
        Androgene other = (Androgene) object;
        if ((this.androgenePK == null && other.androgenePK != null) || (this.androgenePK != null && !this.androgenePK.equals(other.androgenePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Androgene[ androgenePK=" + androgenePK + " ]";
    }
    
}
