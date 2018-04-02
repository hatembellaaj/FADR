/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "hopitale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hopitale.findAll", query = "SELECT h FROM Hopitale h"),
    @NamedQuery(name = "Hopitale.findByCodehopitale", query = "SELECT h FROM Hopitale h WHERE h.codehopitale = :codehopitale"),
    @NamedQuery(name = "Hopitale.findByNomHopitale", query = "SELECT h FROM Hopitale h WHERE h.nomHopitale = :nomHopitale")})
public class Hopitale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code_hopitale", nullable = false)
    private Integer codehopitale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Hopitale", nullable = false, length = 50)
    private String nomHopitale;

    public Hopitale() {
    }

    public Hopitale(Integer codehopitale) {
        this.codehopitale = codehopitale;
    }

    public Hopitale(Integer codehopitale, String nomHopitale) {
        this.codehopitale = codehopitale;
        this.nomHopitale = nomHopitale;
    }

    public Integer getCodehopitale() {
        return codehopitale;
    }

    public void setCodehopitale(Integer codehopitale) {
        this.codehopitale = codehopitale;
    }

    public String getNomHopitale() {
        return nomHopitale;
    }

    public void setNomHopitale(String nomHopitale) {
        this.nomHopitale = nomHopitale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codehopitale != null ? codehopitale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hopitale)) {
            return false;
        }
        Hopitale other = (Hopitale) object;
        if ((this.codehopitale == null && other.codehopitale != null) || (this.codehopitale != null && !this.codehopitale.equals(other.codehopitale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Hopitale[ codehopitale=" + codehopitale + " ]";
    }
    
}
