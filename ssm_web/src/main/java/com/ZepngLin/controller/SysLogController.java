package com.ZepngLin.controller;

import com.ZepngLin.domain.SysLog;
import com.ZepngLin.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/sysLog")
@Controller
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer page,Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo<SysLog>(sysLogs);
        mv.addObject("sysLogs", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}