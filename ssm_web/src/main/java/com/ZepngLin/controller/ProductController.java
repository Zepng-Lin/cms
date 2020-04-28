package com.ZepngLin.controller;

import com.ZepngLin.domain.Product;
import com.ZepngLin.service.ProductService;
import com.ZepngLin.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService service = new ProductServiceImp();
    @RequestMapping("/test")
    public String test(){
        System.out.println("controller");
        return "success";
    }
    @RolesAllowed("GUEST")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        System.out.println("findall.do");
        ModelAndView view = new ModelAndView("product-list");
        view.addObject("productList",service.findAll());
        return view;
    }
    @RequestMapping("/save.do")
    public String saveProduct(Product product){
        service.saveProduct(product);
        return "redirect:findAll.do"; }

}
