package com.projects.safeydiet.feature.unit.controller;

import com.projects.safeydiet.feature.unit.dto.CreateUnitRequest;
import com.projects.safeydiet.feature.unit.dto.UnitResponse;
import com.projects.safeydiet.feature.unit.dto.UpdateUnitRequest;
import com.projects.safeydiet.feature.unit.service.UnitService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/units")
@RestController
@AllArgsConstructor
@Validated
public class UnitController {
    private final UnitService unitService;

    @PostMapping
    public ResponseEntity<ApiResponse> createUnit(
            @Valid @RequestBody CreateUnitRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        UnitResponse unitResponse= unitService.createUnit(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(unitResponse)
                        .message("Successfully added a unit")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUnit(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUnitRequest request
            ){
        UnitResponse unitResponse= unitService.updateUnit(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(unitResponse)
                        .message("Successfully updated a Unit")
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllUnits(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(unitService.retrieveAll())
                        .message("Units have been retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneUnit(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(unitService.retrieveOne(id))
                        .message("Unit Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUnit(@PathVariable Long id){
        unitService.deleteUnit(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted a Unit")
                        .build()
        );
    }

}
