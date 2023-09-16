package com.company.shop.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.util.Collections;
import java.util.List;

/**
 * Encapsulates the security configurations properties.
 */
@Data
@Configuration
@ConfigurationProperties("security")
public class SecurityConfigProperties {

    /**
     * Represents the allowed routes for set to http security config.
     */
    private List<Route> allowedRoutes = Collections.emptyList();

    /**
     * Encapsulate the request`s route detail.
     */
    @Data
    public static class Route {
        /**
         * Represents the path pattern that want to allow. If {@code null} or empty, then matches on nothing
         */
        private String pathPattern;

        /**
         * Represents the http method to use or null for any http methods.
         */
        private HttpMethod method;
    }

}
