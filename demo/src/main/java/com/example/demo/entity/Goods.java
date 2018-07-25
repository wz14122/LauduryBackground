package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author wz-pc 货物清单表，即一种需要清洗的货物,与Consumption表应该是多对一的关系，量大，注意优化
 */
@Entity
@Table(indexes = { @Index(columnList = "customerId", unique = false) })
public class Goods implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int goodsId;
	@NotNull
	private int clothId; // 货物类型ID
	@NotNull
	private String consumptionId; // 消费清单id
	@NotNull
	@Column(name = "customerId")
	private int customerId; // 消费者ID
	@NotNull
	private boolean haveFetch; // 是否已经取走，可能存在多种货物，不会同时取走的情况
	@Temporal(TemporalType.TIMESTAMP)
	private Date fetchDate;	// 实际取货日期
	@Temporal(TemporalType.DATE) 
	private Date expectFetchDate; // 预计取货日期
	@Temporal(TemporalType.DATE)
	private Date consumptionDate; // 消费日期
	private String name;
	private int color;
	private int nums;
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

	public String getConsumptionId() {
		return consumptionId;
	}

	public void setConsumptionId(String consumptionId) {
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

	public Date getExpectFetchDate() {
		return expectFetchDate;
	}

	public void setExpectFetchDate(Date expectFetchDate) {
		this.expectFetchDate = expectFetchDate;
	}

	public Date getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
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
	
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", clothId=" + clothId + ", consumptionId=" + consumptionId
				+ ", customerId=" + customerId + ", haveFetch=" + haveFetch + ", fetchDate=" + fetchDate
				+ ", expectFetchDate=" + expectFetchDate + ", consumptionDate=" + consumptionDate + ", name=" + name
				+ ", color=" + color + ", nums=" + nums + ", price=" + price + ", remark=" + remark + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
