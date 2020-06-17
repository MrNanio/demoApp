package com.appv1.demo.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehicleMake;

    @Column(length = 45, nullable = false)
    private String makeName;

    @OneToMany(mappedBy = "vehicleMake", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();

    public Integer getIdVehicleMake() {
        return idVehicleMake;
    }

    public void setIdVehicleMake(Integer idVehicleMake) {
        this.idVehicleMake = idVehicleMake;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
