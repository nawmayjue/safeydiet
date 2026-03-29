package com.projects.safeydiet.shared.data.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="roles")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends MasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
