package com.company.shop.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Objects;

/**
 * An implementation of {@link AbstractAuthenticationToken} that is designed to encapsulate token based authentication.
 **/
public final class AuthTokenRequest extends AbstractAuthenticationToken {

    /**
     * The given authorization token.
     */
    private final String token;


    public AuthTokenRequest(String token) {
        super(null);
        this.token = token;
    }

    /**
     * We consider the given Yaghout token as the credentials.
     */
    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuthTokenRequest that = (AuthTokenRequest) o;
        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), token);
    }
}
