package com.accelex.sample.exercise.web;

import com.accelex.sample.exercise.controller.CustomerController;
import com.accelex.sample.exercise.controller.RentalController;
import com.accelex.sample.exercise.controller.VehicleController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class WebController {

    private final CustomerController customerController;
    private final VehicleController vehicleController;
    private final RentalController rentalController;

    @GetMapping("/customers")
    public String allCustomers(Model model){
        model.addAttribute("customers",customerController.getAll().getBody());
        return "customers";
    }

    @GetMapping("/create-customer")
    public String getCustomerForm(){
        return "customer-form";
    }

    @GetMapping("/vehicles")
    public String allVehicles(Model model){
        model.addAttribute("vehicles",vehicleController.getAll().getBody());
        return "vehicles";
    }

    @GetMapping("/create-vehicle")
    public String getVehicleForm(){
        return "vehicle-form";
    }

    @GetMapping("/create-rental-request")
    public String getRentalRequestForm(){
        return "rental-request-form";
    }

    @GetMapping("/rental-requests")
    public String getRentalRequests(Model model){
        model.addAttribute("rentalRequests",rentalController.getAllRentalRequests().getBody());
        return "rental-requests";
    }

    @GetMapping("/rented-vehicles")
    public String getRentedVehicles(Model model){
        model.addAttribute("currentRentedVehicles", vehicleController.getCurrentRentedVehicles().getBody());
        return "rented-vehicles";
    }


}
