package com.twitter.servlet;

import com.twitter.pojo.Admins;

public interface AdminsService {
    Admins findById(Admins admins);
}
