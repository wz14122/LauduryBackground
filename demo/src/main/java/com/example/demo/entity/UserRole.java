package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserRole implements Cloneable {

	@Id
	private Integer userRole_Id;
	@NotNull
	private Integer u_Id;
	@NotNull
	private Integer role_Id;
	@Column(length = 100)
	private String description;

	public Integer getUserRole_Id() {
		return userRole_Id;
	}

	public void setUserRole_Id(Integer userRole_Id) {
		this.userRole_Id = userRole_Id;
	}

	public Integer getU_Id() {
		return u_Id;
	}

	public void setU_Id(Integer u_Id) {
		this.u_Id = u_Id;
	}

	public Integer getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserRole(@NotNull Integer u_Id, @NotNull Integer role_Id, String description) {
		super();
		this.u_Id = u_Id;
		this.role_Id = role_Id;
		this.description = description;
	}

	public UserRole() {
		super();
	}

	@Override
	public String toString() {
		return "UserRole [userRole_Id=" + userRole_Id + ", u_Id=" + u_Id + ", role_Id=" + role_Id + ", description="
				+ description + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
