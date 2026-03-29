package com.projects.safeydiet.shared.data.repository.jpa;

import com.projects.safeydiet.shared.data.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientJpaRepository extends JpaRepository<Ingredient, Long> {
    boolean existsByName(String name);
}
