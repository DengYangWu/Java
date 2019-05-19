package com.shop.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

// 泛型BaseDao工具类
//若对每张表都编写一套增删改差方法未必有些麻烦，并且不符合编码的基本准则。
// 一般，我们可以将这些功能的所公用的部分封装为一个对象，
// 或者是类，此类是所有DAO的基类，可以称为：BaseDAO。
public interface BaseDao<T> {
    public Serializable save(T o);
    public void delete(Serializable id);

    public void delete(T o);

    public void update(T o);

    public void saveOrUpdate(T o);

    public T get(Serializable id);

    public List<T> find(String hql);

    public List<T> find(String hql, Map<String, Object> params);

    public List<T> find(String hql, int page, int rows);

    public List<T> find(String hql, Map<String, Object> params, int page, int rows);

    public Integer count(String hql);

    public Integer count(String hql, Integer id);

    public Integer count(String hql, Map<String, Object> params);

    public int executeHql(String hql);

    public int executeHql(String hql, Map<String, Object> params);

    Integer findByUid(Integer uid);

    Integer findTicketByCid(Integer cid);
}