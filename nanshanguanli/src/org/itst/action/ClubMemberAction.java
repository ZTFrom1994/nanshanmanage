package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.ClubMember;
import org.itst.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ClubMemberAction extends ActionSupport {

	@Autowired
	private ClubMemberService clubMemberServiceImpl;

	

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

	private String name;
	private String fromAcademy;
	private String fromClubName;
	private String phoneNumber;
	private String sex;
	private String id;
	
	public void setId(String id){
		this.id = id;
	}
	public void setClubMemberServiceImpl(ClubMemberService clubMemberServiceImpl) {
		this.clubMemberServiceImpl = clubMemberServiceImpl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFromAcademy(String fromAcademy) {
		this.fromAcademy = fromAcademy;
	}

	public void setFromClubName(String fromClubName) {
		this.fromClubName = fromClubName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void addClubMember() {
		if(clubMemberServiceImpl.getClubMemberById(id)==null){
			ClubMember c = new ClubMember();
			c.setFromAcademy(fromAcademy);
			c.setFromClubName(fromClubName);
			c.setName(name);
			c.setPhoneNumber(phoneNumber);
			c.setSex(sex);
			c.setStuId(id);
			clubMemberServiceImpl.addClubMember(c);
			out("1");
		}else{
			out("0");
		}
		
	}

	public void getClubMembersByPage() {
		String json = clubMemberServiceImpl.getClubMembersJsonByPage(pageSize, pageNow);
		out(json);
	}

	public void out(String msg) {
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

	public void deleteClubMemberById() {
		clubMemberServiceImpl.deleteClubMemberById(id);
		out("1");
	}

	public void updateClubMember() {
		ClubMember c = clubMemberServiceImpl.getClubMemberById(id);
		c.setFromAcademy(fromAcademy);
		c.setFromClubName(fromClubName);
		c.setName(name);
		c.setPhoneNumber(phoneNumber);
		c.setSex(sex);
		clubMemberServiceImpl.updateClubMember(c);
		out("1");
	}

	public void getClubMembersByKey(){
		String json = clubMemberServiceImpl.getClubMembersJsonBykeyWord(key,pageSize, pageNow);
		out(json);
	}
}
