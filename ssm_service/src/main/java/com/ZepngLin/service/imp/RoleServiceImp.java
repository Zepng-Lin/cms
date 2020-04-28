package com.ZepngLin.service.imp;

import com.ZepngLin.dao.RolesDao;
import com.ZepngLin.domain.Permission;
import com.ZepngLin.domain.Role;
import com.ZepngLin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("roleService")
@Transactional
public class RoleServiceImp implements RoleService {
    @Autowired
    RolesDao dao;
    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public Role findById(int id) {
        System.out.println(dao.findById(id));
        return dao.findById(id);
    }

    @Override
    public void deleteRole(int id) {
        dao.deleteFromRole_PermissionByRoleId(id);
        dao.deleteFromUser_RoleByRoleId(id);
        dao.deleteRoleById(id);
    }

    @Override
    public List<Permission> findOtherPermission(int id) {
        return dao.findOtherPermission(id);
    }

    @Override
    public void addPermissionToRole(int roleId, Integer[] permissionIds) {
        for (int permissionId : permissionIds) {
            dao.addPermissionToRole(roleId,permissionId);
        }
    }


}
