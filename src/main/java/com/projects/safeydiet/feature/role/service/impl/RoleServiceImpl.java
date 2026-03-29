package com.projects.safeydiet.feature.role.service.impl;

import com.projects.safeydiet.feature.role.dto.CreateRoleRequest;
import com.projects.safeydiet.feature.role.dto.RoleResponse;
import com.projects.safeydiet.feature.role.dto.UpdateRoleRequest;
import com.projects.safeydiet.feature.role.service.RoleService;
import com.projects.safeydiet.shared.data.model.Role;
import com.projects.safeydiet.shared.data.repository.jpa.RoleJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleJpaRepository roleJpaRepository;

    @Override
    public RoleResponse createRole(CreateRoleRequest request){
        String name = request.name().trim().toLowerCase();

        if(roleJpaRepository.existsByName(name)){
            throw new BadRequestException("Role Already Exists.");
        }

        Role createdRole = Role.builder()
                .name(name)
                .build();

        Role savedRole = roleJpaRepository.save(createdRole);

        return RoleResponse.builder()
                .id(savedRole.getId())
                .name(savedRole.getName())
                .createdAt(savedRole.getCreatedAt())
                .updatedAt(savedRole.getUpdatedAt())
                .build();
    }

    @Override
    public List<RoleResponse> retrieveAll() {
        List<Role> roles = roleJpaRepository.findAll();
        return roles.stream()
                .map(role -> {
                    RoleResponse response = RoleResponse.builder()
                            .id(role.getId())
                            .name(role.getName())
                            .createdAt(role.getCreatedAt())
                            .updatedAt(role.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public RoleResponse retrieveOne(Long id) {
        Role role = roleJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Role not found"));

        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }

    @Override
    public RoleResponse updateRole(Long id, UpdateRoleRequest request) {
        Role role = roleJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Role not found"));

        String name = request.name().trim().toLowerCase();

        if(roleJpaRepository.existsByName(name)){
            throw new BadRequestException("Role Already Exists.");
        }

        role.setName(name);

        Role updatedRole = roleJpaRepository.save(role);

        return RoleResponse.builder()
                .id(updatedRole.getId())
                .name(updatedRole.getName())
                .createdAt(updatedRole.getCreatedAt())
                .updatedAt(updatedRole.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Role not found."));
        roleJpaRepository.deleteById(id);
    }

}
