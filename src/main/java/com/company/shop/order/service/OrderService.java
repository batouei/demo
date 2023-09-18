package com.company.shop.order.service;

import com.company.shop.order.service.model.OrderRegistration;

public interface OrderService {
    void createOrUpdateOrder(OrderRegistration orderRegistration);
}
