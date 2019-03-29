package org.entity;

import java.sql.Date;

/*
 * 秒杀实体类
 * */
public class Seckill {
	//主键id
	private long seckillId;
	//秒杀名称
	private String name;
	//秒杀商品数量
	private int number;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//创建时间
	private Date createTime;
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + ", getSeckillId()=" + getSeckillId()
				+ ", getName()=" + getName() + ", getNumber()=" + getNumber() + ", getStartTime()=" + getStartTime()
				+ ", getEndTime()=" + getEndTime() + ", getCreateTime()=" + getCreateTime() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
