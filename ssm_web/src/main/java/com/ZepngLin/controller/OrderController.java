package com.ZepngLin.controller;

import com.ZepngLin.domain.Orders;
import com.ZepngLin.service.OrdersService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrderController {
    @Autowired
    private OrdersService service;
    @RolesAllowed("GUEST")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize){
        ModelAndView model = new  ModelAndView("orders-list");
        List<Orders> all = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo<Orders>(all);
        model.addObject("ordersInfo",pageInfo);
        return model;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") Integer id){
        ModelAndView view = new ModelAndView("orders-show");
        Orders orders = service.findById(id);
        view.addObject("orders",orders);
        return view;
    }
}
