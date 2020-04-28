package com.ZepngLin.service.imp;

import com.ZepngLin.dao.OrdersDao;
import com.ZepngLin.domain.Orders;
import com.ZepngLin.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImp implements OrdersService {

    @Autowired
    private OrdersDao dao;
    @Override
    public List<Orders> findAll(int page,int pageSize) {
//        必须位于dao调用上一句，才能进行分页
        PageHelper.startPage(page,pageSize);    //跟在这个方法后的第一个MyBatis 查询方法会被进行分页
        return dao.findAll();
    }

    @Override
    public Orders findById(int id) {
        return dao.findById(id);
    }
}
