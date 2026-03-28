package com.projects.safeydiet.shared.data.model;

import com.projects.safeydiet.shared.data.enums.Unit;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "shopping_list_items")
public class ShoppingListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_list_id", nullable = false)
    private ShoppingList shoppingList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column(name = "total_quantity")
    private BigDecimal totalQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private Unit unit;

    @Column(name = "price_per_unit", precision = 10, scale=2)
    private BigDecimal pricePerUnit;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;
}
