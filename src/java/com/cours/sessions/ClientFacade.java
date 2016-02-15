/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.sessions;

import com.cours.entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gassama
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "KGFouleFactoryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    public boolean VerifierEmailPassword(String email, String password) {
         
        List<Client> results = em.createNamedQuery("Client.findByEmailandPassword")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultList();

        if (!results.isEmpty() ) {

           return true;

        }
        
        return false;
    }
}
