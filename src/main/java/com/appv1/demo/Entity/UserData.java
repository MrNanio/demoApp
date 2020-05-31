package com.appv1.demo.Entity;

import javax.persistence.*;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUserData;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 45, nullable = false)
    private String surname;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "UserFk", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "AddressFk", nullable = false)
    private Address address;

    public Integer getIdUserData() {
        return idUserData;
    }

    public void setIdUserData(Integer idUserData) {
        this.idUserData = idUserData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
