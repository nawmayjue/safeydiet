package com.projects.safeydiet.shared.data.dto;

public record ErrorResponse(
        int code,
        String message
) {}
