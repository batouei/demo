package com.company.shop.security.filter;

import com.company.shop.security.AuthTokenRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


public final class JwtTokenFilter extends OncePerRequestFilter {
    private static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        var token = extractBearerTokenFromHeader(request);

        token.ifPresent(t -> SecurityContextHolder.getContext().setAuthentication(new AuthTokenRequest(t)));

        chain.doFilter(request, response);
    }

    private Optional<String> extractBearerTokenFromHeader(HttpServletRequest request) {
        var authorizationToken = request.getHeader(AUTHORIZATION);
        if (authorizationToken != null && authorizationToken.startsWith(BEARER))
            return Optional.of(authorizationToken.substring(BEARER.length()));

        return Optional.empty();
    }
}