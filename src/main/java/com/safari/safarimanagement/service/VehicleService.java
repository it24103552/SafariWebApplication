package com.safari.safarimanagement.service;

import com.safari.safarimanagement.domain.Vehicle;
import com.safari.safarimanagement.domain.VehicleStatus;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<Vehicle> findAll();
    List<Vehicle> findByStatus(VehicleStatus status);
    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);
    void deleteById(Long id);
}