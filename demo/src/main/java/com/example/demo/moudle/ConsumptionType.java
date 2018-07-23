package com.example.demo.moudle;

/**
 * @author wz
 * 订单类型:清洗，修理，制作
 */
public enum ConsumptionType {
	
	CLEANING(1), //清洗
	REPAIR(2),   //修理
	MANUFACTURE(3)  //制作
	;
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private ConsumptionType(int type) {
		this.type = type;
	}
	

}
