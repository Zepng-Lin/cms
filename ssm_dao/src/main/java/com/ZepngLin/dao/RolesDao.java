package com.ZepngLin.dao;

import com.ZepngLin.domain.Permission;
import com.ZepngLin.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RolesDao {
    @Select("SELECT * FROM role WHERE id in (SELECT roleId FROM users_role WHERE userId = #{id})")
    @Results(
            @Result(column = "id",property = "permissions",many = @Many(select = "com.ZepngLin.dao.PermissionDao.findByRoleId")))
    List<Role> findByUserId(int id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role values(null,#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    @Results(
        @Result(column = "id",property = "permissions",many = @Many(select = "com.ZepngLin.dao.PermissionDao.findByRoleId"))
    )
    Role findById(int id);

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(int roleId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(int roleId);

    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(int roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findOtherPermission(int id);

    @Insert("insert into role_permission values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
