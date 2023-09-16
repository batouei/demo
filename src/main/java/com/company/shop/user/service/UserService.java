package com.company.shop.user.service;

import com.company.shop.security.UserDetail;
import com.company.shop.user.service.domain.User;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);

    UserDetail findByUsername(String username);
}
