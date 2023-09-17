package com.company.shop.user.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RequiredArgsConstructor
public class UserRegistrationDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String mobileNumber;
    private String email;
}
