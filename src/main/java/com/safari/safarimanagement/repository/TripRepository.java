package com.safari.safarimanagement.repository;

import com.safari.safarimanagement.domain.Trip;
import com.safari.safarimanagement.domain.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStatus(TripStatus status);
    List<Trip> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}