package com.company.shop.order.service;

import com.company.shop.order.repository.OrderRepository;
import com.company.shop.order.service.model.OrderRegistration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrUpdateOrder(OrderRegistration orderRegistration) {

    }
}
