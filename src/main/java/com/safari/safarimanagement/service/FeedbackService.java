package com.safari.safarimanagement.service;

import com.safari.safarimanagement.domain.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> findAll();
    Feedback submit(Feedback feedback);
}
