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
import javax.persistence.Lob;
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
@Table(name = "Fouleur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fouleur.findAll", query = "SELECT f FROM Fouleur f"),
    @NamedQuery(name = "Fouleur.findById", query = "SELECT f FROM Fouleur f WHERE f.id = :id"),
    @NamedQuery(name = "Fouleur.findByDatenaiss", query = "SELECT f FROM Fouleur f WHERE f.datenaiss = :datenaiss"),
    @NamedQuery(name = "Fouleur.findByDateinsc", query = "SELECT f FROM Fouleur f WHERE f.dateinsc = :dateinsc"),
    @NamedQuery(name = "Fouleur.findByPseudoPassword", query = "SELECT f FROM Fouleur f WHERE f.pseudo = :pseudo and f.password = :password"),
    @NamedQuery(name = "Fouleur.findByPseudo", query = "SELECT f FROM Fouleur f WHERE f.pseudo = :pseudo")})
public class Fouleur implements Serializable {

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
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prenom")
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateinsc")
    @Temporal(TemporalType.DATE)
    private Date dateinsc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pseudo")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "password")
    private String password;

    public Fouleur() {
    }

    public Fouleur(Integer id) {
        this.id = id;
    }

    public Fouleur(Integer id, String nom, String prenom, String email, Date datenaiss, Date dateinsc, String adress, String pseudo, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datenaiss = datenaiss;
        this.dateinsc = dateinsc;
        this.adress = adress;
        this.pseudo = pseudo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public Date getDateinsc() {
        return dateinsc;
    }

    public void setDateinsc(Date dateinsc) {
        this.dateinsc = dateinsc;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Fouleur)) {
            return false;
        }
        Fouleur other = (Fouleur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cours.entities.Fouleur[ id=" + id + " ]";
    }
    
}
