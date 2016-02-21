/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.sessions;

import com.cours.controller.SessionBean;
import com.cours.entities.Client;
import com.cours.entities.Tache;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gassama
 */
@Stateless
public class TacheFacade extends AbstractFacade<Tache> {

    @EJB
    private ClientFacade clientFacade;

    @PersistenceContext(unitName = "KGFouleFactoryPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TacheFacade() {
        super(Tache.class);
    }
    
    public void ajouter(Tache tache){
            em.persist(tache);
            }
    
    public List<Tache> FindAllUserTaches(String etat){
        HttpSession session = SessionBean.getSession();
        String  email = session.getAttribute("email").toString();
        Client c = new Client();
        c = clientFacade.FindByEmail(email);
        List<Tache> taches= em.createNamedQuery("Tache.findByClientandEtat")
                    .setParameter("id", c)
                    .setParameter("etat", etat)
                    .getResultList();
        return taches;
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
}
