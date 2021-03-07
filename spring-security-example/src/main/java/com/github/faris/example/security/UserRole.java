package com.github.faris.example.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

import static com.github.faris.example.security.UserPermission.*;
import static java.util.stream.Collectors.toSet;

public enum UserRole {
    STUDENT(Set.of(
            COURSE_READ,
            STUDENT_READ
    )),

    ADMIN(Set.of(
            STUDENT_WRITE,
            STUDENT_READ,
            COURSE_READ,
            COURSE_WRITE
    )),

    ADMIN_TRAINEE(Set.of(
            COURSE_READ,
            STUDENT_WRITE,
            STUDENT_READ
    ));

    private final Set<UserPermission> permissions;

    private UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> authorities = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.name())).collect(toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
