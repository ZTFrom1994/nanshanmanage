package org.itst.domain;

public class Salt {
	private int userId;
	private String saltValue;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSaltValue() {
		return saltValue;
	}
	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}
}
