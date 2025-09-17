package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.Booking;
import com.safari.safarimanagement.domain.BookingStatus;
import com.safari.safarimanagement.service.BookingService;
import com.safari.safarimanagement.service.TripService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final TripService tripService;

    public BookingController(BookingService bookingService, TripService tripService) {
        this.bookingService = bookingService;
        this.tripService = tripService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        model.addAttribute("booking", new Booking());
        model.addAttribute("trips", tripService.findAll());
        model.addAttribute("statuses", BookingStatus.values());
        return "bookings/list";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Booking booking) {
        bookingService.createBooking(booking);
        return "redirect:/bookings";
    }

    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam BookingStatus status) {
        bookingService.updateStatus(id, status);
        return "redirect:/bookings";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        bookingService.deleteById(id);
        return "redirect:/bookings";
    }
}