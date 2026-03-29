package com.projects.safeydiet.feature.ingredient.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateIngredientRequest(
        @NotBlank(message = "Ingredient name required")
        String name
){}
