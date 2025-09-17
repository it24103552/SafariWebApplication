package com.safari.safarimanagement.repository;

import com.safari.safarimanagement.domain.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findByAvailableTrue();
}