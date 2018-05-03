package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue
	private int uI_Id;
	@NotNull
	private int uId;
	private String loginIp;
	@Temporal(TemporalType.DATE)
	private Date loginDate;

	public int getId() {
		return uI_Id;
	}

	public void setId(int id) {
		this.uI_Id = id;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public UserInfo(@NotNull int uId, String loginIp, Date loginDate) {
		super();
		this.uId = uId;
		this.loginIp = loginIp;
		this.loginDate = loginDate;
	}

	public UserInfo() {
		super();
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + uI_Id + ", uId=" + uId + ", loginIp=" + loginIp + ", loginDate=" + loginDate + "]";
	}

}
