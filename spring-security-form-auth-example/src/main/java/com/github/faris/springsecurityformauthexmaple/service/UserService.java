package com.github.faris.springsecurityformauthexmaple.service;

import com.github.faris.springsecurityformauthexmaple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.github.faris.springsecurityformauthexmaple.config.UserRole.*;

@Service
public class UserService implements UserDetailsService {

    private final List<User> USERS = new ArrayList<>();

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        USERS.addAll(List.of(
                new User(
                        1L,
                        "Rachel.Shi",
                        passwordEncoder.encode("123456"),
                        List.of(ADMIN),
                        true),
                new User(
                        1L,
                        "Yang.Hai",
                        passwordEncoder.encode("123456"),
                        List.of(ADMIN_TRAINEE),
                        true),
                new User(
                        1L,
                        "Faris.Shi",
                        passwordEncoder.encode("123456"),
                        List.of(STUDENT),
                        true)
        ));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException(String.format("user %s not found", username)));
    }


}
