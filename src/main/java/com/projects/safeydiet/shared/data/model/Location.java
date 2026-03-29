package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="locations")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String region;
    private String country;
}
