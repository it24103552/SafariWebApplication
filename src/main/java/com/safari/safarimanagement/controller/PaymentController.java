package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.PaymentStatus;
import com.safari.safarimanagement.service.BookingService;
import com.safari.safarimanagement.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    private final BookingService bookingService;

    public PaymentController(PaymentService paymentService, BookingService bookingService) {
        this.paymentService = paymentService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("payments", paymentService.findAll());
        model.addAttribute("bookings", bookingService.findAll());
        return "payments/list";
    }

    @PostMapping
    public String create(@RequestParam Long bookingId, @RequestParam BigDecimal amount) {
        paymentService.recordPayment(bookingId, amount);
        return "redirect:/payments";
    }

    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam PaymentStatus status) {
        paymentService.updateStatus(id, status);
        return "redirect:/payments";
    }
}