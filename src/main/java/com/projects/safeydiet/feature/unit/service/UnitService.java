package com.projects.safeydiet.feature.unit.service;

import com.projects.safeydiet.feature.unit.dto.CreateUnitRequest;
import com.projects.safeydiet.feature.unit.dto.UnitResponse;
import com.projects.safeydiet.feature.unit.dto.UpdateUnitRequest;

import java.util.List;

public interface UnitService {
    UnitResponse createUnit(CreateUnitRequest request);
    List<UnitResponse> retrieveAll();
    UnitResponse retrieveOne(Long id);
    UnitResponse updateUnit(Long id, UpdateUnitRequest request);
    void deleteUnit(Long id);
}
