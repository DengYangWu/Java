package org.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.entity.Seckill;

/*
 * seckill的持久层接口实现类
 * */
public interface SeckillDao {
	//判断秒杀返回为1，就更新秒杀数量
	int killNumber(@Param("seckillId")long seckillId,
			@Param("killTime")Date killTime);
	
	//根据Id查询秒杀对象
	Seckill selectById(long seckillId);
	
	//查询所有商品信息
	List<Seckill> selectSeckillAll(@Param("offset")int offset,
			@Param("limit")int limit);
	
}
