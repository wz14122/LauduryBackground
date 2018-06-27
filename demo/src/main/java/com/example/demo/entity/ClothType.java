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
	private String clothTypeName;
	@NotNull
	private int clothTypeCode;
	@NotNull
	private int state;

	public int getClothType_id() {
		return clothType_id;
	}

	public void setClothType_id(int clothType_id) {
		this.clothType_id = clothType_id;
	}

	public String getClothTypeName() {
		return clothTypeName;
	}

	public void setClothTypeName(String clothTypeName) {
		this.clothTypeName = clothTypeName;
	}

	public int getClothTypeCode() {
		return clothTypeCode;
	}

	public void setClothTypeCode(int clothTypeCode) {
		this.clothTypeCode = clothTypeCode;
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
	public ClothType(@NotNull String clothTypeName, @NotNull int clothTypeCode) {
		this(clothTypeName, clothTypeCode, 1);
	}

	public ClothType(@NotNull String clothTypeName, @NotNull int clothTypeCode, @NotNull int state) {
		super();
		this.clothTypeName = clothTypeName;
		this.clothTypeCode = clothTypeCode;
		this.state = state;
	}

	@Override
	public String toString() {
		return "ClothType [cloth_id=" + clothType_id + ", clothTypeName=" + clothTypeName + ", clothTypeCode="
				+ clothTypeCode + ", state=" + state + "]";
	}

}
