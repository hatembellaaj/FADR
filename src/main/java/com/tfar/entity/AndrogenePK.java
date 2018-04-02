/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hatem
 */
@Embeddable
public class AndrogenePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_Dossier_Pa", nullable = false, length = 10)
    private String nDossierPa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mois", nullable = false)
    private int mois;

    public AndrogenePK() {
    }

    public AndrogenePK(String nDossierPa, int mois) {
        this.nDossierPa = nDossierPa;
        this.mois = mois;
    }

    public String getNDossierPa() {
        return nDossierPa;
    }

    public void setNDossierPa(String nDossierPa) {
        this.nDossierPa = nDossierPa;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDossierPa != null ? nDossierPa.hashCode() : 0);
        hash += (int) mois;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AndrogenePK)) {
            return false;
        }
        AndrogenePK other = (AndrogenePK) object;
        if ((this.nDossierPa == null && other.nDossierPa != null) || (this.nDossierPa != null && !this.nDossierPa.equals(other.nDossierPa))) {
            return false;
        }
        if (this.mois != other.mois) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.AndrogenePK[ nDossierPa=" + nDossierPa + ", mois=" + mois + " ]";
    }
    
}
