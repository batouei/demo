package com.company.shop.order.service;

import com.company.shop.order.domain.Order;
import com.company.shop.order.service.model.OrderRegistration;

import java.util.List;

public interface OrderService {
    void createOrUpdateOrder(OrderRegistration orderRegistration);

    void deleteOrder(String id, Long userId);

    List<Order> findRegisterOrders(Long userId);
}
