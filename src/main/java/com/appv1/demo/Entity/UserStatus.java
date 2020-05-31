package com.appv1.demo.Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUserStatus;

    @Column(length = 15, nullable = false)
    private String statusName;

    @OneToMany(mappedBy = "userStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <User> users = new HashSet<>();

    public Integer getIdUserStatus() {
        return idUserStatus;
    }

    public void setIdUserStatus(Integer idUserStatus) {
        this.idUserStatus = idUserStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
