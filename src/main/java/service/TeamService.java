/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Manager;
import model.Players;
import model.Team;

/**
 *
 * @author Satish
 */
@Named
@Stateless
public class TeamService {

    @PersistenceContext(unitName = "ssivaku1PU")
    private EntityManager em;

    public TeamService() {
    }

    public void create(Players p) {

        em.persist(p);
    }

    public Players find(int i) {
        return em.find(Players.class, i);
    }

    public void update(Players updatedPlayer) {

        Players existingPlayer = find(updatedPlayer.getId());

        updatedPlayer.setManager(existingPlayer.getManager());

        em.merge(updatedPlayer);
    }

    public void remove(Players p) {

        p = em.getReference(Players.class, p.getId());

        p.getManager().removePlayer(p);

        em.remove(p);
    }

    public List<Team> findAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }

    public List<Players> findAlls() {
        return em.createNamedQuery("Players.findAll", Players.class).getResultList();
    }

    public Players findByUsername(String username) {
        return em.createNamedQuery("Players.findByUsername", Players.class).setParameter("userName", username).getSingleResult();
    }

}
