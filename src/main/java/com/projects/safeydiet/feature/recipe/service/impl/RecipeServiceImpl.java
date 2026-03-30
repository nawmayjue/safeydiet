package com.projects.safeydiet.feature.recipe.service.impl;

import com.projects.safeydiet.feature.recipe.dto.CreateRecipeRequest;
import com.projects.safeydiet.feature.recipe.dto.RecipeResponse;
import com.projects.safeydiet.feature.recipe.dto.UpdateRecipeInstructionRequest;
import com.projects.safeydiet.feature.recipe.dto.UpdateRecipeRequest;
import com.projects.safeydiet.feature.recipe.service.RecipeService;
import com.projects.safeydiet.shared.data.model.Recipe;
import com.projects.safeydiet.shared.data.repository.jpa.RecipeJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeJpaRepository recipeJpaRepository;

    @Override
    public RecipeResponse createRecipe(CreateRecipeRequest request){
        String name = request.name().trim().toLowerCase();
        String instructions = request.instruction();

        if(recipeJpaRepository.existsByName(name)){
            throw new BadRequestException("Recipe Already Exists.");
        }

        Recipe createRecipe = Recipe.builder()
                .name(name)
                .instructions(instructions)
                .build();

        Recipe savedRecipe = recipeJpaRepository.save(createRecipe);

        return RecipeResponse.builder()
                .id(savedRecipe.getId())
                .name(savedRecipe.getName())
                .instruction(savedRecipe.getInstructions())
                .createdAt(savedRecipe.getCreatedAt())
                .updatedAt(savedRecipe.getUpdatedAt())
                .build();
    }

    @Override
    public List<RecipeResponse> retrieveAll() {
        List<Recipe> recipes = recipeJpaRepository.findAll();
        return recipes.stream()
                .map(recipe -> {
                    RecipeResponse response = RecipeResponse.builder()
                            .id(recipe.getId())
                            .name(recipe.getName())
                            .instruction(recipe.getInstructions())
                            .createdAt(recipe.getCreatedAt())
                            .updatedAt(recipe.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public RecipeResponse retrieveOne(Long id) {
        Recipe recipe = recipeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Recipe not found"));

        return RecipeResponse.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .instruction(recipe.getInstructions())
                .createdAt(recipe.getCreatedAt())
                .updatedAt(recipe.getUpdatedAt())
                .build();
    }

    @Override
    public RecipeResponse updateRecipe(Long id, UpdateRecipeRequest request) {
        Recipe recipe = recipeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Recipe not found"));

        String name = request.name().trim().toLowerCase();
        String instruction = request.instruction();

        if(recipeJpaRepository.existsByName(name)){
            throw new BadRequestException("Recipe Already Exists.");
        }

        recipe.setName(name);
        recipe.setInstructions(instruction);

        Recipe updatedRecipe = recipeJpaRepository.save(recipe);

        return RecipeResponse.builder()
                .id(updatedRecipe.getId())
                .name(updatedRecipe.getName())
                .instruction(updatedRecipe.getInstructions())
                .createdAt(updatedRecipe.getCreatedAt())
                .updatedAt(updatedRecipe.getUpdatedAt())
                .build();
    }

    @Override
    public RecipeResponse updateRecipeInstruction(Long id, UpdateRecipeInstructionRequest request) {
        Recipe recipe = recipeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Recipe not found"));

        String instruction = request.instruction();
        recipe.setInstructions(instruction);

        Recipe updatedRecipe = recipeJpaRepository.save(recipe);

        return RecipeResponse.builder()
                .id(updatedRecipe.getId())
                .name(updatedRecipe.getName())
                .instruction(updatedRecipe.getInstructions())
                .createdAt(updatedRecipe.getCreatedAt())
                .updatedAt(updatedRecipe.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteRecipe(Long id) {
        Recipe recipe= recipeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Recipe not found."));
        recipeJpaRepository.deleteById(id);
    }

}
