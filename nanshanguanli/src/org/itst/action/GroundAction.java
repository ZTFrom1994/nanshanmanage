package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.Ground;
import org.itst.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class GroundAction extends ActionSupport {
	@Autowired
	private GroundService groundServiceImpl;
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
	private String id ;
	private String groundName;
	public void setId(String id) {
		this.id = id;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public void getGroundBypage(){
		String json = groundServiceImpl.getGroundJsonByPage(pageSize, pageNow);
		out(json);
	}
	public void getGroundByKeyWord(){
		out(groundServiceImpl.getGroundJsonByKeyWord(key, pageSize, pageNow));
	}
	public void addGround(){
		Ground ground = new Ground();
		ground.setAddTime(new Date());
		ground.setStatus(1);
		ground.setUsingUnit(null);
		ground.setGroundName(groundName);
		groundServiceImpl.addGround(ground);
		out("1");
	}
	public void deleteGround(){
		groundServiceImpl.deleteGroundById(id);
		out("1");
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
}
