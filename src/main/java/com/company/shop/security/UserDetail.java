package com.company.shop.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDetail {
    private final Long userId;
    private final String username;
}
