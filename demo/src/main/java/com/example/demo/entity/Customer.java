package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "wechatId" }) })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull
	@Column(length = 20)
	private String customerName;
	@NotNull
	private byte customerGender; // 保存用户性别，为以后数据分析做准备。
	private String wechatId;
	private String address; // 用户住址可为空
	private String remark; // 用户其他信息

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public byte getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(byte customerGender) {
		this.customerGender = customerGender;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
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

	public Customer(@NotNull String customerName, @NotNull byte customerGender, String wechatId, String address,
			String remark) {
		super();
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.wechatId = wechatId;
		this.address = address;
		this.remark = remark;
	}

	public Customer(@NotNull String customerName, @NotNull byte customerGender) {
		this(customerName, customerGender, "微信未添加", "地址未添加", "无备注");
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerGender="
				+ customerGender + ", wechatId=" + wechatId + ", address=" + address + ", remark=" + remark + "]";
	}

}
