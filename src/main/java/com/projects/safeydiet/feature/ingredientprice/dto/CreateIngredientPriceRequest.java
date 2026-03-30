package com.projects.safeydiet.feature.ingredientprice.dto;

import com.projects.safeydiet.shared.data.dto.MasterDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record CreateIngredientPriceRequest(
        @NotBlank(message = "Ingredient Id required")
        Long ingredientId,

        @NotBlank(message = "Price required")
        BigDecimal pricePerUnit,

        @NotBlank(message = "Unit Id required")
        Long unitId,

        @NotBlank(message = "Location Id required")
        Long locationId
){}
