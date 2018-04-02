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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatem
 */
@Entity
@Table(name = "these")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "These.findAll", query = "SELECT t FROM These t"),
    @NamedQuery(name = "These.findByCode", query = "SELECT t FROM These t WHERE t.code = :code"),
    @NamedQuery(name = "These.findByTitre", query = "SELECT t FROM These t WHERE t.titre = :titre"),
    @NamedQuery(name = "These.findByAuteurs", query = "SELECT t FROM These t WHERE t.auteurs = :auteurs"),
    @NamedQuery(name = "These.findByEtablissement", query = "SELECT t FROM These t WHERE t.etablissement = :etablissement"),
    @NamedQuery(name = "These.findByDatePub", query = "SELECT t FROM These t WHERE t.datePub = :datePub"),
    @NamedQuery(name = "These.findByDiplome", query = "SELECT t FROM These t WHERE t.diplome = :diplome"),
    @NamedQuery(name = "These.findByDownload", query = "SELECT t FROM These t WHERE t.download = :download")})
public class These implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;
    @Size(max = 500)
    @Column(name = "Titre", length = 500)
    private String titre;
    @Size(max = 500)
    @Column(name = "Auteurs", length = 500)
    private String auteurs;
    @Size(max = 200)
    @Column(name = "Etablissement", length = 200)
    private String etablissement;
    @Size(max = 100)
    @Column(name = "DatePub", length = 100)
    private String datePub;
    @Size(max = 60)
    @Column(name = "Diplome", length = 60)
    private String diplome;
    @Size(max = 500)
    @Column(name = "Download", length = 500)
    private String download;

    public These() {
    }

    public These(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getDatePub() {
        return datePub;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof These)) {
            return false;
        }
        These other = (These) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.These[ code=" + code + " ]";
    }
    
}
