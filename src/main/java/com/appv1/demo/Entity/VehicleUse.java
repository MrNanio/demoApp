package com.appv1.demo.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class VehicleUse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehicleUse;

    @Column(length = 6, nullable = false)
    private String mileage;

    @Column(length = 255)
    private String description;

    @Column(precision=4, scale=2,nullable = false)
    private BigDecimal fuelPrice;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate mileageDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate addedAt;

    @ManyToOne
    @JoinColumn(name = "VehicleFk", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "UserFk", nullable = false)
    private User user;

    public Integer getIdVehicleUse() {
        return idVehicleUse;
    }

    public void setIdVehicleUse(Integer idVehicleUse) {
        this.idVehicleUse = idVehicleUse;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(BigDecimal fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public LocalDate getMileageDate() {
        return mileageDate;
    }

    public void setMileageDate(LocalDate mileageDate) {
        this.mileageDate = mileageDate;
    }

    public LocalDate getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDate addedAt) {
        this.addedAt = addedAt;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
