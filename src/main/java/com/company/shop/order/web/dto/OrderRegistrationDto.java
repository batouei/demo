package com.company.shop.order.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OrderRegistrationDto {
    private Long id;
    private Long count;
    private Long productId;
}
