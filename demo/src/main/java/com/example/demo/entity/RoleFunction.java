package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class RoleFunction {

	@Id
	private Integer roleFunctionId;

	@NotNull
	private Integer roleId;
	@NotNull
	private Integer functionId;

	@Column(length = 100)
	private String description;

	public Integer getRoleFunctionId() {
		return roleFunctionId;
	}

	public void setRoleFunctionId(Integer roleFunctionId) {
		this.roleFunctionId = roleFunctionId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RoleFunction(@NotNull Integer roleId, @NotNull Integer functionId, String description) {
		super();
		this.roleId = roleId;
		this.functionId = functionId;
		this.description = description;
	}

	public RoleFunction() {
		super();
	}

	@Override
	public String toString() {
		return "RoleFunction [roleFunctionId=" + roleFunctionId + ", roleId=" + roleId + ", functionId=" + functionId
				+ ", description=" + description + "]";
	}

}
