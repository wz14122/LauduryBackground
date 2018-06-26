package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer u_Id;

	@NotNull
	private int role;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private boolean enabled;

	private int failLoginTimes;

	public Integer getU_Id() {
		return u_Id;
	}

	public void setU_Id(Integer u_Id) {
		this.u_Id = u_Id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFailLoginTimes() {
		return failLoginTimes;
	}

	public void setFailLoginTimes(int failLoginTimes) {
		this.failLoginTimes = failLoginTimes;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User(@NotNull int role, @NotNull String username, @NotNull String password, @NotNull boolean enabled,
			int failLoginTimes) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.failLoginTimes = failLoginTimes;
	}

	public User() {
		super();
	}

	public User(Integer u_Id, @NotNull int role, @NotNull String username, @NotNull String password,
			@NotNull boolean enabled, int failLoginTimes) {
		super();
		this.u_Id = u_Id;
		this.role = role;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.failLoginTimes = failLoginTimes;
	}

}
