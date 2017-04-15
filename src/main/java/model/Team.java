/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Satish
 */
@Entity
@Table(name = "Team")
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "select t from Team t"),
    @NamedQuery(name = "Team.findParam", query = "select t1 from Team t1 where t1.name = :name"),
    @NamedQuery(name = "Team.FindU21", query = "select t2 from Team t2 where t2.name = 'U21 Team'")
})
public class Team extends BaseEntity {

    @OneToMany(mappedBy = "Team", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Players> players = new ArrayList<>();

    @OneToMany(mappedBy = "Team", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Tournaments> tournaments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne
    @JoinColumn(name = "SCOUT_ID_FK")
    private Scout scout;

    public List<Players> getPlayers() {
        return players;
    }

    /**
     * Get the value of tournaments
     *
     * @return the value of tournaments
     */
    public List<Tournaments> getTournaments() {
        return tournaments;
    }

    /**
     * Set the value of tournaments
     *
     * @param tournaments new value of tournaments
     */
    public void setTournaments(List<Tournaments> tournaments) {
        this.tournaments = tournaments;
    }

    /**
     * Set the value of players
     *
     * @param players new value of players
     */
    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public void addPlayers(Players p) {
        if (!this.players.contains(p)) {
            this.players.add(p);
        }
        if (p.getTeam() != this) {
            p.setTeam(this);
        }
    }

    public void addTournaments(Tournaments t) {
        if (!this.tournaments.contains(t)) {
            this.tournaments.add(t);
        }
        if (t.getTeam() != this) {
            t.setTeam(this);
        }
    }

    /**
     * Get the value of scout
     *
     * @return the value of scout
     */
    public Scout getScout() {
        return scout;
    }

    /**
     * Set the value of scout
     *
     * @param scout new value of scout
     */
    public void setScout(Scout scout) {
        this.scout = scout;
    }

    public Team(Scout scout, String name) {
        super(name);
        this.scout = scout;
    }

    public Team(Scout scout) {
        this.scout = scout;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Team() {
    }

    public Team(String name) {
        super(name);
    }

    public Team(String name, Manager manager) {
        super(name);
        this.manager = manager;
    }

    public Team(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Team{" + "players=" + players + ", tournaments=" + tournaments + ", manager=" + manager + ", scout=" + scout + '}';
    }

}
