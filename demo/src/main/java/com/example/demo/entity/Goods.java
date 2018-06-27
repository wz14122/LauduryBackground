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
@Table(indexes = { @Index(columnList = "customer_id", unique = false) })
public class Goods {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private int goods_id;
	@NotNull
	private int cloth_id; // 清洗货物类型
	@NotNull
	private int consumption_id; // 消费清单id
	@NotNull
	@Column(name = "customer_id")
	private int customer_id; // 消费者ID
	@NotNull
	private boolean haveFetch; // 是否已经取走，可能存在多种货物，不会同时取走的情况
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fetchDate;
	private double price; // 实际价格
	@Column(length = 100)
	private String remark;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getCloth_id() {
		return cloth_id;
	}

	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}

	public int getConsumption_id() {
		return consumption_id;
	}

	public void setConsumption_id(int consumption_id) {
		this.consumption_id = consumption_id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public Goods() {
		super();
	}

	public Goods(int goods_id, @NotNull int cloth_id, @NotNull int consumption_id, @NotNull int customer_id,
			@NotNull boolean haveFetch, @NotNull Date fetchDate, double price, String remark) {
		super();
		this.goods_id = goods_id;
		this.cloth_id = cloth_id;
		this.consumption_id = consumption_id;
		this.customer_id = customer_id;
		this.haveFetch = haveFetch;
		this.fetchDate = fetchDate;
		this.price = price;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", cloth_id=" + cloth_id + ", consumption_id=" + consumption_id
				+ ", customer_id=" + customer_id + ", haveFetch=" + haveFetch + ", fetchDate=" + fetchDate + ", remark="
				+ remark + "]";
	}

}
