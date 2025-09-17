package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.Trip;
import com.safari.safarimanagement.domain.TripStatus;
import com.safari.safarimanagement.service.GuideService;
import com.safari.safarimanagement.service.TripService;
import com.safari.safarimanagement.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trips")
public class  TripController {
    private final TripService tripService;
    private final VehicleService vehicleService;
    private final GuideService guideService;

    public TripController(TripService tripService, VehicleService vehicleService, GuideService guideService) {
        this.tripService = tripService;
        this.vehicleService = vehicleService;
        this.guideService = guideService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("trips", tripService.findAll());
        model.addAttribute("trip", new Trip());
        model.addAttribute("statuses", TripStatus.values());
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("guides", guideService.findAll());
        return "trips/list";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Trip trip) {
        if (trip.getStatus() == null) trip.setStatus(TripStatus.SCHEDULED);
        tripService.save(trip);
        return "redirect:/trips";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        tripService.deleteById(id);
        return "redirect:/trips";
    }
}