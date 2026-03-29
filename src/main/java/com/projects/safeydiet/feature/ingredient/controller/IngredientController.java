package com.projects.safeydiet.feature.ingredient.controller;

import com.projects.safeydiet.feature.ingredient.dto.CreateIngredientRequest;
import com.projects.safeydiet.feature.ingredient.dto.IngredientResponse;
import com.projects.safeydiet.feature.ingredient.dto.UpdateIngredientRequest;
import com.projects.safeydiet.feature.ingredient.service.IngredientService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/ingredients")
@RestController
@AllArgsConstructor
@Validated
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<ApiResponse> createIngredient(
            @Valid @RequestBody CreateIngredientRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        IngredientResponse ingredientResponse= ingredientService.createIngredient(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(ingredientResponse)
                        .message("Successfully added an ingredient")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateIngredient(
            @PathVariable Long id,
            @Valid @RequestBody UpdateIngredientRequest request
            ){
        IngredientResponse ingredientResponse= ingredientService.updateIngredient(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(ingredientResponse)
                        .message("Successfully updated an ingredient")
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllIngredients(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(ingredientService.retrieveAll())
                        .message("Ingredients have been retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneIngredient(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(ingredientService.retrieveOne(id))
                        .message("Ingredient Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted an Ingredient")
                        .build()
        );
    }

}
