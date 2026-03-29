package com.projects.safeydiet.feature.role.service;

import com.projects.safeydiet.feature.role.dto.CreateRoleRequest;
import com.projects.safeydiet.feature.role.dto.RoleResponse;
import com.projects.safeydiet.feature.role.dto.UpdateRoleRequest;

import java.util.List;

public interface RoleService {
    RoleResponse createRole(CreateRoleRequest request);
    List<RoleResponse> retrieveAll();
    RoleResponse retrieveOne(Long id);
    RoleResponse updateRole(Long id, UpdateRoleRequest request);
    void deleteRole(Long id);
}
