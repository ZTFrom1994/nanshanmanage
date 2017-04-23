package org.itst.domain;

import java.util.Date;

public class Equipment {
	private int id;
	private int status;
	private Date addTime;
	private String type;
	private EquipmentRecord record;
	public EquipmentRecord getRecord() {
		return record;
	}
	public void setRecord(EquipmentRecord record) {
		this.record = record;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
