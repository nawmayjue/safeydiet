package com.projects.safeydiet.shared.data.enums;

public enum Role {
    USER("user"),
    ADMIN("admin");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
