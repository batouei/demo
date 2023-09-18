package com.company.shop.order.web;

import com.company.shop.common.UrlMapping;
import com.company.shop.order.service.OrderService;
import com.company.shop.order.service.model.OrderRegistration;
import com.company.shop.order.web.dto.OrderRegistrationDto;
import com.company.shop.security.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * In this method user could add or remove a product with positive count or negative count
     *
     * @param authUser Come from spring context that in authentication filters put {@link com.company.shop.security.JwtTokenAuthProvider }
     */
    @PostMapping(UrlMapping.ORDERS)
    public ResponseEntity<Void> registerOrder(@RequestBody OrderRegistrationDto orderDto, AuthUser authUser) {
        var orderRegistration = OrderRegistration.of(orderDto.getCount(), orderDto.getProductId(), authUser.getUserId());
        orderService.createOrUpdateOrder(orderRegistration);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping(UrlMapping.DELETE_ORDERS)
    public ResponseEntity<Void> removeOrder(AuthUser authUser, @PathVariable String id) {
        orderService.deleteOrder(id, authUser.getUserId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping(UrlMapping.ORDERS)
    public ResponseEntity<Void> getOrders(AuthUser authUser) {
        var registerOrders = orderService.findRegisterOrders(authUser.getUserId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
