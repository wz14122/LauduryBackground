package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author wz-pc 小类
 */
@Entity
public class Cloth {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clothId;
	@NotNull
	private int clothTypeCode; // 不为空，实在没有种类就是其他
	@NotNull
	private String clothName;
	@NotNull
	private double price; // 某种衣服的清洗价格
	private String remark; // 有些特殊情况需要照顾的
	@NotNull
	private int priority; // 优先级
	private boolean state;

	private static final String REMARK = "";
	private static final int OTHER_TYPE = 0;
	private static final int BASIC_PRIORITY = 1;
	private static final boolean STATE = true;
	
	public int getClothId() {
		return clothId;
	}

	public void setClothId(int clothId) {
		this.clothId = clothId;
	}


	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public int getClothTypeCode() {
		return clothTypeCode;
	}

	public void setClothTypeCode(int clothTypeCode) {
		this.clothTypeCode = clothTypeCode;
	}

	public Cloth() {
		super();
	}

	public Cloth(@NotNull String clothName, @NotNull double price) {
		this(clothName, price, REMARK);
	}

	/**
	 * 0是其他
	 * 
	 * @param clothName
	 * @param price
	 * @param remark
	 */
	public Cloth(@NotNull String clothName, @NotNull double price, String remark) {
		this(OTHER_TYPE, clothName, price, remark, BASIC_PRIORITY, STATE);
	}

	public Cloth(@NotNull int clothTypeCode, @NotNull String clothName, @NotNull double price) {
		this(clothTypeCode, clothName, price, REMARK, BASIC_PRIORITY, STATE);
	}

	public Cloth(@NotNull int clothTypeCode, @NotNull String clothName, @NotNull double price, String remark,
			@NotNull int priority, boolean state) {
		super();
		this.clothTypeCode = clothTypeCode;
		this.clothName = clothName;
		this.price = price;
		this.remark = remark;
		this.priority = priority;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Cloth [clothId=" + clothId + ", clothTypeCode=" + clothTypeCode + ", clothName=" + clothName + ", price="
				+ price + ", remark=" + remark + ", priority=" + priority + "]";
	}

}
