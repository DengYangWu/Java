package com.giit.www.system.dao;

import com.giit.www.entity.LimitTheLogin;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface LimitTheLoginDao {
    //插入登录次数
    int insertCount(LimitTheLogin limitTheLogin);
    //更新
    int updateAll(int countlogin,
                            Date datelogin,
                            int iduser);
    //用户登录计数
    int findAllId(int iduser);
    //用户登录时间
    LimitTheLogin findAllLoginDate(int iduser);

}
