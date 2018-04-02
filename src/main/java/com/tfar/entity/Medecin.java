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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatem
 */
@Entity
@Table(name = "medecin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m"),
    @NamedQuery(name = "Medecin.findByCin", query = "SELECT m FROM Medecin m WHERE m.cin = :cin"),
    @NamedQuery(name = "Medecin.findByNomMedecin", query = "SELECT m FROM Medecin m WHERE m.nomMedecin = :nomMedecin"),
    @NamedQuery(name = "Medecin.findByPrenomMedecin", query = "SELECT m FROM Medecin m WHERE m.prenomMedecin = :prenomMedecin"),
    @NamedQuery(name = "Medecin.findByGrade", query = "SELECT m FROM Medecin m WHERE m.grade = :grade"),
    @NamedQuery(name = "Medecin.findByTypeMedecin", query = "SELECT m FROM Medecin m WHERE m.typeMedecin = :typeMedecin"),
    @NamedQuery(name = "Medecin.findByGouvernoratM", query = "SELECT m FROM Medecin m WHERE m.gouvernoratM = :gouvernoratM"),
    @NamedQuery(name = "Medecin.findByAdresseM", query = "SELECT m FROM Medecin m WHERE m.adresseM = :adresseM"),
    @NamedQuery(name = "Medecin.findByTelM", query = "SELECT m FROM Medecin m WHERE m.telM = :telM"),
    @NamedQuery(name = "Medecin.findByPosteM", query = "SELECT m FROM Medecin m WHERE m.posteM = :posteM"),
    @NamedQuery(name = "Medecin.findByFaxM", query = "SELECT m FROM Medecin m WHERE m.faxM = :faxM"),
    @NamedQuery(name = "Medecin.findByEmailM", query = "SELECT m FROM Medecin m WHERE m.emailM = :emailM"),
    @NamedQuery(name = "Medecin.findByHopital", query = "SELECT m FROM Medecin m WHERE m.hopital = :hopital"),
    @NamedQuery(name = "Medecin.findByService", query = "SELECT m FROM Medecin m WHERE m.service = :service"),
    @NamedQuery(name = "Medecin.findByLogin", query = "SELECT m FROM Medecin m WHERE m.login = :login"),
    @NamedQuery(name = "Medecin.findByPasswd", query = "SELECT m FROM Medecin m WHERE m.passwd = :passwd"),
    @NamedQuery(name = "Medecin.findByUrl", query = "SELECT m FROM Medecin m WHERE m.url = :url")})
public class Medecin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CIN", nullable = false)
    private Integer cin;
    @Size(max = 30)
    @Column(name = "Nom_Medecin", length = 30)
    private String nomMedecin;
    @Size(max = 30)
    @Column(name = "Prenom_Medecin", length = 30)
    private String prenomMedecin;
    @Size(max = 30)
    @Column(name = "Grade", length = 30)
    private String grade;
    @Size(max = 30)
    @Column(name = "TypeMedecin", length = 30)
    private String typeMedecin;
    @Size(max = 30)
    @Column(name = "Gouvernorat_M", length = 30)
    private String gouvernoratM;
    @Size(max = 100)
    @Column(name = "Adresse_M", length = 100)
    private String adresseM;
    @Size(max = 15)
    @Column(name = "Tel_M", length = 15)
    private String telM;
    @Size(max = 8)
    @Column(name = "Poste_M", length = 8)
    private String posteM;
    @Size(max = 15)
    @Column(name = "Fax_M", length = 15)
    private String faxM;
    @Size(max = 50)
    @Column(name = "E_mail_M", length = 50)
    private String emailM;
    @Size(max = 100)
    @Column(name = "Hopital", length = 100)
    private String hopital;
    @Size(max = 100)
    @Column(name = "Service", length = 100)
    private String service;
    @Lob
    @Column(name = "Image")
    private byte[] image;
    @Size(max = 10)
    @Column(name = "Login", length = 10)
    private String login;
    @Size(max = 10)
    @Column(name = "Passwd", length = 10)
    private String passwd;
    @Size(max = 500)
    @Column(name = "URL", length = 500)
    private String url;

    public Medecin() {
    }

    public Medecin(Integer cin) {
        this.cin = cin;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public void setPrenomMedecin(String prenomMedecin) {
        this.prenomMedecin = prenomMedecin;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTypeMedecin() {
        return typeMedecin;
    }

    public void setTypeMedecin(String typeMedecin) {
        this.typeMedecin = typeMedecin;
    }

    public String getGouvernoratM() {
        return gouvernoratM;
    }

    public void setGouvernoratM(String gouvernoratM) {
        this.gouvernoratM = gouvernoratM;
    }

    public String getAdresseM() {
        return adresseM;
    }

    public void setAdresseM(String adresseM) {
        this.adresseM = adresseM;
    }

    public String getTelM() {
        return telM;
    }

    public void setTelM(String telM) {
        this.telM = telM;
    }

    public String getPosteM() {
        return posteM;
    }

    public void setPosteM(String posteM) {
        this.posteM = posteM;
    }

    public String getFaxM() {
        return faxM;
    }

    public void setFaxM(String faxM) {
        this.faxM = faxM;
    }

    public String getEmailM() {
        return emailM;
    }

    public void setEmailM(String emailM) {
        this.emailM = emailM;
    }

    public String getHopital() {
        return hopital;
    }

    public void setHopital(String hopital) {
        this.hopital = hopital;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
        hash += (cin != null ? cin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.cin == null && other.cin != null) || (this.cin != null && !this.cin.equals(other.cin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Medecin[ cin=" + cin + " ]";
    }
    
}
