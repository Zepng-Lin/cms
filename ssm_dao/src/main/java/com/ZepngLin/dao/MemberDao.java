package com.ZepngLin.dao;

import com.ZepngLin.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id = #{id}")
    Member findById(int id);
}
