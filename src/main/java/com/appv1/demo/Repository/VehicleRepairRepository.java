package com.appv1.demo.Repository;

import com.appv1.demo.Entity.VehicleRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepairRepository extends JpaRepository<VehicleRepair, Integer> {

}
