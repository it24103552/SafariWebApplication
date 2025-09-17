package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.TripStatus;
import com.safari.safarimanagement.service.BookingService;
import com.safari.safarimanagement.service.PaymentService;
import com.safari.safarimanagement.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final TripService tripService;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public DashboardController(TripService tripService, BookingService bookingService, PaymentService paymentService) {
        this.tripService = tripService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("ongoingTrips", tripService.findByStatus(TripStatus.ONGOING).size());
        model.addAttribute("scheduledTrips", tripService.findByStatus(TripStatus.SCHEDULED).size());
        model.addAttribute("bookings", bookingService.findAll().size());
        model.addAttribute("payments", paymentService.findAll().size());
        return "dashboard";
    }
}