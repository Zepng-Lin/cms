package com.ZepngLin.dao;

import com.ZepngLin.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findByRoleId(int id);

    @Select("select * from permission")
    List<Permission> findAll();

    @Select("select * from permission where id = #{id}")
    Permission findById(int id);

    @Insert("insert into permission values(null,#{permissionName},#{url})")
    void save(Permission permission);
}
