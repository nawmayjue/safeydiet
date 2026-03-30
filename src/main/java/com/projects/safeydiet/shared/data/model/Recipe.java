package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="recipes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String instructions;
}
