package org.dto;

import java.io.Serializable;

/*
 * 暴露秒杀地址
 * */
public class Exposer implements Serializable{
    public boolean isExposed() {
		return exposed;
	}
	//是否暴露
	private boolean exposed;
	//加密措施
	private String md5;
	//秒杀商品id
	private long seckillId;
	//系统时间
	private long now;
	//秒杀开启时间
	private long start;
	//秒杀结束时间
	private long end;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//java的序列化机制
	private static final long serialVersionUID = 7602244494037452541L;
	


	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
				+ start + ", end=" + end + ", isExposed()=" + isExposed() + ", getMd5()=" + getMd5()
				+ ", getSeckillId()=" + getSeckillId() + ", getNow()=" + getNow() + ", getStart()=" + getStart()
				+ ", getEnd()=" + getEnd() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public long getNow() {
		return now;
	}
	public void setNow(long now) {
		this.now = now;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	
	public Exposer(boolean exposed,String md5,long seckillId) {
		this.exposed=exposed;
		this.md5=md5;
		this.seckillId=seckillId;
	}
	public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
		this.exposed=exposed;
		this.seckillId=seckillId;
		this.now=now;
		this.start=start;
		this.end=end;
	}
	public Exposer(boolean exposed,long seckillId) {
		this.exposed=exposed;
		this.seckillId=seckillId;
	}
}
