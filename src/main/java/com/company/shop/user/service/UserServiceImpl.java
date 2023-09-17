package com.company.shop.user.service;

import com.company.shop.common.StringUtil;
import com.company.shop.user.service.domain.User;
import com.company.shop.user.service.domain.UserRegistration;
import com.company.shop.user.service.exception.UserNotFoundException;
import com.company.shop.user.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void register(UserRegistration userRegistration) {
        var firstName = StringUtil.normalizeCharacter(userRegistration.getFirstName());
        var lastName = StringUtil.normalizeCharacter(userRegistration.getLastName());
        var encryptedPassword = passwordEncoder.encode(userRegistration.getPassword());

        var user = new User(
                firstName,
                lastName,
                userRegistration.getUsername(),
                encryptedPassword,
                userRegistration.getEmail(),
                userRegistration.getMobileNumber());

        userRepository.save(user);
    }
}
