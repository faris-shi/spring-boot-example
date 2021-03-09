package com.github.faris.springsecurityformauthexmaple.config;

import java.util.Collection;
import java.util.Set;

import static com.github.faris.springsecurityformauthexmaple.config.UserPermission.*;

public enum UserRole {
    ADMIN(Set.of(
            BOOK_WRITE,
            BOOK_READ,
            STUDENT_WRITE,
            STUDENT_READ
    )),
    STUDENT(Set.of(
            BOOK_READ,
            STUDENT_READ
    )),
    ADMIN_TRAINEE(Set.of(
            BOOK_READ,
            STUDENT_WRITE,
            STUDENT_READ
    ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Collection<UserPermission> getPermissions() {
        return permissions;
    }
}
