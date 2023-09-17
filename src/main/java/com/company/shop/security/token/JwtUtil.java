package com.company.shop.security.token;

import com.company.shop.security.UserDetail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Getter
    @Value("${jwt.expirationMs}")
    private Long expirationMs;

    public String generateToken(UserDetail userDetail) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetail.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        var now = new Date();
        var expiration = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String token, UserDetail userDetail) {
        var username = extractUsername(token);
        return (username.equals(userDetail.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    private boolean isTokenExpired(String token) {
        var expiration = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}
