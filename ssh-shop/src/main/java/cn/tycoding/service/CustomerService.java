package cn.tycoding.service;

import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    void save(Customer customer);
    Customer findById(int cid);
    void delete(Customer customer);
    void update(Customer customer);
    PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
