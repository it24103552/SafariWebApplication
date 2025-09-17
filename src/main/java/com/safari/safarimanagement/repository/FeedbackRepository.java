package com.safari.safarimanagement.repository;

import com.safari.safarimanagement.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> { }