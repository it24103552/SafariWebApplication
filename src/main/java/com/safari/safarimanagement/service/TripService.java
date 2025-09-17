package com.safari.safarimanagement.service;

import com.safari.safarimanagement.domain.Trip;
import com.safari.safarimanagement.domain.TripStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TripService {
    List<Trip> findAll();
    List<Trip> findByStatus(TripStatus status);
    List<Trip> findBetween(LocalDateTime start, LocalDateTime end);
    Trip save(Trip trip);
    Optional<Trip> findById(Long id);
    void deleteById(Long id);
}