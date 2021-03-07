package com.github.faris.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.faris.example.security.UserPermission.STUDENT_READ;
import static com.github.faris.example.security.UserPermission.STUDENT_WRITE;
import static com.github.faris.example.security.UserRole.*;
import static java.util.stream.Collectors.toList;

/**
 * @author faris
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
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
