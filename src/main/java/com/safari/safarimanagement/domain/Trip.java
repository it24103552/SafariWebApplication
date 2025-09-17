package com.safari.safarimanagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Guide guide;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TripStatus status; // SCHEDULED, ONGOING, COMPLETED, CANCELLED
}