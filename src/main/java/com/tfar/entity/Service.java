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
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByCodeService", query = "SELECT s FROM Service s WHERE s.codeService = :codeService"),
    @NamedQuery(name = "Service.findByNomService", query = "SELECT s FROM Service s WHERE s.nomService = :nomService")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code_Service", nullable = false)
    private Integer codeService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nom_Service", nullable = false, length = 20)
    private String nomService;

    public Service() {
    }

    public Service(Integer codeService) {
        this.codeService = codeService;
    }

    public Service(Integer codeService, String nomService) {
        this.codeService = codeService;
        this.nomService = nomService;
    }

    public Integer getCodeService() {
        return codeService;
    }

    public void setCodeService(Integer codeService) {
        this.codeService = codeService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeService != null ? codeService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.codeService == null && other.codeService != null) || (this.codeService != null && !this.codeService.equals(other.codeService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Service[ codeService=" + codeService + " ]";
    }
    
}
