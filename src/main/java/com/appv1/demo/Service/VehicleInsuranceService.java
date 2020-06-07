package com.appv1.demo.Service;

import com.appv1.demo.Entity.InsuranceType;
import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInsurance;
import com.appv1.demo.Repository.InsuranceTypeRepository;
import com.appv1.demo.Repository.VehicleInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleInsuranceService {

    private VehicleInsuranceRepository vehicleInsuranceRepository;
    private InsuranceTypeRepository insuranceTypeRepository;

    @Autowired
    public VehicleInsuranceService(VehicleInsuranceRepository vehicleInsuranceRepository, InsuranceTypeRepository insuranceTypeRepository) {
        this.vehicleInsuranceRepository = vehicleInsuranceRepository;
        this.insuranceTypeRepository = insuranceTypeRepository;
    }

    @PostAuthorize("returnObject.vehicle.user.email == authentication.name")
    public VehicleInsurance getById(int id){
        return vehicleInsuranceRepository.findVehicleInsuranceByIdVehicleInsurance(id);
    }

    public List <InsuranceType> findInsuranceTypes(){
        return insuranceTypeRepository.findAll();
    }

    public void save(VehicleInsurance vehicleInsurance){
        vehicleInsuranceRepository.save(vehicleInsurance);
    }

    public List <VehicleInsurance> findVehicleInsurances(Vehicle vehicle){
        return vehicleInsuranceRepository.findVehicleInsuranceByVehicleFK(vehicle);
    }
}
