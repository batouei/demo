package com.company.shop.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Represents a order entity.
 * Note: the name of the table is ORDERS because "order" is a reserved name in the database.
 */
@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long count;
    private Product product;
    private Requset requset;
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
