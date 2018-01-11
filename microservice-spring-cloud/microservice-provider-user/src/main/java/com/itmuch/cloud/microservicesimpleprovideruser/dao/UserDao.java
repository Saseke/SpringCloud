package com.itmuch.cloud.microservicesimpleprovideruser.dao;

import com.itmuch.cloud.microservicesimpleprovideruser.obj.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 控制主体
 */
@Repository
public interface UserDao {
    @Select("select * from user where id=#{id}")
    User findById(long id);
}
