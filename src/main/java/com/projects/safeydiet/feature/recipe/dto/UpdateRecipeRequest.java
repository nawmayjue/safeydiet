package com.projects.safeydiet.feature.recipe.dto;


import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateRecipeRequest(
        @NotBlank(message = "Recipe name required")
        String name,

        @NotBlank(message = "Instructions required")
        String instruction
){}
