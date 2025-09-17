package com.safari.safarimanagement.service.impl;

import com.safari.safarimanagement.domain.Feedback;
import com.safari.safarimanagement.repository.FeedbackRepository;
import com.safari.safarimanagement.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository repo;
    public FeedbackServiceImpl(FeedbackRepository repo) { this.repo = repo; }
    public List<Feedback> findAll() { return repo.findAll(); }
    public Feedback submit(Feedback f) { return repo.save(f); }
}
