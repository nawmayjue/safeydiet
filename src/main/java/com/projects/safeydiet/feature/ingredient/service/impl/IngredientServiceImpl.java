package com.projects.safeydiet.feature.ingredient.service.impl;

import com.projects.safeydiet.feature.ingredient.dto.CreateIngredientRequest;
import com.projects.safeydiet.feature.ingredient.dto.IngredientResponse;
import com.projects.safeydiet.feature.ingredient.dto.UpdateIngredientRequest;
import com.projects.safeydiet.feature.ingredient.service.IngredientService;
import com.projects.safeydiet.shared.data.model.Ingredient;
import com.projects.safeydiet.shared.data.model.Role;
import com.projects.safeydiet.shared.data.repository.jpa.IngredientJpaRepository;
import com.projects.safeydiet.shared.data.repository.jpa.RoleJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientJpaRepository ingredientJpaRepository;

    @Override
    public IngredientResponse createIngredient(CreateIngredientRequest request){
        String name = request.name().trim().toLowerCase();

        if(ingredientJpaRepository.existsByName(name)){
            throw new BadRequestException("Ingredient Already Exists.");
        }

        Ingredient createdIngredient = Ingredient.builder()
                .name(name)
                .build();

        Ingredient savedIngredient = ingredientJpaRepository.save(createdIngredient);

        return IngredientResponse.builder()
                .id(savedIngredient.getId())
                .name(savedIngredient.getName())
                .createdAt(savedIngredient.getCreatedAt())
                .updatedAt(savedIngredient.getUpdatedAt())
                .build();
    }

    @Override
    public List<IngredientResponse> retrieveAll() {
        List<Ingredient> ingredients = ingredientJpaRepository.findAll();
        return ingredients.stream()
                .map(ingredient -> {
                    IngredientResponse response = IngredientResponse.builder()
                            .id(ingredient.getId())
                            .name(ingredient.getName())
                            .createdAt(ingredient.getCreatedAt())
                            .updatedAt(ingredient.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public IngredientResponse retrieveOne(Long id) {
        Ingredient ingredient = ingredientJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Ingredient not found"));

        return IngredientResponse.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .createdAt(ingredient.getCreatedAt())
                .updatedAt(ingredient.getUpdatedAt())
                .build();
    }

    @Override
    public IngredientResponse updateIngredient(Long id, UpdateIngredientRequest request) {
        Ingredient ingredient = ingredientJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Ingredient not found"));

        String name = request.name().trim().toLowerCase();

        if(ingredientJpaRepository.existsByName(name)){
            throw new BadRequestException("Ingredient Already Exists.");
        }

        ingredient.setName(name);

        Ingredient updatedIngredient = ingredientJpaRepository.save(ingredient);

        return IngredientResponse.builder()
                .id(updatedIngredient.getId())
                .name(updatedIngredient.getName())
                .createdAt(updatedIngredient.getCreatedAt())
                .updatedAt(updatedIngredient.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteIngredient(Long id) {
        Ingredient ingredient= ingredientJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Ingredient not found."));
        ingredientJpaRepository.deleteById(id);
    }

}
