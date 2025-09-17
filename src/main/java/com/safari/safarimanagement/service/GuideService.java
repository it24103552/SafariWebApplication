package com.safari.safarimanagement.service;

import com.safari.safarimanagement.domain.Guide;

import java.util.List;
import java.util.Optional;

public interface GuideService {
    List<Guide> findAll();
    List<Guide> findAvailable();
    Guide save(Guide guide);
    Optional<Guide> findById(Long id);
    void deleteById(Long id);
}