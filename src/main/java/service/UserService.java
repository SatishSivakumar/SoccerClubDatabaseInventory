/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.security.User;

@Stateless
public class UserService extends BaseService<User> {

    @PersistenceContext(unitName = "ssivaku1PU")
    private EntityManager em;
    
    public UserService() {
        super(User.class);
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void create(User user){
        em.persist(user);
    }
}
