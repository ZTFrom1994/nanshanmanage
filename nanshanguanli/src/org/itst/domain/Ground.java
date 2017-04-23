package org.itst.domain;

import java.util.Date;

public class Ground {
	private int id;
	private String groundName;
	private Date addTime;
	private int status;
	private String usingUnit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsingUnit() {
		return usingUnit;
	}
	public void setUsingUnit(String usingUnit) {
		this.usingUnit = usingUnit;
	}

}
