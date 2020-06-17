package com.appv1.demo.Entity;

import com.appv1.demo.AdditionalClass.FuelType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehicle;

    @Column(length = 45, nullable = false)
    private String model;

    @Column(length = 4, nullable = false)
    private String year;

    @Column(length = 45, nullable = false)
    private String color;

    @Column(length = 7, nullable = false)
    private String mileage;

    @Column(length = 17, nullable = false)
    private String vinNumber;

    @Column(length = 10, nullable = false)
    private String vehicleRegistrationNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(precision=4, scale=2, nullable = false)
    private BigDecimal cityFuelConsumption;

    @Column(precision=4, scale=2, nullable = false)
    private BigDecimal countryFuelConsumption;

    @Column(precision=4, scale=2, nullable = false)
    private BigDecimal averageFuelConsumption;

    @ManyToOne
    @JoinColumn(name = "VehicleMakeFk", nullable = false)
    private VehicleMake vehicleMake;

    @ManyToOne
    @JoinColumn(name = "VehicleStatusFk", nullable = false)
    private VehicleStatus vehicleStatus;

    @ManyToOne
    @JoinColumn(name = "UserFk", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CompanyFk")
    private Company company;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleInspection> vehicleInspections = new HashSet<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleInsurance> vehicleInsurances = new HashSet<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleRepair> vehicleRepairs = new HashSet<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VehicleUse> vehicleUses = new HashSet<>();

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getCityFuelConsumption() {
        return cityFuelConsumption;
    }

    public void setCityFuelConsumption(BigDecimal cityFuelConsumption) {
        this.cityFuelConsumption = cityFuelConsumption;
    }

    public BigDecimal getCountryFuelConsumption() {
        return countryFuelConsumption;
    }

    public void setCountryFuelConsumption(BigDecimal countryFuelConsumption) {
        this.countryFuelConsumption = countryFuelConsumption;
    }

    public BigDecimal getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(BigDecimal averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<VehicleInspection> getVehicleInspections() {
        return vehicleInspections;
    }

    public void setVehicleInspections(Set<VehicleInspection> vehicleInspections) {
        this.vehicleInspections = vehicleInspections;
    }

    public Set<VehicleInsurance> getVehicleInsurances() {
        return vehicleInsurances;
    }

    public void setVehicleInsurances(Set<VehicleInsurance> vehicleInsurances) {
        this.vehicleInsurances = vehicleInsurances;
    }

    public Set<VehicleRepair> getVehicleRepairs() {
        return vehicleRepairs;
    }

    public void setVehicleRepairs(Set<VehicleRepair> vehicleRepairs) {
        this.vehicleRepairs = vehicleRepairs;
    }

    public Set<VehicleUse> getVehicleUses() {
        return vehicleUses;
    }

    public void setVehicleUses(Set<VehicleUse> vehicleUses) {
        this.vehicleUses = vehicleUses;
    }

}
