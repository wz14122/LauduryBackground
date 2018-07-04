package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private String u_Id;

	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private boolean enabled;

	private int failLoginTimes;

	public String getU_Id() {
		return u_Id;
	}

	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
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

	public User(@NotNull String username, @NotNull String password) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
		this.failLoginTimes = 0;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [u_Id=" + u_Id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", failLoginTimes=" + failLoginTimes + "]";
	}

}
