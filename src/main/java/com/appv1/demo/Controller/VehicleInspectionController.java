package com.appv1.demo.Controller;

import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInspection;
import com.appv1.demo.Repository.VehicleInspectionRepository;
import com.appv1.demo.Repository.VehicleRepository;
import com.appv1.demo.Service.VehicleInspectionService;
import com.appv1.demo.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleInspectionController {

    VehicleInspectionRepository vehicleInspectionRepository;
    VehicleInspectionService vehicleInspectionService;
    VehicleService vehicleService;

    @Autowired
    public VehicleInspectionController(VehicleInspectionRepository vehicleInspectionRepository, VehicleInspectionService vehicleInspectionService, VehicleService vehicleService) {
        this.vehicleInspectionRepository = vehicleInspectionRepository;
        this.vehicleInspectionService = vehicleInspectionService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/addInspection/{id}")
    public String showCreateVehicleInspectionForm(@PathVariable int id, Model model){
        model.addAttribute("inspection", new VehicleInspection());
        model.addAttribute("vehicle", vehicleService.getById(id));
        return "addInspection";
    }

    @PostMapping("/addInspection/{id}")
    public String createVehicleInspection(@PathVariable int id, @ModelAttribute VehicleInspection vehicleInspection){
        vehicleInspectionService.save(vehicleInspection);
        return "redirect:/vehicleInspections/{id}";
    }

    @GetMapping("/vehicleInspections/{id}")
    public String showVehicleInspections(@PathVariable int id, Model model){
        model.addAttribute("vehicle", vehicleService.getById(id));
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("inspections", vehicleInspectionService.findVehicleInspections(vehicle));
        return "vehicleInspections";
    }

    @GetMapping("/inspectionDetails/{id}")
    public String showVehicleInspectionDetails(@PathVariable int id, Model model){
        model.addAttribute("vehicleInspection", vehicleInspectionService.getById(id));
        model.addAttribute("vehicle", vehicleInspectionService.getById(id).getVehicle());
        return "inspectionDetails";
    }
}
