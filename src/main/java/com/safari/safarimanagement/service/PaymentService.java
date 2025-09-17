package com.safari.safarimanagement.service;

import com.safari.safarimanagement.domain.Payment;
import com.safari.safarimanagement.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAll();
    List<Payment> findByStatus(PaymentStatus status);
    Payment recordPayment(Long bookingId, BigDecimal amount);
    Payment updateStatus(Long paymentId, PaymentStatus status);
    Optional<Payment> findById(Long id);
    void deleteById(Long id);
}