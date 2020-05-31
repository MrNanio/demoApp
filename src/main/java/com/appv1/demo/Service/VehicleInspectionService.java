package com.appv1.demo.Service;

import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInspection;
import com.appv1.demo.Repository.VehicleInspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleInspectionService {

    private VehicleInspectionRepository vehicleInspectionRepository;

    @Autowired
    public VehicleInspectionService(VehicleInspectionRepository vehicleInspectionRepository) {
        this.vehicleInspectionRepository = vehicleInspectionRepository;
    }

    public VehicleInspection getById(int id){
        return vehicleInspectionRepository.findVehicleInspectionByIdVehicleInspection(id);
    }

    public VehicleInspection save(VehicleInspection vehicleInspection){

        return vehicleInspectionRepository.save(vehicleInspection);
    }

    public List <VehicleInspection> findVehicleInspections(Vehicle vehicle){
        return vehicleInspectionRepository.findVehicleInspectionByVehicleFK(vehicle);
    }

}
