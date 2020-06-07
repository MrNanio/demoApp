package com.appv1.demo.Repository;

import com.appv1.demo.Entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Integer> {

   /* @Query("select it from InsuranceType it")
    List <InsuranceType> findInsuranceTypes();*/
}
