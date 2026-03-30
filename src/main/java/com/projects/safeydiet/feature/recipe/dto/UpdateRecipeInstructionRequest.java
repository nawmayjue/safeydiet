package com.projects.safeydiet.feature.recipe.dto;


import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateRecipeInstructionRequest(
        @NotBlank(message = "Instructions required")
        String instruction
){}
