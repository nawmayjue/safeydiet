package com.projects.safeydiet.feature.allergy.service.impl;

import com.projects.safeydiet.feature.allergy.dto.CreateAllergyRequest;
import com.projects.safeydiet.feature.allergy.dto.AllergyResponse;
import com.projects.safeydiet.feature.allergy.dto.UpdateAllergyRequest;
import com.projects.safeydiet.feature.allergy.service.AllergyService;
import com.projects.safeydiet.shared.data.model.Allergy;
import com.projects.safeydiet.shared.data.repository.jpa.AllergyJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AllergyServiceImpl implements AllergyService {
    private final AllergyJpaRepository allergyJpaRepository;

    @Override
    public AllergyResponse createAllergy(CreateAllergyRequest request){
        String name = request.name().trim().toLowerCase();

        if(allergyJpaRepository.existsByName(name)){
            throw new BadRequestException("Allergy Already Exists.");
        }

        Allergy createdAllergy = Allergy.builder()
                .name(name)
                .build();

        Allergy savedAllergy = allergyJpaRepository.save(createdAllergy);

        return AllergyResponse.builder()
                .id(savedAllergy.getId())
                .name(savedAllergy.getName())
                .createdAt(savedAllergy.getCreatedAt())
                .updatedAt(savedAllergy.getUpdatedAt())
                .build();
    }

    @Override
    public List<AllergyResponse> retrieveAll() {
        List<Allergy> allergies = allergyJpaRepository.findAll();
        return allergies.stream()
                .map(allergy -> {
                    AllergyResponse response = AllergyResponse.builder()
                            .id(allergy.getId())
                            .name(allergy.getName())
                            .createdAt(allergy.getCreatedAt())
                            .updatedAt(allergy.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public AllergyResponse retrieveOne(Long id) {
        Allergy allergy = allergyJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Allergy not found"));

        return AllergyResponse.builder()
                .id(allergy.getId())
                .name(allergy.getName())
                .createdAt(allergy.getCreatedAt())
                .updatedAt(allergy.getUpdatedAt())
                .build();
    }

    @Override
    public AllergyResponse updateAllergy(Long id, UpdateAllergyRequest request) {
        Allergy allergy = allergyJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Allergy not found"));

        String name = request.name().trim().toLowerCase();

        if(allergyJpaRepository.existsByName(name)){
            throw new BadRequestException("Allergy Already Exists.");
        }

        allergy.setName(name);

        Allergy updatedAllergy = allergyJpaRepository.save(allergy);

        return AllergyResponse.builder()
                .id(updatedAllergy.getId())
                .name(updatedAllergy.getName())
                .createdAt(updatedAllergy.getCreatedAt())
                .updatedAt(updatedAllergy.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteAllergy(Long id) {
        Allergy allergy= allergyJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Allergy not found."));
        allergyJpaRepository.deleteById(id);
    }

}
