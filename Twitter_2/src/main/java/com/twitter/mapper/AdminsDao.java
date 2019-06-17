package com.twitter.mapper;

import com.twitter.pojo.Admins;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsDao {
    int insertAll(Admins admins);


    Admins findByName(String name);

    Admins findByNamePwd(@Param("aname")String aname,@Param("apwd")String apwd);
}
