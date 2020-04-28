package com.ZepngLin.service;

import com.ZepngLin.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer page,Integer pageSize) throws Exception;
}
