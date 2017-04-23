package org.itst.domain;

import java.util.Date;

public class EquipmentRecordHistory {
	private int id;
	private Date operateTime;
	private String borrowedType;
	private Date startTime;
	private Date endTime;
	private String usingUnit;
	private String contact;
	private String petitioner;
	private String usingFor;
	private Equipment equipment;
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	private User operator;
	public String getBorrowedType() {
		return borrowedType;
	}
	public void setBorrowedType(String borrowedType) {
		this.borrowedType = borrowedType;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getUsingUnit() {
		return usingUnit;
	}
	public void setUsingUnit(String usingUnit) {
		this.usingUnit = usingUnit;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPetitioner() {
		return petitioner;
	}
	public void setPetitioner(String petitioner) {
		this.petitioner = petitioner;
	}
	public String getUsingFor() {
		return usingFor;
	}
	public void setUsingFor(String usingFor) {
		this.usingFor = usingFor;
	}
	
	public User getOperator() {
		return operator;
	}
	public void setOperater(User operator) {
		this.operator = operator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getOperateTime() {
		return operateTime;
	} 
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
}
