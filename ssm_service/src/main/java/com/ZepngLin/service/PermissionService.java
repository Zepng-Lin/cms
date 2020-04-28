package com.ZepngLin.service;

import com.ZepngLin.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService {
    List<Permission> findAll();

    Permission findById(int id);

    void save(Permission permission);
}
