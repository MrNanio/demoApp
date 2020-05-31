package com.appv1.demo.Service;

import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleMake;
import com.appv1.demo.Entity.VehicleStatus;
import com.appv1.demo.Repository.VehicleMakeRepository;
import com.appv1.demo.Repository.VehicleRepository;
import com.appv1.demo.Repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    private VehicleStatusRepository vehicleStatusRepository;
    private UserService userService;
    private VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleStatusRepository vehicleStatusRepository, UserService userService, VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleStatusRepository = vehicleStatusRepository;
        this.userService = userService;
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    public List<Vehicle>findMyVehicle(User user){
        return vehicleRepository.findVehicleByUserFK(user);
    }

    public Vehicle getById(int id) {
        return vehicleRepository.findVehicleByIdVehicle(id);
    }


    public Vehicle save(Vehicle vehicle){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        VehicleStatus vehicleStatus= vehicleStatusRepository.findVehicleStatusByIdVehicleStatus(1);
        vehicle.setUser(user);
        vehicle.setVehicleStatus(vehicleStatus);
        return vehicleRepository.save(vehicle);
    }
}
