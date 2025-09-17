package com.safari.safarimanagement.repository;

import com.safari.safarimanagement.domain.Vehicle;
import com.safari.safarimanagement.domain.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByStatus(VehicleStatus status);
}