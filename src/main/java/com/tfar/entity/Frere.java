/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatem
 */
@Entity
@Table(name = "frere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frere.findAll", query = "SELECT f FROM Frere f"),
    @NamedQuery(name = "Frere.findByNDossierF", query = "SELECT f FROM Frere f WHERE f.frerePK.nDossierF = :nDossierF"),
    @NamedQuery(name = "Frere.findByIdfrere", query = "SELECT f FROM Frere f WHERE f.frerePK.idfrere = :idfrere"),
    @NamedQuery(name = "Frere.findByPrenomfrere", query = "SELECT f FROM Frere f WHERE f.prenomfrere = :prenomfrere"),
    @NamedQuery(name = "Frere.findByAtteint", query = "SELECT f FROM Frere f WHERE f.atteint = :atteint"),
    @NamedQuery(name = "Frere.findByPlacefratrie", query = "SELECT f FROM Frere f WHERE f.placefratrie = :placefratrie"),
    @NamedQuery(name = "Frere.findBySexeF", query = "SELECT f FROM Frere f WHERE f.sexeF = :sexeF"),
    @NamedQuery(name = "Frere.findByDecedes", query = "SELECT f FROM Frere f WHERE f.decedes = :decedes"),
    @NamedQuery(name = "Frere.findByAge", query = "SELECT f FROM Frere f WHERE f.age = :age")})
public class Frere implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FrerePK frerePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Prenom_frere", nullable = false, length = 30)
    private String prenomfrere;
    @Size(max = 4)
    @Column(name = "Atteint", length = 4)
    private String atteint;
    @Column(name = "Place_fratrie")
    private Integer placefratrie;
    @Size(max = 2)
    @Column(name = "Sexe_F", length = 2)
    private String sexeF;
    @Size(max = 4)
    @Column(name = "Decedes", length = 4)
    private String decedes;
    @Column(name = "Age")
    private Integer age;

    public Frere() {
    }

    public Frere(FrerePK frerePK) {
        this.frerePK = frerePK;
    }

    public Frere(FrerePK frerePK, String prenomfrere) {
        this.frerePK = frerePK;
        this.prenomfrere = prenomfrere;
    }

    public Frere(String nDossierF, int idfrere) {
        this.frerePK = new FrerePK(nDossierF, idfrere);
    }

    public FrerePK getFrerePK() {
        return frerePK;
    }

    public void setFrerePK(FrerePK frerePK) {
        this.frerePK = frerePK;
    }

    public String getPrenomfrere() {
        return prenomfrere;
    }

    public void setPrenomfrere(String prenomfrere) {
        this.prenomfrere = prenomfrere;
    }

    public String getAtteint() {
        return atteint;
    }

    public void setAtteint(String atteint) {
        this.atteint = atteint;
    }

    public Integer getPlacefratrie() {
        return placefratrie;
    }

    public void setPlacefratrie(Integer placefratrie) {
        this.placefratrie = placefratrie;
    }

    public String getSexeF() {
        return sexeF;
    }

    public void setSexeF(String sexeF) {
        this.sexeF = sexeF;
    }

    public String getDecedes() {
        return decedes;
    }

    public void setDecedes(String decedes) {
        this.decedes = decedes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frerePK != null ? frerePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frere)) {
            return false;
        }
        Frere other = (Frere) object;
        if ((this.frerePK == null && other.frerePK != null) || (this.frerePK != null && !this.frerePK.equals(other.frerePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Frere[ frerePK=" + frerePK + " ]";
    }
    
}
