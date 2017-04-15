/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import model.Players;
import model.security.Group;
import model.security.User;

/**
 *
 * @author Satish
 */
@Startup
@Singleton
public class AppInitializer {

    @EJB
    UserService userService;
    @EJB
    GroupService groupService;
    @EJB
    PlayersService playersService;
    @EJB
    TeamService teamService;

    public AppInitializer() {
    }

    @PostConstruct
    private void appInit() {

        User player7user = new User("player7", "player7");
        Group playersGroup = groupService.findGroupByName("PLAYERS");
        player7user.addGroup(playersGroup);
        Players player7 = new Players(23, 5, "Player", "Seven");
        player7.setUser(player7user);

        userService.create(player7user);
        teamService.create(player7);

    }
}
