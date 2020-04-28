package com.ZepngLin.controller;

import com.ZepngLin.domain.Permission;
import com.ZepngLin.domain.Role;
import com.ZepngLin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Service;
import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    RoleService service;
    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("role-list");
        List<Role> all = service.findAll();
        modelAndView.addObject("roleList",all);
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public String save(Role role){
        service.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id){
        ModelAndView modelAndView = new ModelAndView("role-show");
        Role role = service.findById(id);
        modelAndView.addObject("role",role);
        return modelAndView;
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(Integer id){
        service.deleteRole(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(Integer id){
        ModelAndView modelAndView = new ModelAndView("role-permission-add");
        List<Permission> permissions = service.findOtherPermission(id);
        modelAndView.addObject("permissionList",permissions);
        modelAndView.addObject("RoleId",id);
        return modelAndView;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(Integer roleId,Integer[] ids){
        service.addPermissionToRole(roleId,ids);
        return "redirect:findRoleByIdAndAllPermission.do?id="+roleId;
    }

}
