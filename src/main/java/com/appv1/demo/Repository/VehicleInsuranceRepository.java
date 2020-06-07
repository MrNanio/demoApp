package com.appv1.demo.Repository;

import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleInsuranceRepository extends JpaRepository<VehicleInsurance, Integer> {

    VehicleInsurance findVehicleInsuranceByIdVehicleInsurance(Integer id_vehicle_insurance);

    @Query("select vin from VehicleInsurance vin where vin.vehicle = ?1")
    List <VehicleInsurance> findVehicleInsuranceByVehicleFK(Vehicle vehicle);
}
