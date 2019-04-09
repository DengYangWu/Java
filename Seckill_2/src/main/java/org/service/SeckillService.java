package org.service;

import java.util.List;

import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.entity.Seckill;
import org.error.RepeatKillException;
import org.error.SeckillCloseException;
import org.error.SeckillException;


public interface SeckillService {
	//询所有秒杀记录
	List<Seckill> getSeckillList(); 
	//根据ID查询秒杀记录
	Seckill getById(Long seckillId);
	//秒杀开启是输出秒杀接口的地址,否则输出系统时间和秒杀时间
	Exposer exposerSeckillUrl(Long seckillId);
	//执行秒杀后的操作
	SeckillExecution seckillExecution(Long seckillId, Long userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;
    
}
