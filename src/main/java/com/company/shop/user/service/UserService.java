package com.company.shop.user.service;

import com.company.shop.user.service.domain.User;

public interface UserService {
    User findByUsername(String username);
}
