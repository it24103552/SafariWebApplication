package com.safari.safarimanagement.service.impl;

import com.safari.safarimanagement.domain.Guide;
import com.safari.safarimanagement.repository.GuideRepository;
import com.safari.safarimanagement.service.GuideService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideServiceImpl implements GuideService {
    private final GuideRepository repo;
    public GuideServiceImpl(GuideRepository repo) { this.repo = repo; }
    public List<Guide> findAll() { return repo.findAll(); }
    public List<Guide> findAvailable() { return repo.findByAvailableTrue(); }
    public Guide save(Guide g) { return repo.save(g); }
    public Optional<Guide> findById(Long id) { return repo.findById(id); }
    public void deleteById(Long id) { repo.deleteById(id); }
}