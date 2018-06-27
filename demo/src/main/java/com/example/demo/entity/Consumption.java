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
 * @author wz-pc 用户消费表，相当于二级目录，一次消费、消费清单，其中应该包括消费明细，即多种商品
 *         以后进行各类搜索操作的主要表，要仔细设计。注意加好索引，做好优化，以后可能会有大量数据.
 */
@Entity
public class Consumption {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	private int consumption_id;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date consumptionDate; 	// 消费时间
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date suggestDate;		// 建議取貨時間
	@NotNull
	private int user_id; 			// 处置人
	@NotNull
	private int customer_id; 		// 消费者ID
	@NotNull
	private int cloth_id; 			// 衣服类型
	@Column(length = 100)
	private String remark;

	public int getConsumption_id() {
		return consumption_id;
	}

	public void setConsumption_id(int consumption_id) {
		this.consumption_id = consumption_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCloth_id() {
		return cloth_id;
	}

	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
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

	public Date getSuggestDate() {
		return suggestDate;
	}

	public void setSuggestDate(Date suggestDate) {
		this.suggestDate = suggestDate;
	}

	public Consumption() {
		super();
	}

	public Consumption(@NotNull Date consumptionDate, @NotNull Date suggestDate, @NotNull int user_id,
			@NotNull int customer_id, @NotNull int cloth_id, String remark) {
		super();
		this.consumptionDate = consumptionDate;
		this.suggestDate = suggestDate;
		this.user_id = user_id;
		this.customer_id = customer_id;
		this.cloth_id = cloth_id;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Consumption [consumption_id=" + consumption_id + ", consumptionDate=" + consumptionDate
				+ ", suggestDate=" + suggestDate + ", user_id=" + user_id + ", customer_id=" + customer_id
				+ ", cloth_id=" + cloth_id + ", remark=" + remark + "]";
	}

	
}
