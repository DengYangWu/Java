package org.dto;

import java.io.Serializable;

import org.entity.Success_Seckill;
import org.enumeration.SeckillEnum;

/*
 * 实现秒杀执行后的炒作
 * */
public class SeckillExecution implements Serializable{
	private static final long serialVersionUID = 2160123709223365015L;
	//执行秒杀ID
	private long seckillId;
	//结果状态
	private int state;
	//结果状态标识符
	private String stateinfo;
	//执行秒杀完后，返回所有结果
	private Success_Seckill success_Seckill;

	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateinfo() {
		return stateinfo;
	}
	public void setStateinfo(String stateinfo) {
		this.stateinfo = stateinfo;
	}
	public Success_Seckill getSuccess_Seckill() {
		return success_Seckill;
	}
	public void setSuccess_Seckill(Success_Seckill success_Seckill) {
		this.success_Seckill = success_Seckill;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SecillExecution [seckillId=" + seckillId + ", state=" + state + ", stateinfo=" + stateinfo
				+ ", success_Seckill=" + success_Seckill + ", getSeckillId()=" + getSeckillId() + ", getState()="
				+ getState() + ", getStateinfo()=" + getStateinfo() + ", getSuccess_Seckill()=" + getSuccess_Seckill()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	//构造函数
	public SeckillExecution(long seckillId,SeckillEnum seckillEnum){
		this.seckillId=seckillId;
		this.state=seckillEnum.getState();
		this.stateinfo=seckillEnum.getStateinfo();
	}
	public SeckillExecution(long seckillId,String stateinfo,SeckillEnum seckillEnum) {
		this.seckillId=seckillId;
		this.stateinfo=stateinfo;
		this.state=seckillEnum.getState();
		this.stateinfo=seckillEnum.getStateinfo();
	}
	public SeckillExecution(long seckillId,SeckillEnum seckillEnum,Success_Seckill success_Seckill) {
		this.seckillId=seckillId;
		this.state=seckillEnum.getState();
		this.stateinfo=seckillEnum.getStateinfo();
		this.success_Seckill=success_Seckill;
	}
}
