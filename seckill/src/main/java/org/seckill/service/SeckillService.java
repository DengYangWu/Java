package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

	//查询单个的秒杀记录
	Seckill getById(Long seckillId);
	//秒杀开启是输出秒杀接口的地址,否则输出系统时间和秒杀时间
	Exposer exportSeckillUrl(Long seckillId);
	//执行秒杀后的操作
	SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) 
			throws SeckillException,RepeatKillException,SeckillCloseException;
	
}
