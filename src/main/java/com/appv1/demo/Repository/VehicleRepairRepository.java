package com.appv1.demo.Repository;

import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepairRepository extends JpaRepository<VehicleRepair, Integer> {

    VehicleRepair findVehicleRepairByIdVehicleRepair(Integer id_vehicle_repair);

    @Query("select vr from VehicleRepair vr where vr.vehicle = ?1")
    List <VehicleRepair> findVehicleRepairByVehicleFK(Vehicle vehicle);
}
