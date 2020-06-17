package com.appv1.demo.Entity;

import javax.persistence.*;

@Entity
public class CurrentVehicleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurrentVehicleUser;

    @ManyToOne
    @JoinColumn(name = "UserFk", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "VehicleFk", nullable = false, unique = true)
    private Vehicle vehicle;

    public Integer getIdCurrentVehicleUser() {
        return idCurrentVehicleUser;
    }

    public void setIdCurrentVehicleUser(Integer idCurrentVehicleUser) {
        this.idCurrentVehicleUser = idCurrentVehicleUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
