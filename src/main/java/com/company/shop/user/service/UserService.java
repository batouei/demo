package com.company.shop.user.service;

import com.company.shop.user.service.domain.User;
import com.company.shop.user.service.domain.UserRegistration;

public interface UserService {
    User findByUsername(String username);

    void register(UserRegistration userRegistration);
}
