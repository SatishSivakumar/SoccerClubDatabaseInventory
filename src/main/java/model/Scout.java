/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Satish
 */
@Entity
@Table(name = "Scout")
@NamedQueries({
    @NamedQuery(name = "Scout.findAll", query = "select s from Scout s")
})

public class Scout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regionofScouting;

    private String firstname;

    private String lastname;

    @OneToOne
    //DEFAULT TO JOIN COLUMN
    @JoinTable(name = "TEAM_SCOUT",
            joinColumns = @JoinColumn(name = "SCOUT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
    private Team team;

    /**
     * Get the value of lastname
     *
     * @return the value of lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the value of lastname
     *
     * @param lastname new value of lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get the value of firstname
     *
     * @return the value of firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the value of firstname
     *
     * @param firstname new value of firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get the value of regionofScouting
     *
     * @return the value of regionofScouting
     */
    public String getRegionofScouting() {
        return regionofScouting;
    }

    /**
     * Set the value of regionofScouting
     *
     * @param regionofScouting new value of regionofScouting
     */
    public void setRegionofScouting(String regionofScouting) {
        this.regionofScouting = regionofScouting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Scout() {
    }

    public Scout(Long id, String regionofScouting, String firstname, String lastname) {
        this.id = id;
        this.regionofScouting = regionofScouting;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Scout(Long id, String regionofScouting, String firstname, String lastname, Team team) {
        this.id = id;
        this.regionofScouting = regionofScouting;
        this.firstname = firstname;
        this.lastname = lastname;
        this.team = team;
    }

    public Scout(String regionofScouting, String firstname, String lastname) {
        this.regionofScouting = regionofScouting;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Scout{" + "id=" + id + ", regionofScouting=" + regionofScouting + ", firstname=" + firstname + ", lastname=" + lastname + ", team=" + team + '}';
    }

}
