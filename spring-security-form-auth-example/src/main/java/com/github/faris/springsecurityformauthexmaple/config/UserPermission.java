package com.github.faris.springsecurityformauthexmaple.config;

public enum UserPermission {

    BOOK_READ("book.read"),
    BOOK_WRITE("book.write"),
    STUDENT_READ("student.read"),
    STUDENT_WRITE("student.write");

    private final String description;

    UserPermission(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
