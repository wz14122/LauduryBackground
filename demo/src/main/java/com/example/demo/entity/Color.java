package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * @author wz 颜色控制
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "type" }) })
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colorId; // id自动生成就是，没什么大问题
	@NotNull
	@Column(length = 20)
	private String type; // 红色 绿色 蓝色

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Color() {
		super();
	}

	public Color(@NotNull String type) {
		super();
		this.type = type;
	}

	@Override
	public String toString() {
		return "Color [colorId=" + colorId + ", type=" + type + "]";
	}

}
