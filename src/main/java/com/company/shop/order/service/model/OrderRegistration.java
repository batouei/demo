package com.company.shop.order.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public final class OrderRegistration {
    private final Long id;
    private final Long count;
    private final Long productId;
    private final Long userId;
}
