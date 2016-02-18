/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.controller;

import com.cours.sessions.TacheFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author gassama
 */
@Named(value = "tacheController")
@SessionScoped
public class TacheController implements Serializable {

    @EJB
    private TacheFacade tacheFacade;
    private String description;
    private String path;
    private Date datefin;
    /**
     * Creates a new instance of TacheController
     */
    public TacheController() {
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

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
    
    public String suivant(){
    return "Suite";
    }
    public String validerjob(){
        
        return "Acceuil_client";
    }
}
