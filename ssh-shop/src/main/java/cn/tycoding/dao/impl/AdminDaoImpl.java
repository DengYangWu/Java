package cn.tycoding.dao.impl;

import cn.tycoding.dao.AdminDao;
import cn.tycoding.pojo.Admin;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.awt.image.RescaleOp;
import java.util.List;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

    //登录验证
    @Override
    public Admin login(Admin admin) {
        //使用QBC的查询
        DetachedCriteria criteria = DetachedCriteria.forClass(Admin.class);
        criteria.add(Restrictions.eq("adminname",admin.getAdminname()));
        criteria.add(Restrictions.eq("password",admin.getPassword()));
        //查询
        List<Admin> list = (List<Admin>) this.getHibernateTemplate().findByCriteria(criteria);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
