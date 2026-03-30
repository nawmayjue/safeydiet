package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "allergies")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Allergy extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
