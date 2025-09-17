package com.safari.safarimanagement.controller;

import com.safari.safarimanagement.domain.Guide;
import com.safari.safarimanagement.service.GuideService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guides")
public class GuideController {
    private final GuideService service;
    public GuideController(GuideService service) { this.service = service; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("guides", service.findAll());
        model.addAttribute("guide", new Guide());
        return "guides/list";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Guide guide) {
        service.save(guide);
        return "redirect:/guides";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/guides";
    }
}