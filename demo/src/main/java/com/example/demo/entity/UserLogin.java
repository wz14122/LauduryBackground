package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author wz 登录状态
 */
@Entity
public class UserLogin {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private int userLoginId;
	@NotNull
	private int userId; // User表主键

	@Column(length = 50)
	private String lastLoginIp;
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;

	@Column(length = 50)
	private String lastFailLoginIP;
	@Temporal(TemporalType.DATE)
	private Date lastFailLoginDate;

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastFailLoginIP() {
		return lastFailLoginIP;
	}

	public void setLastFailLoginIP(String lastFailLoginIP) {
		this.lastFailLoginIP = lastFailLoginIP;
	}

	public Date getLastFailLoginDate() {
		return lastFailLoginDate;
	}

	public void setLastFailLoginDate(Date lastFailLoginDate) {
		this.lastFailLoginDate = lastFailLoginDate;
	}

	public UserLogin() {
		super();
	}

	public UserLogin(@NotNull int userId, String lastLoginIp, Date lastLoginDate, String lastFailLoginIP,
			Date lastFailLoginDate) {
		super();
		this.userId = userId;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginDate = lastLoginDate;
		this.lastFailLoginIP = lastFailLoginIP;
		this.lastFailLoginDate = lastFailLoginDate;
	}

	@Override
	public String toString() {
		return "UserLogin [userLoginId=" + userLoginId + ", userId=" + userId + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginDate=" + lastLoginDate + ", lastFailLoginIP=" + lastFailLoginIP + ", lastFailLoginDate="
				+ lastFailLoginDate + "]";
	}

}
