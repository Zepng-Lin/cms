package com.ZepngLin.service;

import com.ZepngLin.domain.Permission;
import com.ZepngLin.domain.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    List<Role> findAll();

    Role findById(int id);

    void deleteRole(int id);

    List<Permission> findOtherPermission(int id);

    void addPermissionToRole(int id,Integer[] permissionIds);
}
