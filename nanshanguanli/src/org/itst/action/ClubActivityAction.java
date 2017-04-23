package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.ClubActivity;
import org.itst.service.ClubActivityService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ClubActivityAction extends ActionSupport {
	@Autowired
	private ClubActivityService activityServiceImpl;
	
	private String name;
	private String startTime;
	private String endTime;
	private String fromClub;
	private String contact;
	private String leaderName;
	private String isBorrowed;
	private String holdPlace;
	private String form;
	private String introduction;
	private String id;
	public void setName(String name) {
		this.name = name;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setFromClub(String fromClub) {
		this.fromClub = fromClub;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public void setIsBorrowed(String isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public void setHoldPlace(String holdPlace) {
		this.holdPlace = holdPlace;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
	
	public void getClubActivitiesByPage(){
		String json = activityServiceImpl.getClubActivitiesJsonByPage(pageSize,pageNow);
		out(json);
	}
	public void getClubActivityByKeyWord(){
		out(activityServiceImpl.getClubActivityJsonByKeyWord(key, pageSize, pageNow));
	}
	public void addClubActivity(){
		ClubActivity ca = new ClubActivity();
		ca.setActivityContact(contact);
		ca.setActivityEndTime(endTime);
		ca.setActivityForm(form);
		ca.setActivityFromClub(fromClub);
		ca.setActivityHoldPlace(holdPlace);
		ca.setActivityIntroduction(introduction);
		ca.setActivityLeaderName(leaderName);
		ca.setActivityName(name);
		ca.setActivityStartTime(startTime);
		ca.setIsBorrowed(isBorrowed);
		System.out.println(endTime);
		activityServiceImpl.addClubActivity(ca);
		out("1");
	}
	public void updateClubActivity(){
		ClubActivity ca = activityServiceImpl.getClubActivityById(id);
		ca.setActivityContact(contact);
		ca.setActivityEndTime(endTime);
		ca.setActivityForm(form);
		ca.setActivityFromClub(fromClub);
		ca.setActivityHoldPlace(holdPlace);
		ca.setActivityIntroduction(introduction);
		ca.setActivityLeaderName(leaderName);
		ca.setActivityName(name);
		ca.setActivityStartTime(startTime);
		ca.setIsBorrowed(isBorrowed);
		activityServiceImpl.updateClubActivity(ca);
		out("1");
	}
	public void deleteClubActivityById(){
		 activityServiceImpl.deleteClubActivityById(id);
		 out("1");
	}
	public void  getActivityForm(){
		out(activityServiceImpl.getActivityFormJson());
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
