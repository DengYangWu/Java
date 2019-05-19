package cn.tycoding.service.impl;


import cn.tycoding.dao.AdminDao;
import cn.tycoding.pojo.Admin;
import cn.tycoding.service.AdminService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AdminServiceImpl implements AdminService {

    //注入
    private AdminDao adminDao;

    //登陆方法
    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
