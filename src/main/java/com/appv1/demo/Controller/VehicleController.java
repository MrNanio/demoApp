package com.appv1.demo.Controller;

import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleMake;
import com.appv1.demo.Repository.VehicleMakeRepository;
import com.appv1.demo.Repository.VehicleRepository;
import com.appv1.demo.Service.UserService;
import com.appv1.demo.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    public VehicleController(VehicleService vehicleService, UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @GetMapping("/addVehicle")
    public String showCreateVehicleForm(Model model){
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("vehiclemakes", vehicleService.findAllVehicleMakes());
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
        model.addAttribute("makeVehicle", vehicleService.getById(id).getVehicleMake());
        model.addAttribute("vehicle", vehicleService.getById(id));
        return "vehicleDetails";
    }
    @GetMapping("/vehicleEdit/{id}")
    public String showUpdateVehicleForm(@PathVariable("id") int id, Model model) {
       Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehiclemakes", vehicleService.findAllVehicleMakes());
        model.addAttribute("vehicle", vehicle);
        return "editVehicle";
    }

    @PostMapping("/updateVehicle/{id}")
    public String updateVehicle(@PathVariable("id") int id, @Valid Vehicle vehicle,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            vehicle.setIdVehicle(id);
            return "editVehicle";
        }

        vehicle.setIdVehicle(id);
        vehicleService.save(vehicle);

        Vehicle vehicle_show = vehicleService.getById(id);
        model.addAttribute("makeVehicle", vehicle_show.getVehicleMake());
        model.addAttribute("vehicle", vehicle_show);
        return "redirect:/vehicleDetails/{id}";

    }
}
