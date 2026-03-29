package com.projects.safeydiet.feature.location.service;

import com.projects.safeydiet.feature.location.dto.CreateLocationRequest;
import com.projects.safeydiet.feature.location.dto.LocationResponse;
import com.projects.safeydiet.feature.location.dto.UpdateLocationRequest;

import java.util.List;

public interface LocationService {
    LocationResponse createLocation(CreateLocationRequest request);
    List<LocationResponse> retrieveAll();
    LocationResponse retrieveOne(Long id);
    LocationResponse updateLocation(Long id, UpdateLocationRequest request);
    void deleteLocation(Long id);
}
