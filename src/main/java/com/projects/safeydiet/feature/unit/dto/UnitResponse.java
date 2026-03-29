package com.projects.safeydiet.feature.unit.dto;


import com.projects.safeydiet.shared.data.dto.MasterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@Getter
public class UnitResponse extends MasterDto {
    private Long id;
    private String name;
    private String symbol;
}
