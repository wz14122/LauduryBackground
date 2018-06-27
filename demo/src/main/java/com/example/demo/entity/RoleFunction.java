package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class RoleFunction {

	@Id
	private Integer roleFunction_Id;

	@NotNull
	private Integer role_Id;
	@NotNull
	private Integer function_Id;
	
	@Column(length = 100)
	private String description;

	public Integer getRoleFunction_Id() {
		return roleFunction_Id;
	}

	public void setRoleFunction_Id(Integer roleFunction_Id) {
		this.roleFunction_Id = roleFunction_Id;
	}

	public Integer getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}

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

	public RoleFunction(@NotNull Integer role_Id, @NotNull Integer function_Id, String description) {
		super();
		this.role_Id = role_Id;
		this.function_Id = function_Id;
		this.description = description;
	}

	public RoleFunction() {
		super();
	}

	@Override
	public String toString() {
		return "RoleFunction [roleFunction_Id=" + roleFunction_Id + ", role_Id=" + role_Id + ", function_Id="
				+ function_Id + ", description=" + description + "]";
	}

}
