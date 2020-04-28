package com.ZepngLin.dao;

import com.ZepngLin.domain.Role;
import com.ZepngLin.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from users where username = #{username}")
    @Results(@Result(column = "id",property = "roles",many =
        @Many(select = "com.ZepngLin.dao.RolesDao.findByUserId")))
    UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users values(null,#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo users);

    @Select("select * from users where id =#{id}")
    @Results(
            @Result(column = "id" ,property = "roles",many = @Many(select = "com.ZepngLin.dao.RolesDao.findByUserId")))
    UserInfo findById(int id);

    @Select("select * from role where id not in (select roleId FROM users_role where  userId = #{id})")
    List<Role> findOtherRoles(int id);

    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
