package com.appv1.demo.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class VehicleRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVehicleRepair;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repairDate;

    @Column(length = 555, nullable = false)
    private String description;

    @Column(precision=8, scale=2, nullable = false)
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "VehicleFk", nullable = false)
    private Vehicle vehicle;

    public Integer getIdVehicleRepair() {
        return idVehicleRepair;
    }

    public void setIdVehicleRepair(Integer idVehicleRepair) {
        this.idVehicleRepair = idVehicleRepair;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
