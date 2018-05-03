package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "wechat_id" }) })
public class Customer {

	@Id
	@GeneratedValue
	private int customer_id;
	@NotNull
	@Column(length = 20)
	private String customer_name;
	@NotNull
	private byte customer_gender; // 保存用户性别，为以后数据分析做准备。
	private String wechat_id;
	private String address; // 用户住址可为空
	private String remark; // 用户其他信息

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public byte getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(byte customer_gender) {
		this.customer_gender = customer_gender;
	}

	public String getWechat_id() {
		return wechat_id;
	}

	public void setWechat_id(String wechat_id) {
		this.wechat_id = wechat_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Customer(@NotNull String customer_name, @NotNull byte customer_gender, String wechat_id, String address,
			String remark) {
		super();
		this.customer_name = customer_name;
		this.customer_gender = customer_gender;
		this.wechat_id = wechat_id;
		this.address = address;
		this.remark = remark;
	}

	public Customer(@NotNull String customer_name, @NotNull byte customer_gender) {
		this(customer_name, customer_gender, "微信未添加", "地址未添加", "无备注");
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_gender="
				+ customer_gender + ", wechat_id=" + wechat_id + ", address=" + address + ", remark=" + remark + "]";
	}

}
