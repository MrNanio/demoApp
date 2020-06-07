package com.appv1.demo.Controller;


import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInsurance;
import com.appv1.demo.Repository.VehicleInsuranceRepository;
import com.appv1.demo.Service.VehicleInsuranceService;
import com.appv1.demo.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleInsuranceController {

    VehicleInsuranceRepository vehicleInsuranceRepository;
    VehicleInsuranceService vehicleInsuranceService;
    VehicleService vehicleService;

    @Autowired
    public VehicleInsuranceController(VehicleInsuranceRepository vehicleInsuranceRepository, VehicleInsuranceService vehicleInsuranceService, VehicleService vehicleService) {
        this.vehicleInsuranceRepository = vehicleInsuranceRepository;
        this.vehicleInsuranceService = vehicleInsuranceService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/addInsurance/{id}")
    public String showCreateVehicleInsuranceForm(@PathVariable int id, Model model){
        model.addAttribute("insurance", new VehicleInsurance());
        model.addAttribute("vehicle", vehicleService.getById(id));
        model.addAttribute("insurencetypes", vehicleInsuranceService.findInsuranceTypes());
        return "addInsurance";
    }

    @PostMapping("/addInsurance/{id}")
    public String createVehicleInsurance(@PathVariable int id, @ModelAttribute VehicleInsurance vehicleInsurance){
        vehicleInsuranceService.save(vehicleInsurance);
        return "redirect:/vehicleInsurances/{id}";
    }

    @GetMapping("/vehicleInsurances/{id}")
    public String showVehicleInsurances(@PathVariable int id, Model model){
        model.addAttribute("vehicle", vehicleService.getById(id));
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("insurances", vehicleInsuranceService.findVehicleInsurances(vehicle));
        return "vehicleInsurances";
    }

    @GetMapping("/insuranceDetails/{id}")
    public String showVehicleInsuranceDetails(@PathVariable int id, Model model){
        model.addAttribute("vehicleInsurance", vehicleInsuranceService.getById(id));
        model.addAttribute("vehicle", vehicleInsuranceService.getById(id).getVehicle());
        return "insuranceDetails";
    }
}
