package com.safari.safarimanagement.service.impl;

import com.safari.safarimanagement.domain.Vehicle;
import com.safari.safarimanagement.domain.VehicleStatus;
import com.safari.safarimanagement.repository.VehicleRepository;
import com.safari.safarimanagement.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repo;
    public VehicleServiceImpl(VehicleRepository repo) { this.repo = repo; }
    public List<Vehicle> findAll() { return repo.findAll(); }
    public List<Vehicle> findByStatus(VehicleStatus status) { return repo.findByStatus(status); }
    public Vehicle save(Vehicle v) { return repo.save(v); }
    public Optional<Vehicle> findById(Long id) { return repo.findById(id); }
    public void deleteById(Long id) { repo.deleteById(id); }
}