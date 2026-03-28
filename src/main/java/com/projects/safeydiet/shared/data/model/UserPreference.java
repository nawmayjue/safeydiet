package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_preferences")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (fetch = FetchType.LAZY)
    private User user;

    private boolean vegetarian;

    @ManyToMany
//    @JoinTable(
//            name = "user_preference_allergies",
//            joinColumns = @JoinColumn(name = "user_preference_id"),
//            inverseJoinColumns = @JoinColumn(name = "allergy_id")
//    )
    private Set<Allergy> allergies;

    @ManyToMany
//    @JoinTable(
//            name = "user_preference_dislikes",
//            joinColumns = @JoinColumn(name = "user_preference_id"),
//            inverseJoinColumns = @JoinColumn(name = "dislike_id")
//    )
    private Set<Dislike> dislikes;

}
