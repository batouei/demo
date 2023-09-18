package com.company.shop.order.web;

import com.company.shop.order.service.OrderService;
import com.company.shop.order.service.model.OrderRegistration;
import com.company.shop.security.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> registerOrder(@RequestBody OrderDto orderDto, AuthUser authUser) {
        var orderRegistration = OrderRegistration.of(orderDto.getCount(), orderDto.getProductId(), authUser.getUserId());
        orderService.createOrUpdateOrder(orderRegistration);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
