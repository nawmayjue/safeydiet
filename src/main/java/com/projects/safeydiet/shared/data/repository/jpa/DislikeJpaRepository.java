package com.projects.safeydiet.shared.data.repository.jpa;

import com.projects.safeydiet.shared.data.model.Dislike;
import com.projects.safeydiet.shared.data.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikeJpaRepository extends JpaRepository<Dislike, Long> {
    boolean existsByName(String name);
}
