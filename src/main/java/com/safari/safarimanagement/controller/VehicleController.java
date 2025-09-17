package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.Vehicle;
import com.safari.safarimanagement.domain.VehicleStatus;
import com.safari.safarimanagement.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService service;
    public VehicleController(VehicleService service) { this.service = service; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("vehicles", service.findAll());
        model.addAttribute("statuses", VehicleStatus.values());
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/list";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Vehicle vehicle) {
        vehicle.setStatus(vehicle.getStatus() == null ? VehicleStatus.AVAILABLE : vehicle.getStatus());
        service.save(vehicle);
        return "redirect:/vehicles";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/vehicles";
    }
}
