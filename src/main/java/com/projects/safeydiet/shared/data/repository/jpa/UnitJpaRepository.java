package com.projects.safeydiet.shared.data.repository.jpa;

import com.projects.safeydiet.shared.data.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitJpaRepository extends JpaRepository<Unit, Long> {
}
