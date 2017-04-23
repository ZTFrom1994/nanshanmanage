package org.itst.domain;

public class Invno {
	private String id;
	private String invnoName;
	public String getInvnoName() {
		return invnoName;
	}
	public void setInvnoName(String invnoName) {
		this.invnoName = invnoName;
	}
	private Auth auth;
	public Auth getAuth() {
		return auth;
	}
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
