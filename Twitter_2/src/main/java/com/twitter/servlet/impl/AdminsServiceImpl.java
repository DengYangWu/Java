package com.twitter.servlet.impl;

import com.twitter.mapper.AdminsDao;
import com.twitter.pojo.Admins;
import com.twitter.servlet.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsDao adminsDao;

    public Admins findById(Admins admins){
        admins=adminsDao.findById(admins);
        return admins;
    }

}
