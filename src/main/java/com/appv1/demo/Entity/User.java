package com.appv1.demo.Entity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(nullable = false)
    private java.time.LocalDateTime createdAt;

    @Column(length = 1)//, nullable = false
    private String userLevel;

    @ManyToOne
    @JoinColumn(name = "UserStatusFk", nullable = false)
    private UserStatus userStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdManagerFk")
    private User user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private Set<User> users = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private UserData userData;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <Company> companies = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleUse> vehicleUses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<VehicleUse> getVehicleUses() {
        return vehicleUses;
    }

    public void setVehicleUses(Set<VehicleUse> vehicleUses) {
        this.vehicleUses = vehicleUses;
    }

}
