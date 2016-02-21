/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.controller;

import com.cours.sessions.FouleurFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gassama
 */
@Named(value = "fouleurController")
@SessionScoped
public class FouleurController implements Serializable {

    @EJB
    private FouleurFacade fouleurFacade;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Creates a new instance of FouleurController
     */
    public FouleurController() {
    }
    
    public String validateUsernamePassword() {
        
        if (fouleurFacade.VerifierPseudoPassword(username, password)) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", username);
            return "Acceuil_fouleur";
        } else {
           FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login_turkeur";
        }
    }
    
     public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login_turkeur";
    }
     
}
