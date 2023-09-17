package com.company.shop.user.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RequiredArgsConstructor
public class LoginRequestDto {

    private String username;
    private String password;
}
