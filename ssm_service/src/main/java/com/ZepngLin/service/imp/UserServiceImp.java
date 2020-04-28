package com.ZepngLin.service.imp;

import com.ZepngLin.dao.UserDao;
import com.ZepngLin.domain.Role;
import com.ZepngLin.domain.UserInfo;
import com.ZepngLin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService{
    @Autowired
    UserDao dao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;      //加密密码

    /**
     *
     * @param s 用户名
     * @return 认证对象的信息
     * @throws UsernameNotFoundException 未找到该用户
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();   //存储权限
        UserInfo userInfo = dao.findByUsername(s);
        for(Role role : userInfo.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new User(userInfo.getUsername(),userInfo.getPassword(),authorities);     //实现了UserDetails
    }

    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  //密码加密
        dao.save(user);
    }

    @Override
    public UserInfo findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(int id) {

        return dao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(int id, Integer[] roleIds) {
        for (int roleId : roleIds) {
            dao.addRoleToUser(id,roleId);
        }
    }


}
