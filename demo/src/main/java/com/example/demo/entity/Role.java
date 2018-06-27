package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

	@Id
	private Integer role_Id;

	@NotNull
	@Column(length = 20)
	private String roleName;
	@Column(length = 100)
	private String description;

	public Integer getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Role(@NotNull String roleName, String description) {
		super();
		this.roleName = roleName;
		this.description = description;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [role_Id=" + role_Id + ", roleName=" + roleName + ", description=" + description + "]";
	}

}
