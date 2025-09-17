package com.safari.safarimanagement.service.impl;

import com.safari.safarimanagement.domain.*;
import com.safari.safarimanagement.repository.BookingRepository;
import com.safari.safarimanagement.repository.PaymentRepository;
import com.safari.safarimanagement.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepo;
    private final BookingRepository bookingRepo;

    public PaymentServiceImpl(PaymentRepository paymentRepo, BookingRepository bookingRepo) {
        this.paymentRepo = paymentRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<Payment> findAll() { return paymentRepo.findAll(); }
    public List<Payment> findByStatus(PaymentStatus status) { return paymentRepo.findByStatus(status); }

    @Transactional
    public Payment recordPayment(Long bookingId, BigDecimal amount) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        Payment p = Payment.builder()
                .booking(b)
                .amount(amount)
                .status(PaymentStatus.COMPLETED)
                .createdAt(LocalDateTime.now())
                .build();
        return paymentRepo.save(p);
    }

    @Transactional
    public Payment updateStatus(Long paymentId, PaymentStatus status) {
        Payment p = paymentRepo.findById(paymentId).orElseThrow();
        p.setStatus(status);
        return paymentRepo.save(p);
    }

    public Optional<Payment> findById(Long id) { return paymentRepo.findById(id); }
    public void deleteById(Long id) { paymentRepo.deleteById(id); }
}
