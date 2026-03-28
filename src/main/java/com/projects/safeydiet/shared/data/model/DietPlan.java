package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "diet_plans")
public class DietPlan extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_cost", precision=10, scale=2)
    private BigDecimal totalCost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private AIRequest aiRequest;
}
