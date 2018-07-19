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
	private int clothTypeId; // 不为空，实在没有种类就是其他
	@NotNull
	private String clothName;
	@NotNull
	private double price; // 某种衣服的清洗价格
	private String remark; // 有些特殊情况需要照顾的
	@NotNull
	private int priority;	//优先级 

	public int getClothId() {
		return clothId;
	}

	public void setClothId(int clothId) {
		this.clothId = clothId;
	}

	public int getClothTypeId() {
		return clothTypeId;
	}

	public void setClothTypeId(int clothTypeId) {
		this.clothTypeId = clothTypeId;
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

	

	public Cloth(@NotNull int clothTypeId, @NotNull String clothName, @NotNull double price, String remark,
			int priority) {
		super();
		this.clothTypeId = clothTypeId;
		this.clothName = clothName;
		this.price = price;
		this.remark = remark;
		this.priority = priority;
	}

	public Cloth() {
		super();
	}
	
	public Cloth(@NotNull int clothTypeId, @NotNull String clothName, @NotNull double price) {
		super();
		this.clothTypeId = clothTypeId;
		this.clothName = clothName;
		this.price = price;
		this.priority = 1;
	}

	@Override
	public String toString() {
		return "Cloth [clothId=" + clothId + ", clothTypeId=" + clothTypeId + ", clothName=" + clothName + ", price="
				+ price + ", remark=" + remark + ", priority=" + priority + "]";
	}

}
