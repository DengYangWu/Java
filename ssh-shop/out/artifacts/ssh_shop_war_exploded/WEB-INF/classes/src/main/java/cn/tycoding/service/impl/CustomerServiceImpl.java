package cn.tycoding.service.impl;

import cn.tycoding.dao.CustomerDao;
import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerServiceImpl implements CustomerService {

    //注入
    private CustomerDao customerDao;
    //更新方法
    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }
    //根据id查询
    @Override
    public Customer findById(int cid) {
        return customerDao.findById(cid);
    }
    //删除方法
    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }
    //修改方法
    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    //分页查询
    @Override
    public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        return customerDao.findByPage(pageCode,pageSize,criteria);
    }
}
