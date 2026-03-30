package com.projects.safeydiet.feature.recipe.service;

import com.projects.safeydiet.feature.recipe.dto.CreateRecipeRequest;
import com.projects.safeydiet.feature.recipe.dto.RecipeResponse;
import com.projects.safeydiet.feature.recipe.dto.UpdateRecipeInstructionRequest;
import com.projects.safeydiet.feature.recipe.dto.UpdateRecipeRequest;

import java.util.List;

public interface RecipeService {
    RecipeResponse createRecipe(CreateRecipeRequest request);
    List<RecipeResponse> retrieveAll();
    RecipeResponse retrieveOne(Long id);
    RecipeResponse updateRecipe(Long id, UpdateRecipeRequest request);
    RecipeResponse updateRecipeInstruction(Long id, UpdateRecipeInstructionRequest request);
    void deleteRecipe(Long id);
}
