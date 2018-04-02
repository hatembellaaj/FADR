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
@Table(name = "cousin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cousin.findAll", query = "SELECT c FROM Cousin c"),
    @NamedQuery(name = "Cousin.findByNdossierC", query = "SELECT c FROM Cousin c WHERE c.cousinPK.ndossierC = :ndossierC"),
    @NamedQuery(name = "Cousin.findByIdCousin", query = "SELECT c FROM Cousin c WHERE c.cousinPK.idCousin = :idCousin"),
    @NamedQuery(name = "Cousin.findByPrenomCousin", query = "SELECT c FROM Cousin c WHERE c.prenomCousin = :prenomCousin"),
    @NamedQuery(name = "Cousin.findByPlaceCousin", query = "SELECT c FROM Cousin c WHERE c.placeCousin = :placeCousin"),
    @NamedQuery(name = "Cousin.findBySexeC", query = "SELECT c FROM Cousin c WHERE c.sexeC = :sexeC")})
public class Cousin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CousinPK cousinPK;
    @Size(max = 30)
    @Column(name = "Prenom_Cousin", length = 30)
    private String prenomCousin;
    @Size(max = 9)
    @Column(name = "Place_Cousin", length = 9)
    private String placeCousin;
    @Size(max = 2)
    @Column(name = "SexeC", length = 2)
    private String sexeC;

    public Cousin() {
    }

    public Cousin(CousinPK cousinPK) {
        this.cousinPK = cousinPK;
    }

    public Cousin(String ndossierC, int idCousin) {
        this.cousinPK = new CousinPK(ndossierC, idCousin);
    }

    public CousinPK getCousinPK() {
        return cousinPK;
    }

    public void setCousinPK(CousinPK cousinPK) {
        this.cousinPK = cousinPK;
    }

    public String getPrenomCousin() {
        return prenomCousin;
    }

    public void setPrenomCousin(String prenomCousin) {
        this.prenomCousin = prenomCousin;
    }

    public String getPlaceCousin() {
        return placeCousin;
    }

    public void setPlaceCousin(String placeCousin) {
        this.placeCousin = placeCousin;
    }

    public String getSexeC() {
        return sexeC;
    }

    public void setSexeC(String sexeC) {
        this.sexeC = sexeC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cousinPK != null ? cousinPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cousin)) {
            return false;
        }
        Cousin other = (Cousin) object;
        if ((this.cousinPK == null && other.cousinPK != null) || (this.cousinPK != null && !this.cousinPK.equals(other.cousinPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Cousin[ cousinPK=" + cousinPK + " ]";
    }
    
}
