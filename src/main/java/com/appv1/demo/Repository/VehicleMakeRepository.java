package com.appv1.demo.Repository;

import com.appv1.demo.Entity.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {

    VehicleMake findVehicleMakeByIdVehicleMake(Integer id_vehicle_make);

}
