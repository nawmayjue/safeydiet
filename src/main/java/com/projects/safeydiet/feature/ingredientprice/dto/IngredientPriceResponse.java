package com.projects.safeydiet.feature.ingredientprice.dto;


import com.projects.safeydiet.feature.ingredient.dto.IngredientResponse;
import com.projects.safeydiet.feature.location.dto.LocationResponse;
import com.projects.safeydiet.feature.unit.dto.UnitResponse;
import com.projects.safeydiet.shared.data.dto.MasterDto;
import com.projects.safeydiet.shared.data.model.Ingredient;
import com.projects.safeydiet.shared.data.model.Location;
import com.projects.safeydiet.shared.data.model.Unit;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@AllArgsConstructor
@Getter
public class IngredientPriceResponse extends MasterDto {
    private Long id;
    private BigDecimal pricePerUnit;
    private UnitResponse unitResponse;
    private IngredientResponse ingredientResponse;
    private LocationResponse locationResponse;
//    private UserResponse updatedBy;
}
