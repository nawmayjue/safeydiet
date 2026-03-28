package com.projects.safeydiet.shared.data.enums;

import java.util.Arrays;
import java.util.List;

public enum Status {
    PENDING("Pending"),
    PROCESSING( "Pending"),
    COMPLETED("Completed"),
    FAILED("Failed");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    private static List<StatusInfo> listInfo(){
        return Arrays.stream(
                Status.values()). map(
                status -> new StatusInfo(status.getDescription())
        ).toList();
    }

    public String getDescription() {
        return description;
    }
}
