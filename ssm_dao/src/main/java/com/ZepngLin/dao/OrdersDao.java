package com.ZepngLin.dao;

import com.ZepngLin.domain.Orders;
import com.ZepngLin.domain.Product;
import com.sun.javafx.beans.IDProperty;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results(
           @Result(column = "productId",property = "product",one = @One(select = "com.ZepngLin.dao.ProductDao.findById"))
    )
    List<Orders> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(column = "productId",property = "product",one = @One(select = "com.ZepngLin.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",one = @One(select = "com.ZepngLin.dao.MemberDao.findById")),
            @Result(column = "productId",property = "travellers",many = @Many(select = "com.ZepngLin.dao.TravellersDao.findByOrdersId"))
    })
    Orders findById(int id);
}
