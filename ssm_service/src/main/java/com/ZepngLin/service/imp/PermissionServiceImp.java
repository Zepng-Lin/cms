package com.ZepngLin.service.imp;

import com.ZepngLin.dao.PermissionDao;
import com.ZepngLin.domain.Permission;
import com.ZepngLin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImp implements PermissionService {
    @Autowired
    private PermissionDao dao;
    @Override
    public List<Permission> findAll() {
        return dao.findAll();
    }

    @Override
    public Permission findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Permission permission) {
        dao.save(permission);
    }
}
