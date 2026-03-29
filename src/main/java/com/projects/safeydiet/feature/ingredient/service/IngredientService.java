package com.projects.safeydiet.feature.ingredient.service;

import com.projects.safeydiet.feature.ingredient.dto.CreateIngredientRequest;
import com.projects.safeydiet.feature.ingredient.dto.IngredientResponse;
import com.projects.safeydiet.feature.ingredient.dto.UpdateIngredientRequest;

import java.util.List;

public interface IngredientService {
    IngredientResponse createIngredient(CreateIngredientRequest request);
    List<IngredientResponse> retrieveAll();
    IngredientResponse retrieveOne(Long id);
    IngredientResponse updateIngredient(Long id, UpdateIngredientRequest request);
    void deleteIngredient(Long id);
}
