/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import model.security.User;

/**
 *
 * @author Satish
 */
@Entity
@Table(name = "Manager")
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "select m from Manager m"),
    @NamedQuery(name = "Manager.findByUsername", query = "select m from Manager m where m.user.userName = :userName")
})

public class Manager extends Person {

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)

    private List<Team> team;

    @Column(name = "yearsoncontract")
    @NotNull
    private int yearsonContract;

    @Column(name = "country")
    @NotNull
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private List<Players> players;

    protected List<Players> getPlayersInternal() {
        if (this.players == null) {

            this.players = new ArrayList<>();
        }
        return this.players;
    }

    protected List<Team> getTeamsInternal() {
        if (this.team == null) {

            this.team = new ArrayList<>();
        }
        return this.team;
    }

    protected void setTeamsInternal(List<Team> team) {
        this.team = team;
    }

    public List<Team> getTeams() {
        List<Team> sortedTeams = new ArrayList<>(getTeamsInternal());

        return Collections.unmodifiableList(sortedTeams);
    }

    public void addTeam(Team team) {
        getTeamsInternal().add(team);
        team.setManager(this);

    }

    public void removeTeam(Team p) {
        getTeamsInternal().remove(p);
        p.setManager(null);

    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    protected void setPlayersInternal(List<Players> players) {
        this.players = players;
    }

    public List<Players> getPlayers() {
        List<Players> sortedPlayers = new ArrayList<>(getPlayersInternal());

        return Collections.unmodifiableList(sortedPlayers);
    }

    public void addPlayer(Players player) {
        getPlayersInternal().add(player);
        player.setManager(this);

    }

    public void removePlayer(Players player) {
        getPlayersInternal().remove(player);
        player.setManager(null);

    }

    public Team getTeam(String name) {
        return getTeam(name, false);
    }

    public Team getTeam(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Team team : getTeamsInternal()) {
            if (!ignoreNew || !team.isNew()) {
                String compName = team.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return team;
                }
            }
        }
        return null;
    }

    public Players getPlayer(String firstname, String lastname) {
        return getPlayer(firstname, lastname, false);
    }

    public Players getPlayer(String firstname, String lastname, boolean ignoreNew) {
        firstname = firstname.toLowerCase();
        lastname = lastname.toLowerCase();
        for (Players player : getPlayersInternal()) {
            if (!ignoreNew || !player.isNew()) {
                String compFirstName = player.getFirstName();
                compFirstName = compFirstName.toLowerCase();
                String compLastName = player.getLastName();
                compLastName = compLastName.toLowerCase();
                if (compFirstName.equals(firstname)) {
                    if (compLastName.equals(lastname)) {
                        return player;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public void setTeams(List<Team> team) {
        this.team = team;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public int getYearsonContract() {
        return yearsonContract;
    }

    public String getCountry() {
        return country;
    }

    public Manager() {
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set the value of yearsonContract
     *
     * @param yearsonContract new value of yearsonContract
     */
    public void setYearsonContract(int yearsonContract) {
        this.yearsonContract = yearsonContract;
    }

    public Manager(int yearsonContract, String country, String firstName, String lastName) {
        super(firstName, lastName);
        this.yearsonContract = yearsonContract;
        this.country = country;
    }

//    public Manager(Team team, int yearsonContract, String country, String firstName, String lastName) {
//        super(firstName, lastName);
//        this.team = team;
//        this.yearsonContract = yearsonContract;
//        this.country = country;
//    }
//
//    public Manager(User user, Team team, int yearsonContract, String country, String firstName, String lastName) {
//        super(firstName, lastName);
//        this.user = user;
//        this.team = team;
//        this.yearsonContract = yearsonContract;
//        this.country = country;
//    }
    public Manager(List<Team> team, int yearsonContract, String country, List<Players> players) {
        this.team = team;
        this.yearsonContract = yearsonContract;
        this.country = country;
        this.players = players;
    }

    public Manager(User user, List<Team> team, int yearsonContract, String country, List<Players> players) {
        this.user = user;
        this.team = team;
        this.yearsonContract = yearsonContract;
        this.country = country;
        this.players = players;
    }

    public Manager(User user, List<Team> team, int yearsonContract, String country, List<Players> players, String firstName, String lastName) {
        super(firstName, lastName);
        this.user = user;
        this.team = team;
        this.yearsonContract = yearsonContract;
        this.country = country;
        this.players = players;
    }

    public Manager(User user, int yearsonContract, String country, String firstName, String lastName) {
        super(firstName, lastName);
        this.user = user;
        this.yearsonContract = yearsonContract;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Manager{" + "user=" + user + ", team=" + team + ", yearsonContract=" + yearsonContract + ", country=" + country + '}';
    }

}
