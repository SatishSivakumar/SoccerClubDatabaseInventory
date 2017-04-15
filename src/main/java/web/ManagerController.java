/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Manager;
import model.Players;
import model.Team;
import model.security.User;
import service.GroupService;
import service.ManagerService;
import service.PlayersService;
import service.TeamService;
import service.UserService;

/**
 *
 * @author Satish
 */
@Named
@RequestScoped
public class ManagerController extends BaseController {

    private static final Logger LOG = Logger.getLogger(ManagerController.class.getName());

    @Inject
    LoginController loginController;
    @EJB
    ManagerService managerService;

    @EJB
    PlayersService playersService;

    @EJB
    TeamService teamService;

    @EJB
    GroupService groupService;

    @EJB
    UserService userService;

    private Players players;
    private Manager manager;
private Team team;
    List<Players> managerPlayers = new ArrayList<>();

    public Players getPlayer() {
        return players;
    }

    public void setPlayer(Players players) {
        this.players = players;
    }

    public List<Players> getManagerPlayers() {
        return managerPlayers;
    }

    public void setManagerPlayers(List<Players> managerPlayers) {
        this.managerPlayers = managerPlayers;
    }

    public ManagerController() {
    }

    private void refreshPlayers() {
        managerPlayers = managerService.findByUsername(loginController.getRemoteUser()).getPlayers();

    }

    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        manager = managerService.findByUsername(loginController.getRemoteUser());
        refreshPlayers();
        players = new Players();
        players.setUser(new User());
        players.setManager(manager);
    }

    public String doCreatePlayer() {
        LOG.info("inside doCreatePlayer with " + manager.toString());

        players = new Players();

        players.setUser(new User());
        players.setManager(manager);

        return loginController.conditionalizeContextPath("editPlayers.xhtml");
    }

    public String doUpdatePlayer(Players p) {
        this.players = p;
        LOG.info("inside doUpdatePlayers with " + p.toString());
        return loginController.conditionalizeContextPath("editPlayers.xhtml");
    }

    public String executeUpdate() {

        if (this.players.getId() != null) {
            LOG.info("Updating player " + this.players.toString());

//            players.getUser().addGroup(groupService.findGroupByName("PLAYERS"));
//            userService.create(players.getUser());
players.getUser().setPassword("student");
            teamService.update(players);

        } else {
            LOG.info("Creating new player " + this.players.toString());
            managerPlayers = playersService.findAll();
            manager.setPlayers(managerPlayers);
            players.setManager(manager);
            players.getUser().addGroup(groupService.findGroupByName("PLAYERS"));
            players.getUser().setPassword("student");
            userService.create(players.getUser());

            managerService.create(players);
        }

        return loginController.conditionalizeContextPath("welcome.xhtml?faces-redirect=true");
    }

    public String doViewPlayer(Players p) {
        this.players = p;
        LOG.info("inside doViewPlayer with " + p.toString());
        return loginController.conditionalizeContextPath("displayPlayers.xhtml");
    }

    public String doDeletePlayer(Players p) {
        this.players = p;
        LOG.info("inside doDeletePlayer with " + p.toString());
        teamService.remove(p);
        return loginController.conditionalizeContextPath("welcome.xhtml?faces-redirect=true");
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
