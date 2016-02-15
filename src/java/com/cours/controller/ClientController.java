/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.controller;

import com.cours.sessions.ClientFacade;
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
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable {

    private String email;
    private String password;
    
    @EJB
    private ClientFacade clientFacade;

    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String validateEmailPassword() {
        
        if (clientFacade.VerifierEmailPassword(email, password)) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("email", email);
            return "Acceuil_client";
        } else {
           FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login_client";
        }
    }
    
     public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login_turkeur";
    }
    
}
