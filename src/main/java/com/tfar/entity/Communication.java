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
@Table(name = "communication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Communication.findAll", query = "SELECT c FROM Communication c"),
    @NamedQuery(name = "Communication.findByCode", query = "SELECT c FROM Communication c WHERE c.code = :code"),
    @NamedQuery(name = "Communication.findByTitre", query = "SELECT c FROM Communication c WHERE c.titre = :titre"),
    @NamedQuery(name = "Communication.findByAuteurs", query = "SELECT c FROM Communication c WHERE c.auteurs = :auteurs"),
    @NamedQuery(name = "Communication.findByConference", query = "SELECT c FROM Communication c WHERE c.conference = :conference"),
    @NamedQuery(name = "Communication.findByPages", query = "SELECT c FROM Communication c WHERE c.pages = :pages"),
    @NamedQuery(name = "Communication.findByAnneepub", query = "SELECT c FROM Communication c WHERE c.anneepub = :anneepub"),
    @NamedQuery(name = "Communication.findByLieu", query = "SELECT c FROM Communication c WHERE c.lieu = :lieu"),
    @NamedQuery(name = "Communication.findByLien", query = "SELECT c FROM Communication c WHERE c.lien = :lien")})
public class Communication implements Serializable {

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
    @Size(max = 500)
    @Column(name = "Conference", length = 500)
    private String conference;
    @Size(max = 30)
    @Column(name = "Pages", length = 30)
    private String pages;
    @Size(max = 20)
    @Column(name = "Anneepub", length = 20)
    private String anneepub;
    @Size(max = 500)
    @Column(name = "Lieu", length = 500)
    private String lieu;
    @Size(max = 500)
    @Column(name = "Lien", length = 500)
    private String lien;

    public Communication() {
    }

    public Communication(Integer code) {
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

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAnneepub() {
        return anneepub;
    }

    public void setAnneepub(String anneepub) {
        this.anneepub = anneepub;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
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
        if (!(object instanceof Communication)) {
            return false;
        }
        Communication other = (Communication) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Communication[ code=" + code + " ]";
    }
    
}
