package cn.tycoding.dao;

import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;
import java.util.Map;

/**
 * @author huys
 * @date 18-3-8下午6:50
 */
public interface CustomerDao {

    Customer findById(int cid);

    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
