package com.github.faris.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.faris.example.security.UserRole.*;
import static com.github.faris.example.security.UserRole.ADMIN_TRAINEE;

@Service
public class UserLoginService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserLoginService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAllUsers().stream()
                .filter(userDetails -> userDetails.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }

    private List<UserDetails> getAllUsers() {
        return List.of(
                User.builder()
                        .username("faris.shi")
                        .password(passwordEncoder.encode("Rachel!@#1234"))
                        .roles(STUDENT.name())
                        .authorities(STUDENT.getGrantedAuthorities())
                        .build(),
                User.builder()
                        .username("yang.hai")
                        .password(passwordEncoder.encode("Rachel!@#1234"))
                        .roles(ADMIN.name())
                        .authorities(ADMIN.getGrantedAuthorities())
                        .build(),
                User.builder()
                        .username("rachel.shi")
                        .password(passwordEncoder.encode("Rachel!@#1234"))
                        .roles(ADMIN_TRAINEE.name())
                        .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                        .build()
        );
    }
}
