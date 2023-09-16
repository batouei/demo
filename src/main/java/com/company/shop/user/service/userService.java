package com.company.shop.user.service;

import com.company.shop.user.service.domain.User;

public interface userService {
    User findByUsernameAndPassword(String username, String password);
}
