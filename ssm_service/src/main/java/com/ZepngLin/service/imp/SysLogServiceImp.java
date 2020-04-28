package com.ZepngLin.service.imp;

import com.ZepngLin.dao.SysLogDao;
import com.ZepngLin.domain.SysLog;
import com.ZepngLin.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImp implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }
    @Override
    public List<SysLog> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAll();
    }
}