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
@Table(name = "scientifique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scientifique.findAll", query = "SELECT s FROM Scientifique s"),
    @NamedQuery(name = "Scientifique.findByCodeSC", query = "SELECT s FROM Scientifique s WHERE s.codeSC = :codeSC"),
    @NamedQuery(name = "Scientifique.findByNomSC", query = "SELECT s FROM Scientifique s WHERE s.nomSC = :nomSC"),
    @NamedQuery(name = "Scientifique.findByPrenomSC", query = "SELECT s FROM Scientifique s WHERE s.prenomSC = :prenomSC"),
    @NamedQuery(name = "Scientifique.findByServiceSC", query = "SELECT s FROM Scientifique s WHERE s.serviceSC = :serviceSC"),
    @NamedQuery(name = "Scientifique.findByCentreSC", query = "SELECT s FROM Scientifique s WHERE s.centreSC = :centreSC"),
    @NamedQuery(name = "Scientifique.findByAdresseSC", query = "SELECT s FROM Scientifique s WHERE s.adresseSC = :adresseSC"),
    @NamedQuery(name = "Scientifique.findByTelSC", query = "SELECT s FROM Scientifique s WHERE s.telSC = :telSC"),
    @NamedQuery(name = "Scientifique.findByEmailSC", query = "SELECT s FROM Scientifique s WHERE s.emailSC = :emailSC"),
    @NamedQuery(name = "Scientifique.findByTypeSC", query = "SELECT s FROM Scientifique s WHERE s.typeSC = :typeSC"),
    @NamedQuery(name = "Scientifique.findByLoginSC", query = "SELECT s FROM Scientifique s WHERE s.loginSC = :loginSC"),
    @NamedQuery(name = "Scientifique.findByPasswdSC", query = "SELECT s FROM Scientifique s WHERE s.passwdSC = :passwdSC"),
    @NamedQuery(name = "Scientifique.findByUrl", query = "SELECT s FROM Scientifique s WHERE s.url = :url")})
public class Scientifique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodeSC", nullable = false)
    private Integer codeSC;
    @Size(max = 20)
    @Column(name = "NomSC", length = 20)
    private String nomSC;
    @Size(max = 20)
    @Column(name = "PrenomSC", length = 20)
    private String prenomSC;
    @Size(max = 100)
    @Column(name = "ServiceSC", length = 100)
    private String serviceSC;
    @Size(max = 100)
    @Column(name = "CentreSC", length = 100)
    private String centreSC;
    @Size(max = 100)
    @Column(name = "AdresseSC", length = 100)
    private String adresseSC;
    @Size(max = 30)
    @Column(name = "TelSC", length = 30)
    private String telSC;
    @Size(max = 30)
    @Column(name = "EmailSC", length = 30)
    private String emailSC;
    @Lob
    @Column(name = "PhotoSC")
    private byte[] photoSC;
    @Size(max = 10)
    @Column(name = "TypeSC", length = 10)
    private String typeSC;
    @Size(max = 10)
    @Column(name = "LoginSC", length = 10)
    private String loginSC;
    @Size(max = 10)
    @Column(name = "PasswdSC", length = 10)
    private String passwdSC;
    @Size(max = 500)
    @Column(name = "URL", length = 500)
    private String url;

    public Scientifique() {
    }

    public Scientifique(Integer codeSC) {
        this.codeSC = codeSC;
    }

    public Integer getCodeSC() {
        return codeSC;
    }

    public void setCodeSC(Integer codeSC) {
        this.codeSC = codeSC;
    }

    public String getNomSC() {
        return nomSC;
    }

    public void setNomSC(String nomSC) {
        this.nomSC = nomSC;
    }

    public String getPrenomSC() {
        return prenomSC;
    }

    public void setPrenomSC(String prenomSC) {
        this.prenomSC = prenomSC;
    }

    public String getServiceSC() {
        return serviceSC;
    }

    public void setServiceSC(String serviceSC) {
        this.serviceSC = serviceSC;
    }

    public String getCentreSC() {
        return centreSC;
    }

    public void setCentreSC(String centreSC) {
        this.centreSC = centreSC;
    }

    public String getAdresseSC() {
        return adresseSC;
    }

    public void setAdresseSC(String adresseSC) {
        this.adresseSC = adresseSC;
    }

    public String getTelSC() {
        return telSC;
    }

    public void setTelSC(String telSC) {
        this.telSC = telSC;
    }

    public String getEmailSC() {
        return emailSC;
    }

    public void setEmailSC(String emailSC) {
        this.emailSC = emailSC;
    }

    public byte[] getPhotoSC() {
        return photoSC;
    }

    public void setPhotoSC(byte[] photoSC) {
        this.photoSC = photoSC;
    }

    public String getTypeSC() {
        return typeSC;
    }

    public void setTypeSC(String typeSC) {
        this.typeSC = typeSC;
    }

    public String getLoginSC() {
        return loginSC;
    }

    public void setLoginSC(String loginSC) {
        this.loginSC = loginSC;
    }

    public String getPasswdSC() {
        return passwdSC;
    }

    public void setPasswdSC(String passwdSC) {
        this.passwdSC = passwdSC;
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
        hash += (codeSC != null ? codeSC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scientifique)) {
            return false;
        }
        Scientifique other = (Scientifique) object;
        if ((this.codeSC == null && other.codeSC != null) || (this.codeSC != null && !this.codeSC.equals(other.codeSC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Scientifique[ codeSC=" + codeSC + " ]";
    }
    
}
