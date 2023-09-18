package com.company.shop.order.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RequiredArgsConstructor(staticName = "of")
public class OrderRegistrationDto {
    private final Long id;
    private final Long count;
    private final Long productId;
}
