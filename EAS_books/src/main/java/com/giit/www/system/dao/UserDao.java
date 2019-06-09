package com.giit.www.system.dao;

import com.giit.www.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
     User login(@Param("user_id")String id,@Param("password")String password);
     User findName(String username);
     User findByUsername(String username);
     int findNameById(String username);

}
