package com.projects.safeydiet.feature.unit.dto;


import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateUnitRequest(
        @NotBlank(message = "Unit name required")
        String name,

        @NotBlank(message = "Unit symbol required")
        String symbol
){}
