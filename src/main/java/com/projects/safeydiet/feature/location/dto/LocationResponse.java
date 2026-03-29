package com.projects.safeydiet.feature.location.dto;


import com.projects.safeydiet.shared.data.dto.MasterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@AllArgsConstructor
@Getter
public class LocationResponse extends MasterDto {
    private Long id;
    private String city;
    private String region;
    private String country;
}
