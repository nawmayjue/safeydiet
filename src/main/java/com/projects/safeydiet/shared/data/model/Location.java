package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;

@Entity
@Table(name="locations")
public class Location extends MasterEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String region;
    private String country;
}
