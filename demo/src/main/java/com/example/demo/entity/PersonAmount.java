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
	private int personAmount_id;
	@NotNull
	private int customer_id;
	@NotNull
	private double total; // 总金额
	@NotNull
	private int times; // 打折次数之类的
	@Column(length = 100)
	private String remark; // 打折信息等备注
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date consumptionDate; // 二次录入时间，即消费时间

	public int getPersonAmount_id() {
		return personAmount_id;
	}

	public void setPersonAmount_id(int personAmount_id) {
		this.personAmount_id = personAmount_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public PersonAmount(@NotNull int customer_id, @NotNull double total, @NotNull int times, String remark,
			@NotNull Date consumptionDate) {
		super();
		this.customer_id = customer_id;
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
		return "PersonAmount [personAmount_id=" + personAmount_id + ", customer_id=" + customer_id + ", total=" + total
				+ ", times=" + times + ", remark=" + remark + ", consumptionDate=" + consumptionDate + "]";
	}

}
