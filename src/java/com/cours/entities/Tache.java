/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author gassama
 */
@Entity
@Table(name = "Tache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findById", query = "SELECT t FROM Tache t WHERE t.id = :id"),
    @NamedQuery(name = "Tache.findByClientandEtat", query = "SELECT t FROM Tache t WHERE t.idclient = :id and t.etat = :etat"),
    @NamedQuery(name = "Tache.findByPath", query = "SELECT t FROM Tache t WHERE t.path = :path"),
    @NamedQuery(name = "Tache.findByPrixtache", query = "SELECT t FROM Tache t WHERE t.prixtache = :prixtache"),
    @NamedQuery(name = "Tache.findByDatecreation", query = "SELECT t FROM Tache t WHERE t.datecreation = :datecreation"),
    @NamedQuery(name = "Tache.findByDatefin", query = "SELECT t FROM Tache t WHERE t.datefin = :datefin"),
    @NamedQuery(name = "Tache.findByNbfouleur", query = "SELECT t FROM Tache t WHERE t.nbfouleur = :nbfouleur")})
public class Tache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixtache")
    private int prixtache;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreation")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbfouleur")
    private int nbfouleur;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "etat")
    private String etat;
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idclient;

    public Tache() {
    }

    public Tache(Integer id) {
        this.id = id;
    }

    public Tache(Integer id, String description, String path, int prixtache, Date datecreation, Date datefin, int nbfouleur, String etat) {
        this.id = id;
        this.description = description;
        this.path = path;
        this.prixtache = prixtache;
        this.datecreation = datecreation;
        this.datefin = datefin;
        this.nbfouleur = nbfouleur;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPrixtache() {
        return prixtache;
    }

    public void setPrixtache(int prixtache) {
        this.prixtache = prixtache;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getNbfouleur() {
        return nbfouleur;
    }

    public void setNbfouleur(int nbfouleur) {
        this.nbfouleur = nbfouleur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cours.entities.Tache[ id=" + id + " ]";
    }
    
}
