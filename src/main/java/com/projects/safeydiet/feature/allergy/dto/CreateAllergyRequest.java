package com.projects.safeydiet.feature.allergy.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateAllergyRequest(
        @NotBlank(message = "Allergy name required")
        String name
){}
