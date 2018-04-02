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
public class MembrePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_Dossier_M", nullable = false, length = 10)
    private String nDossierM;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Membre", nullable = false)
    private int idMembre;

    public MembrePK() {
    }

    public MembrePK(String nDossierM, int idMembre) {
        this.nDossierM = nDossierM;
        this.idMembre = idMembre;
    }

    public String getNDossierM() {
        return nDossierM;
    }

    public void setNDossierM(String nDossierM) {
        this.nDossierM = nDossierM;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDossierM != null ? nDossierM.hashCode() : 0);
        hash += (int) idMembre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembrePK)) {
            return false;
        }
        MembrePK other = (MembrePK) object;
        if ((this.nDossierM == null && other.nDossierM != null) || (this.nDossierM != null && !this.nDossierM.equals(other.nDossierM))) {
            return false;
        }
        if (this.idMembre != other.idMembre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.MembrePK[ nDossierM=" + nDossierM + ", idMembre=" + idMembre + " ]";
    }
    
}
