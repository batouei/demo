package com.company.shop.user.web;

import com.company.shop.common.UrlMapping;
import com.company.shop.security.token.JwtUtil;
import com.company.shop.user.service.UserService;
import com.company.shop.user.web.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class userController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping(UrlMapping.USER_LOGIN)
    public void login(LoginRequestDto loginRequestDto) {
        var user = userService.findByUsername(loginRequestDto.getUsername());
        if ()

    }
}
