package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author wz 登录状态
 */
@Entity
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userLoginId;
	@NotNull
	private String userId; // User表主键

	@Column(length = 50)
	private String loginIp;
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginDate;

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public UserLogin() {
		super();
	}

	public UserLogin(@NotNull String userId, String loginIp, Date loginDate) {
		super();
		this.userId = userId;
		this.loginIp = loginIp;
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "UserLogin [userLoginId=" + userLoginId + ", userId=" + userId + ", loginIp=" + loginIp + ", loginDate="
				+ loginDate + "]";
	}

}
