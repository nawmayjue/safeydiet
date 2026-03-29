package com.projects.safeydiet.feature.role.controller;

import com.projects.safeydiet.feature.role.dto.CreateRoleRequest;
import com.projects.safeydiet.feature.role.dto.RoleResponse;
import com.projects.safeydiet.feature.role.dto.UpdateRoleRequest;
import com.projects.safeydiet.feature.role.service.RoleService;
import com.projects.safeydiet.shared.data.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/safeydiet/admin/roles")
@RestController
@AllArgsConstructor
@Validated
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ApiResponse> createRole(
            @Valid @RequestBody CreateRoleRequest request
            ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        RoleResponse roleResponse= roleService.createRole(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(roleResponse)
                        .message("Successfully added a role")
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateRole(
            @PathVariable Long id,
            @Valid @RequestBody UpdateRoleRequest request
            ){
        RoleResponse roleResponse= roleService.updateRole(id, request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(roleResponse)
                        .message("Successfully updated a role")
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> retrieveAllRoles(){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(roleService.retrieveAll())
                        .message("Roles Retrieved Successfully.")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> retrieveOneRole(@PathVariable Long id){
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(200)
                        .data(roleService.retrieveOne(id))
                        .message("Role Retrieved Successfully.")
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCountry(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(false)
                        .message("Successfully deleted a role")
                        .build()
        );
    }

}
