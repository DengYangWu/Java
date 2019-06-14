package com.giit.www.system.service;

import com.giit.www.entity.LimitTheLogin;

import java.util.Date;

public interface LimitTheLoginService {
    int insertCount(LimitTheLogin limitTheLogin);
    int updateAll(int count, Date datelogn, int whereid);
    //用户登录计数
    int findAllId(int iduser);
    String findAllLoginDate(int iduser);
}
