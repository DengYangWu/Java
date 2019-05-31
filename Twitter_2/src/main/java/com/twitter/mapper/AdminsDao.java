package com.twitter.mapper;

import com.twitter.pojo.Admins;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsDao {
    int insertAll(Admins admins);


    Admins findByName(String name);


}
