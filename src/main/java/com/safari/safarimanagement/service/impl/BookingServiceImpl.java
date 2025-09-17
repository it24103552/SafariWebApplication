package com.safari.safarimanagement.service.impl;

import com.safari.safarimanagement.domain.*;
import com.safari.safarimanagement.repository.BookingRepository;
import com.safari.safarimanagement.repository.TripRepository;
import com.safari.safarimanagement.service.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepo;
    private final TripRepository tripRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, TripRepository tripRepo) {
        this.bookingRepo = bookingRepo;
        this.tripRepo = tripRepo;
    }

    public List<Booking> findAll() { return bookingRepo.findAll(); }
    public List<Booking> findByStatus(BookingStatus status) { return bookingRepo.findByStatus(status); }

    @Transactional
    public Booking createBooking(Booking booking) {
        Trip trip = tripRepo.findById(booking.getTrip().getId()).orElseThrow();
        int requested = booking.getNumAdults() + booking.getNumChildren();
        long booked = bookingRepo.findAll().stream()
                .filter(b -> b.getTrip().getId().equals(trip.getId()))
                .filter(b -> b.getStatus() != BookingStatus.CANCELLED)
                .mapToInt(b -> b.getNumAdults() + b.getNumChildren()).sum();
        int capacity = trip.getVehicle() != null ? trip.getVehicle().getCapacity() : Integer.MAX_VALUE;
        if (booked + requested > capacity) throw new IllegalStateException("Capacity exceeded");
        booking.setStatus(BookingStatus.PENDING);
        return bookingRepo.save(booking);
    }

    @Transactional
    public Booking updateStatus(Long bookingId, BookingStatus status) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        b.setStatus(status);
        return bookingRepo.save(b);
    }

    public Optional<Booking> findById(Long id) { return bookingRepo.findById(id); }
    public void deleteById(Long id) { bookingRepo.deleteById(id); }
}