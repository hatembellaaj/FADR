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
public class CytogenetiquePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_Dossier_Patient", nullable = false, length = 10)
    private String nDossierPatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_Etude_Cyto", nullable = false)
    private int nEtudeCyto;

    public CytogenetiquePK() {
    }

    public CytogenetiquePK(String nDossierPatient, int nEtudeCyto) {
        this.nDossierPatient = nDossierPatient;
        this.nEtudeCyto = nEtudeCyto;
    }

    public String getNDossierPatient() {
        return nDossierPatient;
    }

    public void setNDossierPatient(String nDossierPatient) {
        this.nDossierPatient = nDossierPatient;
    }

    public int getNEtudeCyto() {
        return nEtudeCyto;
    }

    public void setNEtudeCyto(int nEtudeCyto) {
        this.nEtudeCyto = nEtudeCyto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDossierPatient != null ? nDossierPatient.hashCode() : 0);
        hash += (int) nEtudeCyto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CytogenetiquePK)) {
            return false;
        }
        CytogenetiquePK other = (CytogenetiquePK) object;
        if ((this.nDossierPatient == null && other.nDossierPatient != null) || (this.nDossierPatient != null && !this.nDossierPatient.equals(other.nDossierPatient))) {
            return false;
        }
        if (this.nEtudeCyto != other.nEtudeCyto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.CytogenetiquePK[ nDossierPatient=" + nDossierPatient + ", nEtudeCyto=" + nEtudeCyto + " ]";
    }
    
}
