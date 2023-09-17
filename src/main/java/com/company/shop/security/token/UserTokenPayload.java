package com.company.shop.security.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

@Getter
@RequiredArgsConstructor
public class UserTokenPayload {
    private final Long userId;
    private final String username;
    private final Duration expiration;
}
