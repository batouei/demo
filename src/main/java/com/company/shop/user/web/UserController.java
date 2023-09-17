package com.company.shop.user.web;

import com.company.shop.common.UrlMapping;
import com.company.shop.security.UserDetail;
import com.company.shop.security.token.JwtUtil;
import com.company.shop.user.service.UserService;
import com.company.shop.user.service.domain.UserRegistration;
import com.company.shop.user.web.dto.LoginRequestDto;
import com.company.shop.user.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping(UrlMapping.USER_LOGIN)
    public void login(LoginRequestDto loginRequestDto) throws UnAuthorizedUserException {
        var user = userService.findByUsername(loginRequestDto.getUsername());
        var passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            var userDetail = new UserDetail(user.getId(), user.getUsername());
            jwtUtil.generateToken(userDetail);
        } else {
            throw new UnAuthorizedUserException();
        }
    }


    @PostMapping(UrlMapping.USER_REGISTER)
    public void register(UserRegistrationDto userRegistrationDto) {
        var userRegistration = UserRegistration.of(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getUsername(), userRegistrationDto.getPassword(),
                userRegistrationDto.getMobileNumber(), userRegistrationDto.getEmail());
        userService.register(userRegistration);

    }
}
