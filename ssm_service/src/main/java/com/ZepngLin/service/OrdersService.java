package com.ZepngLin.service;

import com.ZepngLin.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(int page,int pageSize);
    Orders findById(int id);
}
