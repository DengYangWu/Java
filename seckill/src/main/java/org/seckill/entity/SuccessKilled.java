package org.seckill.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SuccessKilled {

    /**
     * 一个秒杀seckill对应多个成功记录
     */

    private long seckillId;

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






	private long userPhone;

    private short state;

    private Date createTime;
    
    private Seckill seckill;

	public Seckill getSeckill() {
		return seckill;
	}



	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + ", seckill=" + seckill + ", getSeckillId()=" + getSeckillId()
				+ ", getUserPhone()=" + getUserPhone() + ", getState()=" + getState() + ", getCreateTime()="
				+ getCreateTime() + ", getSeckill()=" + getSeckill() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}



	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	



}