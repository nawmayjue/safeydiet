package com.projects.safeydiet.feature.dislike.service.impl;

import com.projects.safeydiet.feature.dislike.dto.CreateDislikeRequest;
import com.projects.safeydiet.feature.dislike.dto.DislikeResponse;
import com.projects.safeydiet.feature.dislike.dto.UpdateDislikeRequest;
import com.projects.safeydiet.feature.dislike.service.DislikeService;
import com.projects.safeydiet.shared.data.model.Dislike;
import com.projects.safeydiet.shared.data.model.Ingredient;
import com.projects.safeydiet.shared.data.repository.jpa.DislikeJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DislikeServiceImpl implements DislikeService {
    private final DislikeJpaRepository dislikeJpaRepository;

    @Override
    public DislikeResponse createDislike(CreateDislikeRequest request){
        String name = request.name().trim().toLowerCase();

        if(dislikeJpaRepository.existsByName(name)){
            throw new BadRequestException("Dislike Already Exists.");
        }

        Dislike createdDislike = Dislike.builder()
                .name(name)
                .build();

        Dislike savedDislike = dislikeJpaRepository.save(createdDislike);

        return DislikeResponse.builder()
                .id(savedDislike.getId())
                .name(savedDislike.getName())
                .createdAt(savedDislike.getCreatedAt())
                .updatedAt(savedDislike.getUpdatedAt())
                .build();
    }

    @Override
    public List<DislikeResponse> retrieveAll() {
        List<Dislike> dislikes = dislikeJpaRepository.findAll();
        return dislikes.stream()
                .map(dislike -> {
                    DislikeResponse response = DislikeResponse.builder()
                            .id(dislike.getId())
                            .name(dislike.getName())
                            .createdAt(dislike.getCreatedAt())
                            .updatedAt(dislike.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public DislikeResponse retrieveOne(Long id) {
        Dislike dislike = dislikeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Dislike not found"));

        return DislikeResponse.builder()
                .id(dislike.getId())
                .name(dislike.getName())
                .createdAt(dislike.getCreatedAt())
                .updatedAt(dislike.getUpdatedAt())
                .build();
    }

    @Override
    public DislikeResponse updateDislike(Long id, UpdateDislikeRequest request) {
        Dislike dislike = dislikeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Dislike not found"));

        String name = request.name().trim().toLowerCase();

        if(dislikeJpaRepository.existsByName(name)){
            throw new BadRequestException("Dislike Already Exists.");
        }

        dislike.setName(name);

        Dislike updatedDislike = dislikeJpaRepository.save(dislike);

        return DislikeResponse.builder()
                .id(updatedDislike.getId())
                .name(updatedDislike.getName())
                .createdAt(updatedDislike.getCreatedAt())
                .updatedAt(updatedDislike.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteDislike(Long id) {
        Dislike dislike= dislikeJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Dislike not found."));
        dislikeJpaRepository.deleteById(id);
    }

}
