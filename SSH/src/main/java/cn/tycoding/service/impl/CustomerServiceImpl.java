package cn.tycoding.service.impl;

import cn.tycoding.dao.CustomerDao;
import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author huys
 * @date 18-3-8下午6:51
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    //注入
    private CustomerDao customerDao;
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 保存信息的方法
     */
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    /**
     * 根据id查询
     */
    public Customer findById(int cid) {
        return customerDao.findById(cid);
    }

    /**
     * 根据id删除信息
     */
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    /**
     * 修改的方法
     */
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    /**
     * 分页查询
     */
    public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        return customerDao.findByPage(pageCode, pageSize, criteria);
    }
}
