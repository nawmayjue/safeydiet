package com.projects.safeydiet.feature.recipe.controller;

import com.projects.safeydiet.feature.recipe.dto.CreateRecipeRequest;
import com.projects.safeydiet.feature.recipe.dto.RecipeResponse;
import com.projects.safeydiet.feature.recipe.dto.UpdateRecipeInstructionRequest;
import com.projects.safeydiet.feature.recipe.dto.UpdateRecipeRequest;
import com.projects.safeydiet.feature.recipe.service.RecipeService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/recipes")
@RestController
@AllArgsConstructor
@Validated
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping
    public ResponseEntity<ApiResponse> createRecipe(
            @Valid @RequestBody CreateRecipeRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        RecipeResponse recipeResponse= recipeService.createRecipe(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(recipeResponse)
                        .message("Successfully added a Recipe")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateRecipe(
            @PathVariable Long id,
            @Valid @RequestBody UpdateRecipeRequest request
            ){
        RecipeResponse recipeResponse= recipeService.updateRecipe(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(recipeResponse)
                        .message("Successfully updated a Recipe")
                        .build()
        );
    }

    @PatchMapping("/{id}/instructions")
    public ResponseEntity<ApiResponse> updateRecipeInstruction(
            @PathVariable Long id,
            @RequestBody UpdateRecipeInstructionRequest request
    ){
        RecipeResponse recipeResponse= recipeService.updateRecipeInstruction(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(recipeResponse)
                        .message("Successfully updated a Recipe Instruction")
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllRecipe(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(recipeService.retrieveAll())
                        .message("Recipes have been retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneRecipe(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(recipeService.retrieveOne(id))
                        .message("Recipe Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted a Recipe")
                        .build()
        );
    }

}
