package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dislikes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dislike extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

