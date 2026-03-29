package com.projects.safeydiet.feature.role.dto;


import com.projects.safeydiet.shared.data.dto.MasterDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@Getter
public class RoleResponse extends MasterDto {
    private Long id;
    private String name;
}
