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


    @Override
    public int insertAll(Admins admins) {
        return adminsDao.insertAll(admins);
    }

    @Override
    public Admins findByName(String name) {
        Admins admins = adminsDao.findByName(name);
        return admins;
    }

    @Override
    public Admins findByNamePwd(String aname, String apwd) {
        return adminsDao.findByNamePwd(aname,apwd);
    }

}
