package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserRole implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleId;
	@NotNull
	private String userId;
	@NotNull
	private Integer roleId;
	@Column(length = 100)
	private String description;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserRole(@NotNull String userId, @NotNull Integer roleId, String description) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.description = description;
	}

	public UserRole() {
		super();
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + ", description="
				+ description + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
