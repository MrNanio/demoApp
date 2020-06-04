package com.appv1.demo.Repository;

import com.appv1.demo.Entity.VehicleUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleUseRepository extends JpaRepository<VehicleUse, Integer> {

}
