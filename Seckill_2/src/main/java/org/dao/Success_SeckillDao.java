package org.dao;

import org.apache.ibatis.annotations.Param;
import org.entity.Success_Seckill;

/*
 * 秒杀商品的详情页持久层的实现接口类
 * */
public interface Success_SeckillDao {
	//插入id和用户电话
	int insertSuccessKill(@Param("seckillId")long seckillId,
			@Param("userPhone")long userPhone);
	//查询秒杀商品的用户的电话号
	//根据id查询SuccessKilled并携带Seckill实体
	Success_Seckill selectByIdSeckill(@Param("seckillId")long seckillId,
			@Param("userPhone")long userPhone);
}
