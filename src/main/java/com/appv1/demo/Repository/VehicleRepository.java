package com.appv1.demo.Repository;


import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle findVehicleByIdVehicle(Integer id_vehicle);

    @Query("select v from Vehicle v where v.user = ?1")
    List<Vehicle> findVehicleByUserFK(User user);

}
