package org.enumeration;

/*
 * 秒杀枚举
 * 用来实现秒杀当中返回的实例和反馈信息等
 * */
public enum SeckillEnum {
	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
	REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据更改"),
    NOT_LOGIN(-4, "未登陆");
	//秒杀状态
	private int state;
	//秒杀标识符
	private String stateinfo;
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
	SeckillEnum(int state,String stateinfo) {
		this.state=state;
		this.stateinfo=stateinfo;
	}
	
	//静态方法
	private static SeckillEnum stateOf(int index) {
		for(SeckillEnum seckillEnum:values()) {
			if(seckillEnum.getState() == index) {
				return seckillEnum;
			}
		}
		return null;
	}
}
