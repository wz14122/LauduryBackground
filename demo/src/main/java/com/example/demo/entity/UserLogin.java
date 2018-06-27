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
	private int userLogin_Id;
	@NotNull
	private int u_Id; // User表主键

	@Column(length = 50)
	private String lastLoginIp;
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;

	@Column(length = 50)
	private String lastFailLoginIP;
	@Temporal(TemporalType.DATE)
	private Date lastFailLoginDate;

	public int getUserLogin_Id() {
		return userLogin_Id;
	}

	public void setUserLogin_Id(int userLogin_Id) {
		this.userLogin_Id = userLogin_Id;
	}

	public int getU_Id() {
		return u_Id;
	}

	public void setU_Id(int u_Id) {
		this.u_Id = u_Id;
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

	public UserLogin(@NotNull int u_Id, String lastLoginIp, Date lastLoginDate, String lastFailLoginIP,
			Date lastFailLoginDate) {
		super();
		this.u_Id = u_Id;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginDate = lastLoginDate;
		this.lastFailLoginIP = lastFailLoginIP;
		this.lastFailLoginDate = lastFailLoginDate;
	}

	@Override
	public String toString() {
		return "UserLogin [userLogin_Id=" + userLogin_Id + ", u_Id=" + u_Id + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginDate=" + lastLoginDate + ", lastFailLoginIP=" + lastFailLoginIP + ", lastFailLoginDate="
				+ lastFailLoginDate + "]";
	}

}
