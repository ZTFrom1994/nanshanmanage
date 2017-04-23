package org.itst.domain;

import java.util.Date;
import java.util.List;

public class EquipmentRecord {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String borrowedType;
	private Date startTime;
	private Date endTime;
	private String usingUnit;
	private String petitioner;
	private String contact;
	private String usingFor;
	private int number;
	private List<Equipment> eqList;
	public List<Equipment> getEqList() {
		return eqList;
	}
	public void setEqList(List<Equipment> eqList) {
		this.eqList = eqList;
	}
	public String getBorrowedType() {
		return borrowedType;
	}
	public void setBorrowedType(String borrowedType) {
		this.borrowedType = borrowedType;
	}
	
	
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getUsingUnit() {
		return usingUnit;
	}
	public void setUsingUnit(String usingUnit) {
		this.usingUnit = usingUnit;
	}
	public String getPetitioner() {
		return petitioner;
	}
	public void setPetitioner(String petitioner) {
		this.petitioner = petitioner;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUsingFor() {
		return usingFor;
	}
	public void setUsingFor(String usingFor) {
		this.usingFor = usingFor;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
