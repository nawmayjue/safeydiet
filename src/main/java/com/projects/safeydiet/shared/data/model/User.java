package com.projects.safeydiet.shared.data.model;

import com.projects.safeydiet.shared.data.enums.Role;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "login_username")
    private String loginUsername;

    @Column(name = "login_email")
    private String loginEmail;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "family_size")
    private int familySize;

    @Column(name = "weekly_budget")
    private BigDecimal weeklyBudget;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
}
