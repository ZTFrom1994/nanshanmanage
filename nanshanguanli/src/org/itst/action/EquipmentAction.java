package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.Equipment;
import org.itst.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class EquipmentAction extends ActionSupport{
	@Autowired
	private EquipmentService equipmentServiceiImpl;
	private int pageNow;
	private int pageSize;
	public void setRows(String rows) {
		this.pageSize = Integer.parseInt(rows);
	}
	public void setPage(String page) {
		this.pageNow = Integer.parseInt(page);
	}
	private int id ;
	private String type;
	private String num;
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void getEquipmentsByPage(){
		String json = equipmentServiceiImpl.getEquipmentsJsonByPage(pageSize, pageNow);
		out(json);
	}
	public void deleteEquipmentById(){
		equipmentServiceiImpl.deleteEquipmentById(id);
		out("1");
	}
	public void addEquipment(){
		List<Equipment> list = new ArrayList<Equipment>();
		for (int i = 0; i < Integer.parseInt(num); i++) {
			Equipment e = new Equipment();
			e.setAddTime(new Date());
			e.setType(type);
			e.setStatus(1);
			list.add(e);
		}
		equipmentServiceiImpl.addEquipments(list);
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
