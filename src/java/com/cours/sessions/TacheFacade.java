/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.sessions;

import com.cours.entities.Tache;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gassama
 */
@Stateless
public class TacheFacade extends AbstractFacade<Tache> {

    @PersistenceContext(unitName = "KGFouleFactoryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TacheFacade() {
        super(Tache.class);
    }
    
}
