package com.ZepngLin.service;

import com.ZepngLin.domain.Role;
import com.ZepngLin.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
   List<UserInfo> findAll();
   void save(UserInfo user);

   UserInfo findById(int id);

   List<Role> findOtherRoles(int id);

   void addRoleToUser(int id, Integer[] roleIds);
}
