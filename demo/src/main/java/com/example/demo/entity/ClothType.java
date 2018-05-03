package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author wz-pc
 * 大类：包括衣服、鞋子等等
 */
@Entity
public class ClothType {

	@Id
	@GeneratedValue
	private int clothType_id;
	@NotNull
	private String clothType_name;
	@NotNull
	private int clothType_code;
	@NotNull
	private int state;

	public int getCloth_id() {
		return clothType_id;
	}

	public void setCloth_id(int cloth_id) {
		this.clothType_id = cloth_id;
	}

	public String getClothType_name() {
		return clothType_name;
	}

	public void setClothType_name(String clothType_name) {
		this.clothType_name = clothType_name;
	}

	public int getClothType_code() {
		return clothType_code;
	}

	public void setClothType_code(int clothType_code) {
		this.clothType_code = clothType_code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ClothType() {
		super();
	}

	/**
	 * @param clothType_name 衣服类型名称
	 * @param clothType_code 类型码
	 * @return 默认类型对象状态为1
	 */
	public ClothType(@NotNull String clothType_name, @NotNull int clothType_code) {
		this(clothType_name, clothType_code, 1);
	}

	public ClothType(@NotNull String clothType_name, @NotNull int clothType_code, @NotNull int state) {
		super();
		this.clothType_name = clothType_name;
		this.clothType_code = clothType_code;
		this.state = state;
	}

	@Override
	public String toString() {
		return "ClothType [cloth_id=" + clothType_id + ", clothType_name=" + clothType_name + ", clothType_code="
				+ clothType_code + ", state=" + state + "]";
	}

}
