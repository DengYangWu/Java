package com.system.mapper;


import com.system.po.UserloginCustom;

public interface UserloginMapperCustom {
    UserloginCustom findOneByName(String name) throws Exception;

}