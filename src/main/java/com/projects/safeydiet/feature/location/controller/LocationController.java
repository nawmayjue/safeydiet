package com.projects.safeydiet.feature.location.controller;

import com.projects.safeydiet.feature.location.dto.CreateLocationRequest;
import com.projects.safeydiet.feature.location.dto.LocationResponse;
import com.projects.safeydiet.feature.location.dto.UpdateLocationRequest;
import com.projects.safeydiet.feature.location.service.LocationService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/locations")
@RestController
@AllArgsConstructor
@Validated
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<ApiResponse> createLocation(
            @Valid @RequestBody CreateLocationRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        LocationResponse locationResponse= locationService.createLocation(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(locationResponse)
                        .message("Successfully added a location")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateLocation(
            @PathVariable Long id,
            @Valid @RequestBody UpdateLocationRequest request
            ){
        LocationResponse locationResponse= locationService.updateLocation(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(locationResponse)
                        .message("Successfully updated a location")
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllLocations(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(locationService.retrieveAll())
                        .message("Locations Retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneLocation(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(locationService.retrieveOne(id))
                        .message("Locations Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted a location")
                        .build()
        );
    }

}
