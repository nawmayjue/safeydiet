package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "shopping_lists")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="diet_plan_id", nullable=false)
    private DietPlan dietPlan;

}
