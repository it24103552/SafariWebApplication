package com.safari.safarimanagement.repository;

import com.safari.safarimanagement.domain.Booking;
import com.safari.safarimanagement.domain.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(BookingStatus status);
}