package com.company.shop.security;

import com.company.shop.security.token.UserTokenPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
final class JwtTokenAuthProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) {
        var authRequest = (AuthTokenRequest) authentication;

        try {
            var payload = verify(authRequest.getCredentials().toString());

            return new AuthUser(null, payload.getUserId());

        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage(), e);
        }
    }

    private UserTokenPayload verify(String string) {
        // todo verify token
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == AuthTokenRequest.class;
    }
}