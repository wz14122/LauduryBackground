package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author wz-pc 货物清单表，即一种需要清洗的货物,与Consumption表应该是多对一的关系，量大，注意优化
 */
@Entity
@Table(indexes = { @Index(columnList = "customerId", unique = false) })
public class Goods {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private int goodsId;
	@NotNull
	private int clothId; // 清洗货物类型
	@NotNull
	private int consumptionId; // 消费清单id
	@NotNull
	@Column(name = "customerId")
	private int customerId; // 消费者ID
	@NotNull
	private boolean haveFetch; // 是否已经取走，可能存在多种货物，不会同时取走的情况
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fetchDate;
	private double price; // 实际价格
	@Column(length = 100)
	private String remark;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getClothId() {
		return clothId;
	}

	public void setClothId(int clothId) {
		this.clothId = clothId;
	}

	public int getConsumptionId() {
		return consumptionId;
	}

	public void setConsumptionId(int consumptionId) {
		this.consumptionId = consumptionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean isHaveFetch() {
		return haveFetch;
	}

	public void setHaveFetch(boolean haveFetch) {
		this.haveFetch = haveFetch;
	}

	public Date getFetchDate() {
		return fetchDate;
	}

	public void setFetchDate(Date fetchDate) {
		this.fetchDate = fetchDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Goods() {
		super();
	}

	public Goods(@NotNull int clothId, @NotNull int consumptionId, @NotNull int customerId, @NotNull boolean haveFetch,
			@NotNull Date fetchDate, double price, String remark) {
		super();
		this.clothId = clothId;
		this.consumptionId = consumptionId;
		this.customerId = customerId;
		this.haveFetch = haveFetch;
		this.fetchDate = fetchDate;
		this.price = price;
		this.remark = remark;
	}

	public Goods(int goodsId, @NotNull int clothId, @NotNull int consumptionId, @NotNull int customerId,
			@NotNull boolean haveFetch, @NotNull Date fetchDate, double price, String remark) {
		super();
		this.goodsId = goodsId;
		this.clothId = clothId;
		this.consumptionId = consumptionId;
		this.customerId = customerId;
		this.haveFetch = haveFetch;
		this.fetchDate = fetchDate;
		this.price = price;
		this.remark = remark;
	}

}
