package com.appv1.demo.Service;

import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleRepair;
import com.appv1.demo.Repository.VehicleRepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class VehicleRepairService {

    private VehicleRepairRepository vehicleRepairRepository;

    @Autowired
    public VehicleRepairService(VehicleRepairRepository vehicleRepairRepository) {
        this.vehicleRepairRepository = vehicleRepairRepository;
    }

    @PostAuthorize("returnObject.vehicle.user.email == authentication.name")
    public VehicleRepair getById(int id){
        return vehicleRepairRepository.findVehicleRepairByIdVehicleRepair(id);
    }

    public void save(VehicleRepair vehicleRepair){
        vehicleRepairRepository.save(vehicleRepair);
    }

    public List <VehicleRepair> findVehicleRepairs(Vehicle vehicle){
        return vehicleRepairRepository.findVehicleRepairByVehicleFK(vehicle);
    }

    public List <VehicleRepair> findVehicleRepairs(List <Vehicle> vehicles){
        List <VehicleRepair> vehicleRepairs = new LinkedList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleRepairs.addAll(vehicle.getVehicleRepairs());
        }
        return vehicleRepairs;
    }
}
