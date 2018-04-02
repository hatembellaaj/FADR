/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatem
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByNdossierP", query = "SELECT p FROM Patient p WHERE p.ndossierP = :ndossierP"),
    @NamedQuery(name = "Patient.findByNom", query = "SELECT p FROM Patient p WHERE p.nom = :nom"),
    @NamedQuery(name = "Patient.findByPrenom", query = "SELECT p FROM Patient p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Patient.findByDateNaissance", query = "SELECT p FROM Patient p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Patient.findByLieuNaissance", query = "SELECT p FROM Patient p WHERE p.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Patient.findBySexe", query = "SELECT p FROM Patient p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Patient.findByGouvernorat", query = "SELECT p FROM Patient p WHERE p.gouvernorat = :gouvernorat"),
    @NamedQuery(name = "Patient.findByAdresse", query = "SELECT p FROM Patient p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Patient.findByReperes", query = "SELECT p FROM Patient p WHERE p.reperes = :reperes"),
    @NamedQuery(name = "Patient.findByTel", query = "SELECT p FROM Patient p WHERE p.tel = :tel"),
    @NamedQuery(name = "Patient.findByPrenomPere", query = "SELECT p FROM Patient p WHERE p.prenomPere = :prenomPere"),
    @NamedQuery(name = "Patient.findByNomMere", query = "SELECT p FROM Patient p WHERE p.nomMere = :nomMere"),
    @NamedQuery(name = "Patient.findByPrenomMere", query = "SELECT p FROM Patient p WHERE p.prenomMere = :prenomMere"),
    @NamedQuery(name = "Patient.findByNomGMP", query = "SELECT p FROM Patient p WHERE p.nomGMP = :nomGMP"),
    @NamedQuery(name = "Patient.findByNomGMM", query = "SELECT p FROM Patient p WHERE p.nomGMM = :nomGMM"),
    @NamedQuery(name = "Patient.findByAge", query = "SELECT p FROM Patient p WHERE p.age = :age")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_dossier_P", nullable = false, length = 10)
    private String ndossierP;
    @Size(max = 30)
    @Column(name = "Nom", length = 30)
    private String nom;
    @Size(max = 30)
    @Column(name = "Prenom", length = 30)
    private String prenom;
    @Size(max = 10)    
    @Column(name = "Date_Naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 8)
    @Column(name = "LieuNaissance", length = 50)
    private String lieuNaissance;
    @Column(name = "Sexe")
    private Character sexe;
    @Size(max = 30)
    @Column(name = "Gouvernorat", length = 30)
    private String gouvernorat;
    @Size(max = 50)
    @Column(name = "Adresse", length = 50)
    private String adresse;
    @Size(max = 100)
    @Column(name = "Reperes", length = 100)
    private String reperes;
    @Size(max = 50)
    @Column(name = "Tel", length = 50)
    private String tel;
    @Size(max = 30)
    @Column(name = "PrenomPere", length = 30)
    private String prenomPere;
    @Size(max = 30)
    @Column(name = "NomMere", length = 30)
    private String nomMere;
    @Size(max = 30)
    @Column(name = "PrenomMere", length = 30)
    private String prenomMere;
    @Size(max = 30)
    @Column(name = "NomGMP", length = 30)
    private String nomGMP;
    @Size(max = 30)
    @Column(name = "NomGMM", length = 30)
    private String nomGMM;
    @Column(name = "Age")
    private Integer age;

    public Patient() {
    }

    public Patient(String ndossierP) {
        this.ndossierP = ndossierP;
    }

    public String getNdossierP() {
        return ndossierP;
    }

    public void setNdossierP(String ndossierP) {
        this.ndossierP = ndossierP;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getReperes() {
        return reperes;
    }

    public void setReperes(String reperes) {
        this.reperes = reperes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getNomGMP() {
        return nomGMP;
    }

    public void setNomGMP(String nomGMP) {
        this.nomGMP = nomGMP;
    }

    public String getNomGMM() {
        return nomGMM;
    }

    public void setNomGMM(String nomGMM) {
        this.nomGMM = nomGMM;
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
        hash += (ndossierP != null ? ndossierP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.ndossierP == null && other.ndossierP != null) || (this.ndossierP != null && !this.ndossierP.equals(other.ndossierP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Patient[ ndossierP=" + ndossierP + " ]";
    }
    
}
