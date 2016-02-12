/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.sessions;

import com.cours.entities.Fouleur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gassama
 */
@Stateless
public class FouleurFacade extends AbstractFacade<Fouleur> {

    @PersistenceContext(unitName = "KGFouleFactoryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FouleurFacade() {
        super(Fouleur.class);
    }
    
     public boolean VerifierPseudoPassword(String pseudo, String password) {
         
        List<Fouleur> results = em.createNamedQuery("Fouleur.findByPseudoPassword")
                    .setParameter("pseudo", pseudo)
                    .setParameter("password", password)
                    .getResultList();

        if ( !results.isEmpty() ) {

           return true;

        }
        
        return false;
    }
}
