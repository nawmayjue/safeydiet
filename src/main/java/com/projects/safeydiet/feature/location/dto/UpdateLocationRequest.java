package com.projects.safeydiet.feature.location.dto;


import com.projects.safeydiet.shared.data.dto.MasterDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateLocationRequest (
        @NotBlank(message = "City required")
        String city,

        @NotBlank(message = "Region required")
        String region,

        @NotBlank(message = "Country required")
        String country
){}
