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
 * @author wz-pc 个人消费详情表，为以后打折情况做准备
 */
@Entity
public class PersonAmount {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private int personAmountId;
	@NotNull
	private int customerId;
	@NotNull
	private double total; // 总金额
	@NotNull
	private int times; // 打折次数之类的
	@Column(length = 100)
	private String remark; // 打折信息等备注
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date consumptionDate; // 二次录入时间，即消费时间

	

	public int getPersonAmountId() {
		return personAmountId;
	}

	public void setPersonAmountId(int personAmountId) {
		this.personAmountId = personAmountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public PersonAmount(@NotNull int customerId, @NotNull double total, @NotNull int times, String remark,
			@NotNull Date consumptionDate) {
		super();
		this.customerId = customerId;
		this.total = total;
		this.times = times;
		this.remark = remark;
		this.consumptionDate = consumptionDate;
	}

	public PersonAmount() {
		super();
	}

	@Override
	public String toString() {
		return "PersonAmount [personAmountId=" + personAmountId + ", customerId=" + customerId + ", total=" + total
				+ ", times=" + times + ", remark=" + remark + ", consumptionDate=" + consumptionDate + "]";
	}

}
