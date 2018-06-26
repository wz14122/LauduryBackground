package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	private int uI_Id;
	@NotNull
	private int uId;	//User表主键

	private String lastLoginIp;
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;

	private String lastFailLoginIP;
	@Temporal(TemporalType.DATE)
	private Date lastFailLoginDate;

	public int getuI_Id() {
		return uI_Id;
	}

	public void setuI_Id(int uI_Id) {
		this.uI_Id = uI_Id;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public UserLogin(String lastLoginIp, Date lastLoginDate, String lastFailLoginIP, Date lastFailLoginDate) {
		super();
		this.lastLoginIp = lastLoginIp;
		this.lastLoginDate = lastLoginDate;
		this.lastFailLoginIP = lastFailLoginIP;
		this.lastFailLoginDate = lastFailLoginDate;
	}

	@Override
	public String toString() {
		return "UserLogin [uI_Id=" + uI_Id + ", uId=" + uId + ", lastLoginIp=" + lastLoginIp + ", lastLoginDate="
				+ lastLoginDate + ", lastFailLoginIP=" + lastFailLoginIP + ", lastFailLoginDate=" + lastFailLoginDate
				+ "]";
	}

}
