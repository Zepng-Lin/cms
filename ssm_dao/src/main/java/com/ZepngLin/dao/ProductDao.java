package com.ZepngLin.dao;

import com.ZepngLin.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll();
    @Insert("insert into product(productNum,ProductName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);
    @Select("select * from product where id =#{id}")
    Product findById(int id);
}
