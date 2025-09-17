package com.safari.safarimanagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String name; // ADMIN, OPERATIONS_MANAGER, RECEPTIONIST, GUIDE, VEHICLE_COORDINATOR, FINANCE
}