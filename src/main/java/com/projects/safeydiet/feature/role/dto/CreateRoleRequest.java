package com.projects.safeydiet.feature.role.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateRoleRequest(
        @NotBlank(message = "Role name required")
        String name
){}
