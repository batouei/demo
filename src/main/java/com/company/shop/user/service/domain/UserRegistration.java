package com.company.shop.user.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public final class UserRegistration {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String mobileNumber;
    private final String email;


}
