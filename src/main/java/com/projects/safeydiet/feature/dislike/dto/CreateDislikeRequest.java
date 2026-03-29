package com.projects.safeydiet.feature.dislike.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateDislikeRequest(
        @NotBlank(message = "Dislike name required")
        String name
){}
