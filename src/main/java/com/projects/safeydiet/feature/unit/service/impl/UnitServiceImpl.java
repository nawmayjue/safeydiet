package com.projects.safeydiet.feature.unit.service.impl;

import com.projects.safeydiet.feature.unit.dto.CreateUnitRequest;
import com.projects.safeydiet.feature.unit.dto.UnitResponse;
import com.projects.safeydiet.feature.unit.dto.UpdateUnitRequest;
import com.projects.safeydiet.feature.unit.service.UnitService;
import com.projects.safeydiet.shared.data.model.Ingredient;
import com.projects.safeydiet.shared.data.model.Unit;
import com.projects.safeydiet.shared.data.repository.jpa.UnitJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {
    private final UnitJpaRepository unitJpaRepository;

    @Override
    public UnitResponse createUnit(CreateUnitRequest request){
        String name = request.name().trim().toLowerCase();
        String symbol = request.symbol().trim().toLowerCase();

        if(unitJpaRepository.existsByName(name)){
            throw new BadRequestException("Unit Already Exists.");
        }

        Unit createdUnit = Unit.builder()
                .name(name)
                .symbol(symbol)
                .build();

        Unit savedUnit = unitJpaRepository.save(createdUnit);

        return UnitResponse.builder()
                .id(savedUnit.getId())
                .name(savedUnit.getName())
                .symbol(savedUnit.getSymbol())
                .createdAt(savedUnit.getCreatedAt())
                .updatedAt(savedUnit.getUpdatedAt())
                .build();
    }

    @Override
    public List<UnitResponse> retrieveAll() {
        List<Unit> units = unitJpaRepository.findAll();
        return units.stream()
                .map(unit -> {
                    UnitResponse response = UnitResponse.builder()
                            .id(unit.getId())
                            .name(unit.getName())
                            .symbol(unit.getSymbol())
                            .createdAt(unit.getCreatedAt())
                            .updatedAt(unit.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public UnitResponse retrieveOne(Long id) {
        Unit unit = unitJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Unit not found"));

        return UnitResponse.builder()
                .id(unit.getId())
                .name(unit.getName())
                .symbol(unit.getSymbol())
                .createdAt(unit.getCreatedAt())
                .updatedAt(unit.getUpdatedAt())
                .build();
    }

    @Override
    public UnitResponse updateUnit(Long id, UpdateUnitRequest request) {
        Unit unit = unitJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Unit not found"));

        String name = request.name().trim().toLowerCase();
        String symbol = request.symbol().trim().toLowerCase();

        if(unitJpaRepository.existsByName(name)){
            throw new BadRequestException("Unit Already Exists.");
        }

        unit.setName(name);
        unit.setSymbol(symbol);

        Unit updatedUnit = unitJpaRepository.save(unit);

        return UnitResponse.builder()
                .id(updatedUnit.getId())
                .name(updatedUnit.getName())
                .symbol(updatedUnit.getSymbol())
                .createdAt(updatedUnit.getCreatedAt())
                .updatedAt(updatedUnit.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteUnit(Long id) {
        Unit unit= unitJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Unit not found."));
        unitJpaRepository.deleteById(id);
    }

}
