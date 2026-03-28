package com.projects.safeydiet.shared.data.model;

import com.projects.safeydiet.shared.data.enums.MealType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "meals")
public class Meal extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false)
    private MealType mealType;

    private Integer dayNumber;

    @Column(name = "meal_date", nullable = false)
    private LocalDate mealDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DietPlan dietPlan;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Recipe recipe;
}
