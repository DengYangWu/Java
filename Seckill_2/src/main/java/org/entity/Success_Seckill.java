package org.entity;

import java.util.Date;

/*
 * 秒杀详情表
 * */
public class Success_Seckill {
	//详情主键
	private long seckillId;
	//用户主键电话号
	private long userPhone;
	@Override
	public String toString() {
		return "Success_Seckill [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + ", seckill=" + seckill + ", getSeckillId()=" + getSeckillId()
				+ ", getUserPhone()=" + getUserPhone() + ", getState()=" + getState() + ", getCreateTime()="
				+ getCreateTime() + ", getSeckill()=" + getSeckill() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	//秒杀数量-1为秒杀成功，0为未秒杀成功
	private short state;
	//秒杀完成之后的时间
	private Date createTime;
	//关联seckill表
	private Seckill seckill;
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	public short getState() {
		return state;
	}
	public void setState(short state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Seckill getSeckill() {
		return seckill;
	}
	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}
}
