package com.company.shop.security;

import com.company.shop.security.token.JwtUtil;
import com.company.shop.security.token.UserTokenPayload;
import com.company.shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public final class JwtTokenAuthProvider implements AuthenticationProvider {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Override
    public Authentication authenticate(Authentication authentication) {
        var authRequest = (AuthTokenRequest) authentication;
        try {
            var payload = verify(authRequest.getCredentials().toString());
            return new AuthUser(null, payload.getUserId(), payload.getUsername());

        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage(), e);
        }
    }

    private UserTokenPayload verify(String token) {
        var user = userService.findByUsername(jwtUtil.extractUsername(token));
        var userDetail = new UserDetail(user.getId(), user.getUsername());
        var validatedToken = jwtUtil.validateToken(token, userDetail);
        if (validatedToken)
            return new UserTokenPayload(user.getId(), user.getUsername(), Duration.of(jwtUtil.getExpirationMs(), ChronoUnit.MILLIS));
        throw new BadCredentialsException("Invalid credential valid!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == AuthTokenRequest.class;
    }
}