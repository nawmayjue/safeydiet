package com.projects.safeydiet.shared.data.repository.jpa;

import com.projects.safeydiet.shared.data.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyJpaRepository extends JpaRepository<Allergy, Long> {
    boolean existsByName(String name);
}
