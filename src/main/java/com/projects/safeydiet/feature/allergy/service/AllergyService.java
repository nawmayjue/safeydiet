package com.projects.safeydiet.feature.allergy.service;

import com.projects.safeydiet.feature.allergy.dto.CreateAllergyRequest;
import com.projects.safeydiet.feature.allergy.dto.AllergyResponse;
import com.projects.safeydiet.feature.allergy.dto.UpdateAllergyRequest;

import java.util.List;

public interface AllergyService {
    AllergyResponse createAllergy(CreateAllergyRequest request);
    List<AllergyResponse> retrieveAll();
    AllergyResponse retrieveOne(Long id);
    AllergyResponse updateAllergy(Long id, UpdateAllergyRequest request);
    void deleteAllergy(Long id);
}
