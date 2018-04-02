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
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByCode", query = "SELECT a FROM Article a WHERE a.code = :code"),
    @NamedQuery(name = "Article.findByTitre", query = "SELECT a FROM Article a WHERE a.titre = :titre"),
    @NamedQuery(name = "Article.findByAuteurs", query = "SELECT a FROM Article a WHERE a.auteurs = :auteurs"),
    @NamedQuery(name = "Article.findByPages", query = "SELECT a FROM Article a WHERE a.pages = :pages"),
    @NamedQuery(name = "Article.findByDatePub", query = "SELECT a FROM Article a WHERE a.datePub = :datePub"),
    @NamedQuery(name = "Article.findByJournal", query = "SELECT a FROM Article a WHERE a.journal = :journal"),
    @NamedQuery(name = "Article.findByVolJournal", query = "SELECT a FROM Article a WHERE a.volJournal = :volJournal"),
    @NamedQuery(name = "Article.findByNumJournal", query = "SELECT a FROM Article a WHERE a.numJournal = :numJournal"),
    @NamedQuery(name = "Article.findByLien", query = "SELECT a FROM Article a WHERE a.lien = :lien")})
public class Article implements Serializable {

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
    @Size(max = 20)
    @Column(name = "Pages", length = 20)
    private String pages;
    @Size(max = 20)
    @Column(name = "DatePub", length = 20)
    private String datePub;
    @Size(max = 100)
    @Column(name = "Journal", length = 100)
    private String journal;
    @Size(max = 10)
    @Column(name = "volJournal", length = 10)
    private String volJournal;
    @Size(max = 10)
    @Column(name = "numJournal", length = 10)
    private String numJournal;
    @Size(max = 500)
    @Column(name = "Lien", length = 500)
    private String lien;

    public Article() {
    }

    public Article(Integer code) {
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

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDatePub() {
        return datePub;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getVolJournal() {
        return volJournal;
    }

    public void setVolJournal(String volJournal) {
        this.volJournal = volJournal;
    }

    public String getNumJournal() {
        return numJournal;
    }

    public void setNumJournal(String numJournal) {
        this.numJournal = numJournal;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Article[ code=" + code + " ]";
    }
    
}
