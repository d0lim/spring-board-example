package com.studyspring.boardexample.domain;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_ADMIN");

    private final String role_user;

    UserRole(String role_user) {
        this.role_user = role_user;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return role_user;
    }
}