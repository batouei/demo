package com.company.shop.security;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;

import static lombok.AccessLevel.PACKAGE;

/**
 * Simple implementation of {@link Authentication} to encapsulates the authenticated user details.
 **/
@Getter
@RequiredArgsConstructor(access = PACKAGE)
public final class AuthUser implements Authentication {

    /**
     * Represents the user authorities.
     */
    private final Set<GrantedAuthority> authorities;

    /**
     * Determines the token has been authenticated.
     */
    private boolean authenticated = true;

    /**
     * Represents the user auto increment identifier in our oracle database.
     */
    private final Long userId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return new UserDetail(userId.toString());
    }

    @Override
    public Object getPrincipal() {
        return this;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}
