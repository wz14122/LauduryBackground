package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer u_Id;
	private String username;
	private String password;

	public Integer getId() {
		return u_Id;
	}

	public void setId(Integer id) {
		this.u_Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer id, String username, String password) {
		super();
		this.u_Id = id;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + u_Id + ", username=" + username + ", password=" + password + "]";
	}

}
