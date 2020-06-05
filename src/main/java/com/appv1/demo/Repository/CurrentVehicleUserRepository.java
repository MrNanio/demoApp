package com.appv1.demo.Repository;

import com.appv1.demo.Entity.CurrentVehicleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentVehicleUserRepository extends JpaRepository<CurrentVehicleUser, Integer> {

}
