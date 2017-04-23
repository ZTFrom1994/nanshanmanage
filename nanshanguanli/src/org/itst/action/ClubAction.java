package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.Club;
import org.itst.domain.ClubMember;
import org.itst.service.ClubService;
import org.itst.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ClubAction extends ActionSupport {
	@Autowired
	private ClubService clubService;
	@Autowired
	private ClubMemberService studentService;
	
	private String clubId;
	private	String phoneNumber;
	private String clubName;
	private String clubType;
	private String leaderName;
	private String leaderStuId;
	private String clubBrief;
	private String teacherName;
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setClubBrief(String clubBrief) {
		this.clubBrief = clubBrief;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public void setClubType(String clubType) {
		this.clubType = clubType;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public void setLeaderStuId(String leaderStuId) {
		this.leaderStuId = leaderStuId;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	private String key;
	private int pageNow;
	private int pageSize;
	public void setRows(String rows) {
		this.pageSize = Integer.parseInt(rows);
	}
	public void setPage(String page) {
		this.pageNow = Integer.parseInt(page);
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public void getClubsByPage(){
		String json = clubService.getClubJsonByPage(pageSize,pageNow);
		out(json);	
	}
	
	public void getClubByKeyWord(){
		String json  = clubService.getClubJsonByKeyWord(key,pageSize, pageNow);
		System.out.println(json);
		out(json);
	}
	public void addClub(){
		ClubMember stu = studentService.getClubMemberById(leaderStuId);
		if(stu!=null && stu.getName().equals(leaderName)){
			Club club = new Club();
			club.setClubBrief(clubBrief);
			club.setClubName(clubName);
			club.setClubType(clubType);
			club.setRegisterDate(new Date());
			club.setTeacherName(teacherName);
			club.setStudent(stu);
			clubService.addClub(club);
			stu.setFromClubName(clubName);
			stu.setPosition("社长");
			studentService.updateClubMember(stu);
			out("1");
		}else{
			//学号和名字不符
			out("-1");
		}
	}
	public void updateClub(){
		ClubMember stu = studentService.getClubMemberById(leaderStuId);
		if(stu!=null && stu.getName().equals(leaderName)){
			Club club =clubService.getClubById(clubId);
			club.setClubBrief(clubBrief);
			club.setClubName(clubName);
			club.setClubType(clubType);
			club.setTeacherName(teacherName);
			club.setStudent(stu);
			clubService.updateClub(club);
			out("1");
		}else{
			out("-1");
		}
		
	}
	public void deleteClubById(){
		clubService.deleteClubById(clubId);
		out("1");
	}
	public void out(String msg){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");  
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(msg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
