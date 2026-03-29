package com.projects.safeydiet.feature.dislike.service;

import com.projects.safeydiet.feature.dislike.dto.CreateDislikeRequest;
import com.projects.safeydiet.feature.dislike.dto.DislikeResponse;
import com.projects.safeydiet.feature.dislike.dto.UpdateDislikeRequest;

import java.util.List;

public interface DislikeService {
    DislikeResponse createDislike(CreateDislikeRequest request);
    List<DislikeResponse> retrieveAll();
    DislikeResponse retrieveOne(Long id);
    DislikeResponse updateDislike(Long id, UpdateDislikeRequest request);
    void deleteDislike(Long id);
}
