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

/**
 * @author wz-pc 货物清单表，即一种需要清洗的货物,与Consumption表应该是多对一的关系，量大，注意优化
 */
@Entity
@Table(indexes = { @Index(columnList = "customer_id", unique = false) })
public class Goods {

	@Id
	@GeneratedValue
	private int goods_id;
	@NotNull
	private int cloth_id; // 清洗货物类型
	@NotNull
	private int consumption_id; // 消费清单id
	@NotNull
	@Column(name = "customer_id")
	private int customer_id; // 消费者ID
	@NotNull
	private boolean fetch_is; // 是否已经取走，可能存在多种货物，不会同时取走的情况
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fetch_date;
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

	public Date getFetch_date() {
		return fetch_date;
	}

	public void setFetch_date(Date fetch_date) {
		this.fetch_date = fetch_date;
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

	public boolean isFetch_is() {
		return fetch_is;
	}

	public void setFetch_is(boolean fetch_is) {
		this.fetch_is = fetch_is;
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
			@NotNull boolean fetch_is, @NotNull Date fetch_date, double price, String remark) {
		super();
		this.goods_id = goods_id;
		this.cloth_id = cloth_id;
		this.consumption_id = consumption_id;
		this.customer_id = customer_id;
		this.fetch_is = fetch_is;
		this.fetch_date = fetch_date;
		this.price = price;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", cloth_id=" + cloth_id + ", consumption_id=" + consumption_id
				+ ", customer_id=" + customer_id + ", fetch_is=" + fetch_is + ", fetch_date=" + fetch_date + ", remark="
				+ remark + "]";
	}

}
