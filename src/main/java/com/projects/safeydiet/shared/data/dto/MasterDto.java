package com.projects.safeydiet.shared.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public abstract class MasterDto{
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private UserResponse createdBy;
//    private UserResponse updatedBy;
}
