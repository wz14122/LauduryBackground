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
	private int consumptionId;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date consumptionDate; // 消费时间
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date suggestDate; // 建議取貨時間
	@NotNull
	private int userId; // 处置人
	@NotNull
	private int customerId; // 消费者ID
	@NotNull
	private int clothId; // 衣服类型
	@Column(length = 100)
	private String remark;

	public int getConsumptionId() {
		return consumptionId;
	}

	public void setConsumptionId(int consumptionId) {
		this.consumptionId = consumptionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getClothId() {
		return clothId;
	}

	public void setClothId(int clothId) {
		this.clothId = clothId;
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

	public Consumption(@NotNull Date consumptionDate, @NotNull Date suggestDate, @NotNull int userId,
			@NotNull int customerId, @NotNull int clothId, String remark) {
		super();
		this.consumptionDate = consumptionDate;
		this.suggestDate = suggestDate;
		this.userId = userId;
		this.customerId = customerId;
		this.clothId = clothId;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Consumption [consumptionId=" + consumptionId + ", consumptionDate=" + consumptionDate + ", suggestDate="
				+ suggestDate + ", userId=" + userId + ", customerId=" + customerId + ", clothId=" + clothId
				+ ", remark=" + remark + "]";
	}

}
