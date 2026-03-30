package com.projects.safeydiet.shared.data.repository.jpa;

import com.projects.safeydiet.shared.data.model.IngredientPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientPriceJpaRepository extends JpaRepository<IngredientPrice, Long> {
}
