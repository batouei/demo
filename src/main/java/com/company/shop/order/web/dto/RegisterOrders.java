package com.company.shop.order.web.dto;

import com.company.shop.order.service.model.OrderRegistration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(staticName = "of")
public final class RegisterOrders {
  List<OrderRegistrationDto> orders;
}
