package com.safari.safarimanagement.service.impl;

import com.safari.safarimanagement.domain.Trip;
import com.safari.safarimanagement.domain.TripStatus;
import com.safari.safarimanagement.repository.TripRepository;
import com.safari.safarimanagement.service.TripService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository repo;
    public TripServiceImpl(TripRepository repo) { this.repo = repo; }
    public List<Trip> findAll() { return repo.findAll(); }
    public List<Trip> findByStatus(TripStatus status) { return repo.findByStatus(status); }
    public List<Trip> findBetween(LocalDateTime start, LocalDateTime end) { return repo.findByStartTimeBetween(start, end); }
    public Trip save(Trip t) { return repo.save(t); }
    public Optional<Trip> findById(Long id) { return repo.findById(id); }
    public void deleteById(Long id) { repo.deleteById(id); }
}