package com.shop.dao.impl;

import com.shop.dao.AdminDao;
import com.shop.model.Admin;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;



@Repository("adminDao")
@SuppressWarnings("all")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
    @Override
    public Admin findByAdminnameAndPassword(String username, String password) {
        String hql = "from Admin a where a.usrname = ? and a.password = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0,username);
        query.setParameter(1,password);
        return (Admin) query.uniqueResult();
    }
    @Override
    public Admin findOne(Integer uid) {
        String hql = "from Admin where uid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0,uid);
        return (Admin)query.uniqueResult();
    }
}
