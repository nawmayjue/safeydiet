package com.projects.safeydiet.feature.allergy.controller;

import com.projects.safeydiet.feature.allergy.dto.CreateAllergyRequest;
import com.projects.safeydiet.feature.allergy.dto.AllergyResponse;
import com.projects.safeydiet.feature.allergy.dto.UpdateAllergyRequest;
import com.projects.safeydiet.feature.allergy.service.AllergyService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/allergies")
@RestController
@AllArgsConstructor
@Validated
public class AllergyController {
    private final AllergyService allergyService;

    @PostMapping
    public ResponseEntity<ApiResponse> createAllergy(
            @Valid @RequestBody CreateAllergyRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        AllergyResponse allergyResponse= allergyService.createAllergy(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(allergyResponse)
                        .message("Successfully added an Allergy")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateAllergy(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAllergyRequest request
            ){
        AllergyResponse allergyResponse= allergyService.updateAllergy(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(allergyResponse)
                        .message("Successfully updated an Allergy")
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllAllergies(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(allergyService.retrieveAll())
                        .message("Allergies have been retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneAllergy(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(allergyService.retrieveOne(id))
                        .message("Allergy Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAllergy(@PathVariable Long id){
        allergyService.deleteAllergy(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted an allergy")
                        .build()
        );
    }

}
