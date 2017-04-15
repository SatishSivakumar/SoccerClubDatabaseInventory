/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import java.util.List;
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
public class ManagerService extends BaseService<Manager> {

    @PersistenceContext(unitName = "ssivaku1PU")
    private EntityManager em;

    public ManagerService() {
        super(Manager.class);
    }

    public void create(Players p) {
        //em.persist(p);
        Manager m = em.getReference(Manager.class, p.getManager().getId());
        m.addPlayer(p);

        em.persist(p);
    }

    @Override
    public List<Manager> findAll() {

        return getEntityManager().createNamedQuery("Manager.findAll", Manager.class).getResultList();
    }

    public Manager findByUsername(String username) {
        return getEntityManager().createNamedQuery("Manager.findByUsername", Manager.class).setParameter("userName", username).getSingleResult();
    }

}
