package org.service;

import java.util.List;

import org.entity.Seckill;

public interface SeckillService {
	//询所有秒杀记录
	List<Seckill> getSeckillList(); 
	//秒杀开启是输出秒杀接口的地址,否则输出系统时间和秒杀时间
	Seckill getById(long seckillId);
	//执行秒杀后的操作
	
}
