package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.CouncilMember;
import org.itst.service.CouncilMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class CouncilMemberAction extends ActionSupport {
	@Autowired
	private CouncilMemberService memberServiceImpl;
	
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
	private String sex;
	private String phoneNumber;
	private String departmentName;
	private String positionName;
	private String stuId;
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFromAcademy(String fromAcademy) {
		this.fromAcademy = fromAcademy;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public void addCouncilMember(){
		if(memberServiceImpl.getCouncilMemberById(stuId)== null){
			CouncilMember cm = new CouncilMember();
			System.out.println(stuId);
			System.out.println(fromAcademy);
			System.out.println(departmentName);
			System.out.println(positionName);
			
			cm.setDepartmentName(departmentName);
			cm.setFromAcademy(fromAcademy);
			cm.setName(name);
			cm.setPhoneNumer(phoneNumber);
			cm.setSex(sex);
			cm.setStuId(stuId);
			cm.setPositionName(positionName);
			memberServiceImpl.addCouncilMember(cm);
			out("1");
		}else{
			out("0");
		}
	}
	public void updateCouncilMember(){
		CouncilMember cm = memberServiceImpl.getCouncilMemberById(stuId);
		if(cm!=null){
			cm.setDepartmentName(departmentName);
			cm.setFromAcademy(fromAcademy);
			cm.setName(name);
			cm.setPhoneNumer(phoneNumber);
			cm.setSex(sex);
			cm.setPositionName(positionName);
			memberServiceImpl.updateCouncilMember(cm);
			out("1");
		}else{
			out("0");
		}
	}
	public void deleteCouncilMember(){
		memberServiceImpl.deleteCouncilMemberById(stuId);
		out("1");
	}
	public void getCoucilMembersByKeyWord(){
		out(memberServiceImpl.getCouncilMemberByKeyWord(key, pageSize, pageNow));
	}
	public void getCouncilMembersByPage(){
		out(memberServiceImpl.getCouncilMembersJsonByPage(pageSize, pageNow));
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
