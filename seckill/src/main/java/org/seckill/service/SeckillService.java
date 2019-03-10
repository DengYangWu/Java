package org.seckill.service;

import java.util.List;

import org.seckill.entity.Seckill;

/**
 * Created by wchb7 on 16-5-13.
 * 业务接口:站在"使用者"的角度设计接口
 * 1.方法的定义的粒度.2.参数.3.返回类型(return /异常)
 */
public interface SeckillService {
	/**
     * 查询所有秒杀记录
     *
     * @return
     */
	List<Seckill> getSeckillList();

	Seckill getById(Long seckillId);
}
