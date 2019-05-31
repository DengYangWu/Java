package com.twitter.servlet;

import com.twitter.pojo.Admins;

public interface AdminsService {
    int insertAll(Admins admins);
    Admins findByName(String name);
}
