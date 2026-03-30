package com.projects.safeydiet.feature.ingredientprice.dto;


import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateIngredientPriceRequest(
        @NotBlank(message = "City required")
        String city,

        @NotBlank(message = "Region required")
        String region,

        @NotBlank(message = "Country required")
        String country
){}
