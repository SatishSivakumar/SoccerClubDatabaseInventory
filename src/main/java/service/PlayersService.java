/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.security.acl.Owner;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Manager;
import model.Players;

/**
 *
 * @author Satish
 */
@Named
@Stateless
public class PlayersService {

    @PersistenceContext(unitName = "ssivaku1PU")
    private EntityManager em;

    public List<Players> findAll() {
        return em.createNamedQuery("Players.findAll", Players.class).getResultList();
    }

    public Players findByUsername(String username) {
        return em.createNamedQuery("Players.findByUsername", Players.class).setParameter("userName", username).getSingleResult();
    }

}
