package com.projects.safeydiet.shared.data.model;

import com.projects.safeydiet.shared.data.enums.Unit;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private Unit unit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;
}
