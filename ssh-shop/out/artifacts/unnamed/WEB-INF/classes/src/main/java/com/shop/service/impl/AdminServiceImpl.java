package com.shop.service.impl;

import com.shop.dao.AdminDao;
import com.shop.model.Admin;
import com.shop.model.User;
import com.shop.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;
//    @Resource
//    private UserDao userDao;
    @Override
    public void updateUser(User user) {

    }

    @Override
    public Admin checkUser(Admin admin) {
        return null;
    }

    @Override
    public void deleteUser(Integer uid) {

    }

    @Override
    public List<User> findUser(Integer page) {
        return null;
    }

    @Override
    public Integer countUser() {
        return null;
    }

    @Override
    public User findUserByUid(Integer uid) {
        return null;
    }

    // 根据管理员的aid查询管理员信息
    @Override
    public Admin findAdminByAid(Integer aid) {
        return adminDao.findOne(aid);
    }
}
