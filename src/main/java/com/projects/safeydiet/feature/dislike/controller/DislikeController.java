package com.projects.safeydiet.feature.dislike.controller;

import com.projects.safeydiet.feature.dislike.dto.CreateDislikeRequest;
import com.projects.safeydiet.feature.dislike.dto.DislikeResponse;
import com.projects.safeydiet.feature.dislike.dto.UpdateDislikeRequest;
import com.projects.safeydiet.feature.dislike.service.DislikeService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/dislikes")
@RestController
@AllArgsConstructor
@Validated
public class DislikeController {
    private final DislikeService dislikeService;

    @PostMapping
    public ResponseEntity<ApiResponse> createDislike(
            @Valid @RequestBody CreateDislikeRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        DislikeResponse dislikeResponse= dislikeService.createDislike(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(dislikeResponse)
                        .message("Successfully added a dislike")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateDislike(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDislikeRequest request
            ){
        DislikeResponse dislikeResponse= dislikeService.updateDislike(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(dislikeResponse)
                        .message("Successfully updated an Dislike")
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllDislikes(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(dislikeService.retrieveAll())
                        .message("Dislikes have been retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneDislike(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(dislikeService.retrieveOne(id))
                        .message("Dislike Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteDislike(@PathVariable Long id){
        dislikeService.deleteDislike(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted a dislike")
                        .build()
        );
    }

}
