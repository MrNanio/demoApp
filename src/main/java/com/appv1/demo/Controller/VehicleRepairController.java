package com.appv1.demo.Controller;

import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.Vehicle;
import com.appv1.demo.Entity.VehicleRepair;
import com.appv1.demo.Service.UserService;
import com.appv1.demo.Service.VehicleRepairService;
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
public class VehicleRepairController {

    VehicleRepairService vehicleRepairService;
    VehicleService vehicleService;
    UserService userService;

    @Autowired
    public VehicleRepairController(VehicleRepairService vehicleRepairService, VehicleService vehicleService, UserService userService) {
        this.vehicleRepairService = vehicleRepairService;
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @GetMapping("/addRepair/{id}")
    public String showCreateVehicleRepairForm(@PathVariable int id, Model model){
        model.addAttribute("vehicleRepair", new VehicleRepair());
        model.addAttribute("vehicle", vehicleService.getById(id));
        return "addRepair";
    }

    @PostMapping("/addRepair/{id}")
    public String createVehicleRepair(@PathVariable int id, @ModelAttribute VehicleRepair vehicleRepair){
        vehicleRepairService.save(vehicleRepair);
        return "redirect:/vehicleRepairs/{id}";
    }

    @GetMapping("/vehicleRepairs/{id}")
    public String showVehicleRepairs(@PathVariable int id, Model model){
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("repairs", vehicleRepairService.findVehicleRepairs(vehicle));
        return "vehicleRepairs";
    }

    @GetMapping("/repairDetails/{id}")
    public String showVehicleRepairDetails(@PathVariable int id, Model model){
        model.addAttribute("vehicleRepair", vehicleRepairService.getById(id));
        model.addAttribute("vehicle", vehicleRepairService.getById(id).getVehicle());
        return "repairDetails";
    }

    @GetMapping("/repairEdit/{id}")
    public String showUpdateVehicleRepairForm(@PathVariable("id") int id, Model model){
        model.addAttribute("vehicleRepair", vehicleRepairService.getById(id));
        model.addAttribute("vehicle", vehicleRepairService.getById(id).getVehicle());
        return "editRepair";
    }

    @PostMapping("/updateVehicleRepair/{id}")
    public String updateRepair(@PathVariable("id") int id, @Valid VehicleRepair vehicleRepair,
                               BindingResult result, Model model){
        if (result.hasErrors()) {
            vehicleRepair.setIdVehicleRepair(id);
            return "editRepair";
        }

        vehicleRepair.setIdVehicleRepair(id);
        vehicleRepairService.save(vehicleRepair);

        model.addAttribute("vehicleRepair", vehicleRepairService.getById(id));
        model.addAttribute("vehicle", vehicleRepairService.getById(id).getVehicle());

        return "redirect:/repairDetails/{id}";
    }

    @GetMapping("/allVehicleRepairs")
    public String showAllVehicleRepairs(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        List<Vehicle> vehicles = vehicleService.findMyVehicles(user);
        model.addAttribute("repairs", vehicleRepairService.findVehicleRepairs(vehicles));
        return "allVehicleRepairs";
    }

    @GetMapping("/addRepairWithVehicleChoice")
    public String showCreateVehicleRepairChoiceForm(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("vehicleRepair", new VehicleRepair());
        model.addAttribute("vehicles", vehicleService.findMyVehicles(user));
        return "addRepairWithVehicleChoice";
    }

    @PostMapping("/addRepairWithVehicleChoice")
    public String createVehicleRepairAfterVehicleChoice(@ModelAttribute VehicleRepair vehicleRepair){
        vehicleRepairService.save(vehicleRepair);
        return "redirect:/allVehicleRepairs";
    }
}
