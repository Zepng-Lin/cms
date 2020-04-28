package com.ZepngLin.controller;

import com.ZepngLin.domain.Role;
import com.ZepngLin.domain.UserInfo;
import com.ZepngLin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UserService service;
//    @Secured("ROLE_ROOT")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView view = new  ModelAndView("user-list");
        view.addObject("userList",service.findAll());
        return view;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        service.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id){
        UserInfo userInfo = service.findById(id);
        ModelAndView view = new ModelAndView("user-show");
        view.addObject("user",userInfo);
        return view;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(Integer id){
        UserInfo info = service.findById(id);
        List<Role> roles = service.findOtherRoles(id);
        ModelAndView view = new ModelAndView("user-role-add");
        view.addObject("roleList",roles);
        view.addObject("userId",id);
        return view;
    }
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(Integer userId ,Integer[] ids){
        service.addRoleToUser(userId,ids);
        return "redirect:findUserByIdAndAllRole.do?id="+userId;
    }
}
