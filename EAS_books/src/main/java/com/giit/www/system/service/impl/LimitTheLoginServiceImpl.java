package com.giit.www.system.service.impl;


import com.giit.www.entity.LimitTheLogin;
import com.giit.www.system.dao.LimitTheLoginDao;
import com.giit.www.system.service.LimitTheLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LimitTheLoginServiceImpl implements LimitTheLoginService {
    @Resource
    private LimitTheLoginDao limitTheLoginDao;

    public int insertCount(LimitTheLogin limitTheLogin){

        return limitTheLoginDao.insertCount(limitTheLogin);
    }
    public int updateAll(int count, Date datelogn, int whereid){
        return limitTheLoginDao.updateAll(count,datelogn,whereid);
    }
    public int findAllId(int id){
        return limitTheLoginDao.findAllId(id);
    }
    public String findAllLoginDate(int iduser){
       return findAllLoginDate(iduser);
    }
}
