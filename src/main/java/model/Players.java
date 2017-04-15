/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.security.User;
import model.Person;

/**
 *
 * @author Satish
 */
@Entity
@Table(name = "Players")
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "select p from Players p"),
    @NamedQuery(name = "Players.findByUsername", query = "select v from Players v where v.user.userName = :userName")
})
public class Players extends Person {

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    @Column(name = "age")
    private int age;

    public User getUser() {
        return user;
    }

    @Column(name = "yearsoncontract")
    private int yearsonContract;

    @ManyToOne
    @JoinTable(name = "TEAM_PLAYERS", joinColumns = @JoinColumn(name = "PLAYER_ID"), inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
    private Team team;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the value of yearsonContract
     *
     * @return the value of yearsonContract
     */
    public int getYearsonContract() {
        return yearsonContract;
    }

    /**
     * Set the value of yearsonContract
     *
     * @param yearsonContract new value of yearsonContract
     */
    public void setYearsonContract(int yearsonContract) {
        this.yearsonContract = yearsonContract;
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
        if (!team.getPlayers().contains(this)) {
            team.getPlayers().add(this);
        }
    }

    public Players() {

    }

    public Players(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Players(User user, int age, int yearsonContract, String firstName, String lastName, Team team) {
        super(firstName, lastName);
        this.user = user;
        this.age = age;
        this.yearsonContract = yearsonContract;
        this.team = team;
    }

    public Players(int age, int yearsonContract, String firstName, String lastName) {
        super(firstName, lastName);
        this.age = age;
        this.yearsonContract = yearsonContract;
    }

    public Players(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Players{" + "team=" + this.getTeam().getName() + "age=" + age + ", First name=" + super.getFirstName() + ", Last name=" + super.getLastName() + '}';
//    }
}
