package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.service.EquipmentRecordHistoryService;
import org.itst.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class EquipmentRecordHistoryAction extends ActionSupport {
	@Autowired
	private EquipmentRecordHistoryService erHistoryImpl;
	
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
	public void getHistoryByPage(){
		out(erHistoryImpl.getHistoryJsonByPage(pageSize, pageNow));
	}
	public void getHistoryByKeyWord(){
		out(erHistoryImpl.getHistoryJsonByKeyWord(key, pageSize, pageNow));
	}
	public static void out(String msg){
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
