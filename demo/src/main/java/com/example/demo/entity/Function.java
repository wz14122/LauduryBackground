package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Function implements Cloneable {

	@Id
	@GeneratedValue
	private Integer function_Id;

	@Column(length = 20)
	private String description;
	@NotNull
	private String functionUrl;

	public Integer getFunction_Id() {
		return function_Id;
	}

	public void setFunction_Id(Integer function_Id) {
		this.function_Id = function_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public Function(String description, String functionUrl) {
		super();
		this.description = description;
		this.functionUrl = functionUrl;
	}

	public Function() {
		super();
	}

	@Override
	public String toString() {
		return "Function [function_Id=" + function_Id + ", description=" + description + ", functionUrl=" + functionUrl
				+ "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
