package com.appv1.demo.Controller;

import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Repository.VehicleMakeRepository;
import com.appv1.demo.Repository.VehicleRepository;
import com.appv1.demo.Service.UserService;
import com.appv1.demo.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class VehicleController {

    VehicleService vehicleService;
    UserService userService;
    VehicleMakeRepository vehicleMakeRepository;
    VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleService vehicleService, UserService userService, VehicleMakeRepository vehicleMakeRepository, VehicleRepository vehicleRepository) {
        this.vehicleService = vehicleService;
        this.userService = userService;
        this.vehicleMakeRepository = vehicleMakeRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/addVehicle")
    public String showCreateVehicleForm(Model model){
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("vehiclemakes", vehicleMakeRepository.findAll());
        return "addVehicle";
    }

    @PostMapping("/addVehicle")
    public String createVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @GetMapping("/vehicle")
    public String showAllMyVehicle(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("vehicles", vehicleService.findMyVehicle(user));
        return "vehicle";
    }

    @GetMapping("/vehicleDetails/{id}")
    public String showVehicleDetails(@PathVariable int id, Model model){
        model.addAttribute("makeVehicle",vehicleService.getById(id).getVehicleMake());
        model.addAttribute("vehicle",vehicleService.getById(id));
        return "vehicleDetails";
    }

    @GetMapping("/vehicleEdit/{id}")
    public String showUpdateVehicleForm(@PathVariable("id") int id, Model model) {
       Vehicle vehicle=vehicleRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("vehicle", vehicle);
        return "editVehicle";
    }

    @PostMapping("/update/{id}")
    public String updateVehicle(@PathVariable("id") int id, @Valid Vehicle vehicle,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            vehicle.setIdVehicle(id);
            return "editVehicle";
        }
        vehicleRepository.save(vehicle);
        Vehicle vehicle_show = vehicleService.getById(id);
        model.addAttribute("makeVehicle",vehicle_show.getVehicleMake());
        model.addAttribute("vehicle",vehicle_show);
        return "vehicleDetails";
    }
}