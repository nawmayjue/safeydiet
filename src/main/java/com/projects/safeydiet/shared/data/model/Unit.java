package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "units")
@Getter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
