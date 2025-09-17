package com.safari.safarimanagement.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Trip trip;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private Integer rating; // 1-5

    @Column(length = 2000)
    private String comments;
}