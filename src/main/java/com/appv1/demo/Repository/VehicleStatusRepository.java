package com.appv1.demo.Repository;

import com.appv1.demo.Entity.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

    VehicleStatus findVehicleStatusByIdVehicleStatus(Integer id_vehicle_status);
}
