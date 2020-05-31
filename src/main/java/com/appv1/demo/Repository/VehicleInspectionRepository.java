package com.appv1.demo.Repository;

import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleInspectionRepository extends JpaRepository<VehicleInspection, Integer> {

    VehicleInspection findVehicleInspectionByIdVehicleInspection(Integer id_vehicle_inspection);

    @Query("select vi from VehicleInspection vi where vi.vehicle = ?1")
    List<VehicleInspection> findVehicleInspectionByVehicleFK(Vehicle vehicle);
}
