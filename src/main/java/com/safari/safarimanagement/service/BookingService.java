package com.safari.safarimanagement.service;

import com.safari.safarimanagement.domain.Booking;
import com.safari.safarimanagement.domain.BookingStatus;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAll();
    List<Booking> findByStatus(BookingStatus status);
    Booking createBooking(Booking booking);
    Booking updateStatus(Long bookingId, BookingStatus status);
    Optional<Booking> findById(Long id);
    void deleteById(Long id);
}
