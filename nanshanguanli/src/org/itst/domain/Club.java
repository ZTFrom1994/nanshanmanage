package org.itst.domain;

import java.util.Date;

public class Club {
	private String clubName;
	private int clubId;
	private ClubMember student;
	private String clubBrief;
	private String clubType;
	private Date registerDate;
	private String teacherName;
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public ClubMember getStudent() {
		return student;
	}
	public void setStudent(ClubMember student) {
		this.student = student;
	}
	public String getClubName(){
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubBrief() {
		return clubBrief;
	}
	public void setClubBrief(String clubBrief) {
		this.clubBrief = clubBrief;
	}
	public String getClubType() {
		return clubType;
	}
	public void setClubType(String clubType) {
		this.clubType = clubType;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
