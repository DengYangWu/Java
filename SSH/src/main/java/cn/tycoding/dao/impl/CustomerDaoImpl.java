package cn.tycoding.dao.impl;

import cn.tycoding.dao.CustomerDao;
import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author huys
 * @date 18-3-8下午6:50
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    /**
     * 保存信息的方法
     */
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    /**
     * 根据id查询
     */
    public Customer findById(int cid) {
        return this.getHibernateTemplate().get(Customer.class, cid);
    }

    /**
     * 根据id删除
     */
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    /**
     * 更新信息
     */
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    /**
     * 分页查询的方法
     */
    public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        PageBean<Customer> page = new PageBean<Customer>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);

        //先查询总记录数 select count(*)
        criteria.setProjection(Projections.rowCount());
        List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
        if (list != null && list.size() > 0) {
            int totalCount = list.get(0).intValue();
            //总记录数
            page.setTotalCount(totalCount);
        }

        //要吧select count(*) 先清空 变成select *...
        criteria.setProjection(null);

        //提供分页查询
        List<Customer> beanList = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1) * pageSize, pageSize);

        //分页查询的数据，每页显示的数据，使用limit
        page.setBeanList(beanList);

        return page;
    }
}
