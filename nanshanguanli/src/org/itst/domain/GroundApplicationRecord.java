package org.itst.domain;

import java.util.Date;

public class GroundApplicationRecord {
	private int id;
	private Ground ground;
	private Date startTime;
	private Date endTime;
	private User operator;
	private Date operateTime;
	private String usingUnit;
	private String contact;
	private String petitioner;
	private String usingFor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ground getGround() {
		return ground;
	}
	public void setGround(Ground ground) {
		this.ground = ground;
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
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
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
	
	
}
