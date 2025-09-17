package com.safari.safarimanagement.repository;

import com.safari.safarimanagement.domain.Payment;
import com.safari.safarimanagement.domain.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatus status);
}
