package com.company.shop.user.service;

import com.company.shop.user.service.domain.User;
import com.company.shop.user.service.domain.UserRegistration;
import com.company.shop.user.service.exception.UserNotFoundException;
import com.company.shop.user.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void register(UserRegistration userRegistration) {

    }
}
