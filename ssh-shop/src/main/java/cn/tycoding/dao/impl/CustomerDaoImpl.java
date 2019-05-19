package cn.tycoding.dao.impl;

import cn.tycoding.dao.CustomerDao;
import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Customer findById(int cid) {
        return this.getHibernateTemplate().get(Customer.class,cid);
    }

    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    //分页查询的方法
    @Override
    public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        PageBean<Customer> pageBean=new PageBean<Customer>();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        //先查询总记录数， select count(*)
        criteria.setProjection(Projections.rowCount());
        List<Number> list=(List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
        if(list!=null && list.size()>0){
            int totalCount = list.get(0).intValue();  //intValue()是把Integer对象类型变成int的基础数据类型
            //总记录数
            pageBean.setTotalCount(totalCount);
        }
        //要吧select count(*) 先清空 变成select *...
        criteria.setProjection(null);

        //提供分页查询
        List<Customer> beanList = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1) * pageSize, pageSize);

        //分页查询的数据，每页显示的数据，使用limit
        pageBean.setBeanList(beanList);

        return pageBean;
    }
}
