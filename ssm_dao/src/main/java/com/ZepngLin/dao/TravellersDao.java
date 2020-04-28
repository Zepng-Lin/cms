package com.ZepngLin.dao;

import com.ZepngLin.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellersDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{id})")
    List<Traveller> findByOrdersId(int id);
}
