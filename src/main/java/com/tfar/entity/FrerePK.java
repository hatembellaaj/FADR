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
public class FrerePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_Dossier_F", nullable = false, length = 10)
    private String nDossierF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_frere", nullable = false)
    private int idfrere;

    public FrerePK() {
    }

    public FrerePK(String nDossierF, int idfrere) {
        this.nDossierF = nDossierF;
        this.idfrere = idfrere;
    }

    public String getNDossierF() {
        return nDossierF;
    }

    public void setNDossierF(String nDossierF) {
        this.nDossierF = nDossierF;
    }

    public int getIdfrere() {
        return idfrere;
    }

    public void setIdfrere(int idfrere) {
        this.idfrere = idfrere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDossierF != null ? nDossierF.hashCode() : 0);
        hash += (int) idfrere;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrerePK)) {
            return false;
        }
        FrerePK other = (FrerePK) object;
        if ((this.nDossierF == null && other.nDossierF != null) || (this.nDossierF != null && !this.nDossierF.equals(other.nDossierF))) {
            return false;
        }
        if (this.idfrere != other.idfrere) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.FrerePK[ nDossierF=" + nDossierF + ", idfrere=" + idfrere + " ]";
    }
    
}
