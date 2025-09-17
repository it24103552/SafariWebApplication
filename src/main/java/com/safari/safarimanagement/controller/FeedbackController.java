package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.Feedback;
import com.safari.safarimanagement.service.FeedbackService;
import com.safari.safarimanagement.service.TripService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final TripService tripService;

    public FeedbackController(FeedbackService feedbackService, TripService tripService) {
        this.feedbackService = feedbackService;
        this.tripService = tripService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAll());
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("trips", tripService.findAll());
        return "feedback/list";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Feedback feedback) {
        feedbackService.submit(feedback);
        return "redirect:/feedback";
    }
}