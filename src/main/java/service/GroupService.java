/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import model.security.Group;

@Stateless
public class GroupService extends BaseService<Group> {

    public GroupService() {
        super(Group.class);
    }

    public Group findGroupByName(String name) {
        return getEntityManager()
                .createQuery("select g from Group g where g.groupName = :name", Group.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Group> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
