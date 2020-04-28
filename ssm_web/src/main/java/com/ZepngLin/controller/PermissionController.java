package com.ZepngLin.controller;

import com.ZepngLin.domain.Permission;
import com.ZepngLin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView view = new ModelAndView("permission-list");
        view.addObject("permissionList",service.findAll());
        return view;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id){
        ModelAndView view = new ModelAndView("permission-show");
        Permission permission = service.findById(id);
        view.addObject("permission",permission);
        return  view;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){
        service.save(permission);
        return "redirect:findAll.do";
    }

}
