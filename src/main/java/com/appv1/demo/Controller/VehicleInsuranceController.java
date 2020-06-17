package com.appv1.demo.Controller;


import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleInsurance;
import com.appv1.demo.Service.UserService;
import com.appv1.demo.Service.VehicleInsuranceService;
import com.appv1.demo.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleInsuranceController {

    VehicleInsuranceService vehicleInsuranceService;
    VehicleService vehicleService;
    UserService userService;

    @Autowired
    public VehicleInsuranceController(VehicleInsuranceService vehicleInsuranceService, VehicleService vehicleService, UserService userService) {
        this.vehicleInsuranceService = vehicleInsuranceService;
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @GetMapping("/addInsurance/{id}")
    public String showCreateVehicleInsuranceForm(@PathVariable int id, Model model){
        model.addAttribute("vehicleInsurance", new VehicleInsurance());
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
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("insurances", vehicleInsuranceService.findVehicleInsurances(vehicle));
        return "vehicleInsurances";
    }

    @GetMapping("/insuranceDetails/{id}")
    public String showVehicleInsuranceDetails(@PathVariable int id, Model model){
        model.addAttribute("vehicleInsurance", vehicleInsuranceService.getById(id));
        model.addAttribute("vehicle", vehicleInsuranceService.getById(id).getVehicle());
        return "insuranceDetails";
    }

    @GetMapping("/insuranceEdit/{id}")
    public String showUpdateVehicleInsuranceForm(@PathVariable("id") int id, Model model){
        model.addAttribute("vehicleInsurance", vehicleInsuranceService.getById(id));
        model.addAttribute("insurencetypes", vehicleInsuranceService.findInsuranceTypes());
        model.addAttribute("vehicle", vehicleInsuranceService.getById(id).getVehicle());

        return "editInsurance";
    }

    @PostMapping("/updateVehicleInsurance/{id}")
    public String updateInsurance(@PathVariable("id") int id, @Valid VehicleInsurance vehicleInsurance,
                                  BindingResult result, Model model){
        if (result.hasErrors()) {
            vehicleInsurance.setIdVehicleInsurance(id);
            return "editInsurance";
        }

        vehicleInsurance.setIdVehicleInsurance(id);
        vehicleInsuranceService.save(vehicleInsurance);

        model.addAttribute("vehicleInsurance", vehicleInsuranceService.getById(id));
        model.addAttribute("vehicle", vehicleInsuranceService.getById(id).getVehicle());

        return "redirect:/insuranceDetails/{id}";
    }

    @GetMapping("/allVehicleInsurances")
    public String showAllVehicleInsurances(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        List<Vehicle> vehicles = vehicleService.findMyVehicles(user);
        model.addAttribute("insurances", vehicleInsuranceService.findVehicleInsurances(vehicles));
        return "allVehicleInsurances";
    }

    @GetMapping("/addInsuranceWithVehicleChoice")
    public String showCreateVehicleInsuranceChoiceForm(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("vehicleInsurance", new VehicleInsurance());
        model.addAttribute("vehicles", vehicleService.findMyVehicles(user));
        model.addAttribute("insurencetypes", vehicleInsuranceService.findInsuranceTypes());
        return "addInsuranceWithVehicleChoice";
    }

    @PostMapping("/addInsuranceWithVehicleChoice")
    public String createVehicleInsuranceAfterVehicleChoice(@ModelAttribute VehicleInsurance vehicleInsurance){
        vehicleInsuranceService.save(vehicleInsurance);
        return "redirect:/allVehicleInsurances";
    }
}
