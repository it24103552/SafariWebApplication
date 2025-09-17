package com.safari.safarimanagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Guide {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String primaryLanguage;

    @ElementCollection
    private Set<String> otherLanguages;

    @Column(nullable = false)
    private boolean available;
}