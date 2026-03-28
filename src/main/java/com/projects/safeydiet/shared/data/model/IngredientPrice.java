package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="ingredient_prices")
public class IngredientPrice extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="status_id")
    private BigDecimal pricePerUnit;

    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
