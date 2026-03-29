package com.projects.safeydiet.shared.data.repository.jpa;

import com.projects.safeydiet.shared.data.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
    boolean existsByCity(String city);

    Location findByCity(String city);

    boolean existsByCityAndRegionAndCountry(String city, String region, String country);
}
