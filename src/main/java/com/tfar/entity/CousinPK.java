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
public class CousinPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_dossier_C", nullable = false, length = 10)
    private String ndossierC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Cousin", nullable = false)
    private int idCousin;

    public CousinPK() {
    }

    public CousinPK(String ndossierC, int idCousin) {
        this.ndossierC = ndossierC;
        this.idCousin = idCousin;
    }

    public String getNdossierC() {
        return ndossierC;
    }

    public void setNdossierC(String ndossierC) {
        this.ndossierC = ndossierC;
    }

    public int getIdCousin() {
        return idCousin;
    }

    public void setIdCousin(int idCousin) {
        this.idCousin = idCousin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ndossierC != null ? ndossierC.hashCode() : 0);
        hash += (int) idCousin;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CousinPK)) {
            return false;
        }
        CousinPK other = (CousinPK) object;
        if ((this.ndossierC == null && other.ndossierC != null) || (this.ndossierC != null && !this.ndossierC.equals(other.ndossierC))) {
            return false;
        }
        if (this.idCousin != other.idCousin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.CousinPK[ ndossierC=" + ndossierC + ", idCousin=" + idCousin + " ]";
    }
    
}
