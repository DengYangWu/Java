package org.seckill.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

import java.io.Serializable;

/**
 * 封装秒杀执行后的结果
 * Created by wchb7 on 16-5-13.
 */

public class SeckillExecution implements Serializable {

    private static final long serialVersionUID = 2160123709223365015L;

    private long seckillId;

    /**
     * 秒杀执行结果状态
     */
    private int state;

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

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * 状态的标识
     */
    private String stateInfo;
    //当秒杀成功，把成功返回回去
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, String stateInfo) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.stateInfo = stateInfo;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

	public SeckillExecution(Long seckillId, SeckillStatEnum statEnum, SuccessKilled successKill) {
		// TODO Auto-generated constructor stub
        this.seckillId = seckillId;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
        this.successKilled = successKilled;
	}

}