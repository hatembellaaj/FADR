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
import javax.persistence.Lob;
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
@Table(name = "cytogeneticien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cytogeneticien.findAll", query = "SELECT c FROM Cytogeneticien c"),
    @NamedQuery(name = "Cytogeneticien.findByCode", query = "SELECT c FROM Cytogeneticien c WHERE c.code = :code"),
    @NamedQuery(name = "Cytogeneticien.findByNom", query = "SELECT c FROM Cytogeneticien c WHERE c.nom = :nom"),
    @NamedQuery(name = "Cytogeneticien.findByPrenom", query = "SELECT c FROM Cytogeneticien c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Cytogeneticien.findByService", query = "SELECT c FROM Cytogeneticien c WHERE c.service = :service"),
    @NamedQuery(name = "Cytogeneticien.findByEtab", query = "SELECT c FROM Cytogeneticien c WHERE c.etab = :etab"),
    @NamedQuery(name = "Cytogeneticien.findByAdresse", query = "SELECT c FROM Cytogeneticien c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Cytogeneticien.findByTel", query = "SELECT c FROM Cytogeneticien c WHERE c.tel = :tel"),
    @NamedQuery(name = "Cytogeneticien.findByPoste", query = "SELECT c FROM Cytogeneticien c WHERE c.poste = :poste"),
    @NamedQuery(name = "Cytogeneticien.findByFax", query = "SELECT c FROM Cytogeneticien c WHERE c.fax = :fax"),
    @NamedQuery(name = "Cytogeneticien.findByEmail", query = "SELECT c FROM Cytogeneticien c WHERE c.email = :email"),
    @NamedQuery(name = "Cytogeneticien.findByType", query = "SELECT c FROM Cytogeneticien c WHERE c.type = :type"),
    @NamedQuery(name = "Cytogeneticien.findByLogin", query = "SELECT c FROM Cytogeneticien c WHERE c.login = :login"),
    @NamedQuery(name = "Cytogeneticien.findByPasswd", query = "SELECT c FROM Cytogeneticien c WHERE c.passwd = :passwd"),
    @NamedQuery(name = "Cytogeneticien.findByUrl", query = "SELECT c FROM Cytogeneticien c WHERE c.url = :url")})
public class Cytogeneticien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nom", nullable = false, length = 30)
    private String nom;
    @Size(max = 30)
    @Column(name = "Prenom", length = 30)
    private String prenom;
    @Size(max = 200)
    @Column(name = "Service", length = 200)
    private String service;
    @Size(max = 200)
    @Column(name = "Etab", length = 200)
    private String etab;
    @Size(max = 200)
    @Column(name = "Adresse", length = 200)
    private String adresse;
    @Size(max = 20)
    @Column(name = "Tel", length = 20)
    private String tel;
    @Size(max = 20)
    @Column(name = "Poste", length = 20)
    private String poste;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Fax", length = 20)
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "Email", length = 200)
    private String email;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    @Size(max = 20)
    @Column(name = "Type", length = 20)
    private String type;
    @Size(max = 20)
    @Column(name = "Login", length = 20)
    private String login;
    @Size(max = 20)
    @Column(name = "Passwd", length = 20)
    private String passwd;
    @Size(max = 500)
    @Column(name = "URL", length = 500)
    private String url;

    public Cytogeneticien() {
    }

    public Cytogeneticien(Integer code) {
        this.code = code;
    }

    public Cytogeneticien(Integer code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEtab() {
        return etab;
    }

    public void setEtab(String etab) {
        this.etab = etab;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Cytogeneticien)) {
            return false;
        }
        Cytogeneticien other = (Cytogeneticien) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Cytogeneticien[ code=" + code + " ]";
    }
    
}
