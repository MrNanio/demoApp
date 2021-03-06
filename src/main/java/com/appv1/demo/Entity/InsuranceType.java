package com.appv1.demo.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InsuranceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsuranceType;

    @Column(length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "insuranceType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleInsurance> vehicleInsurances = new HashSet<>();

    public Integer getIdInsuranceType() {
        return idInsuranceType;
    }

    public void setIdInsuranceType(Integer idInsuranceType) {
        this.idInsuranceType = idInsuranceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VehicleInsurance> getVehicleInsurances() {
        return vehicleInsurances;
    }

    public void setVehicleInsurances(Set<VehicleInsurance> vehicleInsurances) {
        this.vehicleInsurances = vehicleInsurances;
    }
}
