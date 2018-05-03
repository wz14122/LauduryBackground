package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author wz-pc 小类
 */
@Entity
public class Cloth {

	@Id
	@GeneratedValue
	private int cloth_id;
	@NotNull
	private int clothType_id; // 不为空，实在没有种类就是其他
	@NotNull
	private String cloth_name;
	@NotNull
	private double price; // 某种衣服的清洗价格
	private String remark; // 有些特殊情况需要照顾的

	public int getCloth_id() {
		return cloth_id;
	}

	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}

	public int getClothType_id() {
		return clothType_id;
	}

	public void setClothType_id(int clothType_id) {
		this.clothType_id = clothType_id;
	}

	public String getCloth_name() {
		return cloth_name;
	}

	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
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

	public Cloth(@NotNull int clothType_id, @NotNull String cloth_name, @NotNull double price, String remark) {
		super();
		this.clothType_id = clothType_id;
		this.cloth_name = cloth_name;
		this.price = price;
		this.remark = remark;
	}

	public Cloth() {
		super();
	}

	@Override
	public String toString() {
		return "Cloth [cloth_id=" + cloth_id + ", clothType_id=" + clothType_id + ", cloth_name=" + cloth_name
				+ ", price=" + price + ", remark=" + remark + "]";
	}

}
