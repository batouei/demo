package com.company.shop.delivery.repository;

import com.company.shop.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Order, Long> {
}
