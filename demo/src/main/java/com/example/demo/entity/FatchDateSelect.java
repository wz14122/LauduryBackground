package com.example.demo.entity;

import javax.persistence.Id;

/**
 * @author wz
 * 几日后取货，维护表
 */
public class FatchDateSelect {

	@Id
	private int id;
	
	private String fatchDate;
	
	private boolean state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFatchDate() {
		return fatchDate;
	}

	public void setFatchDate(String fatchDate) {
		this.fatchDate = fatchDate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public FatchDateSelect() {
		super();
	}

	public FatchDateSelect(String fatchDate, boolean state) {
		super();
		this.fatchDate = fatchDate;
		this.state = state;
	}

	@Override
	public String toString() {
		return "FatchDateSelect [id=" + id + ", fatchDate=" + fatchDate + ", state=" + state + "]";
	}
	
	
}
