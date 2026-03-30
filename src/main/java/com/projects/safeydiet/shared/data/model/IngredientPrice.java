package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="ingredient_prices")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientPrice extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="price_per_unit")
    private BigDecimal pricePerUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Unit unit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
