package com.appv1.demo.Repository;

import com.appv1.demo.Entity.VehicleInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInsuranceRepository extends JpaRepository<VehicleInsurance, Integer> {

}
