package com.company.shop.user.service;

import com.company.shop.user.service.domain.User;
import com.company.shop.user.service.exception.UserNotFoundException;
import com.company.shop.user.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final UserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(UserNotFoundException::new);
    }
}
