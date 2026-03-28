package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;

@Entity
@Table(name="recipes")
public class Recipe extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String instructions;
}
