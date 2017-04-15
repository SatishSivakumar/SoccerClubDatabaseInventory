/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Satish
 */
@Entity
@Table(name = "Tournaments")
@NamedQueries({
    @NamedQuery(name = "Tournaments.findAll", query = "select t from Tournaments t")
})

public class Tournaments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinTable(name = "TEAM_TOURNAMENTS", joinColumns = @JoinColumn(name = "TOURNAMENTS_ID"), inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
    private Team team;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of team
     *
     * @return the value of team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Set the value of team
     *
     * @param team new value of team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    public Tournaments() {
    }

    public Tournaments(int id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public Tournaments(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tournaments{" + "id=" + id + ", name=" + name + ", team=" + team + '}';
    }

}
