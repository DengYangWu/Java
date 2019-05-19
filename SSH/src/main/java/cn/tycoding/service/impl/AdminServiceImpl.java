package cn.tycoding.service.impl;

import cn.tycoding.dao.AdminDao;
import cn.tycoding.pojo.Admin;
import cn.tycoding.service.AdminService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huys
 * @date 18-3-10下午6:02
 */
@Transactional
public class AdminServiceImpl implements AdminService {

    /**
     * 注入
     */
    private AdminDao adminDao;
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    /**
     * 登录的方法
     */
    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
