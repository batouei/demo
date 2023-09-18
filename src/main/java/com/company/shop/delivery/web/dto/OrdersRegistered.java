package com.company.shop.delivery.web.dto;

import com.company.shop.order.web.dto.OrderRegistrationDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(staticName = "of")
public final class OrdersRegistered {
  private final List<OrderRegistrationDto> orders;
}
