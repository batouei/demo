package com.company.shop.product.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    void createdAt() {
        this.createdAt =  LocalDateTime.now();
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt =  LocalDateTime.now();
    }
}
