package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.Equipment;
import org.itst.domain.EquipmentRecord;
import org.itst.domain.EquipmentRecordHistory;
import org.itst.domain.User;
import org.itst.service.EquipmentRecordHistoryService;
import org.itst.service.EquipmentRecordService;
import org.itst.service.EquipmentService;
import org.itst.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class EquipmentRecordAction extends ActionSupport {
	@Autowired
	private EquipmentRecordService erServiceImpl;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired 
	private EquipmentRecordHistoryService erHistoryServiceImpl;
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

	private int id;
	private String borrowedType;
	private Date startTime;
	private Date endTime;
	private int number;
	private String contact;
	private String unit;
	private String petitioner;
	private String usingFor;

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public void setBorrowedType(String borrowedType) {
		this.borrowedType = borrowedType;
	}

	public void setStartTime(String startTime) {
		this.startTime = MyUtils.stringToDate(startTime);
	}

	public void setEndTime(String endTime) {
		this.endTime = MyUtils.stringToDate(endTime);
	}

	public void setNumber(String number) {
		this.number = Integer.parseInt(number);
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setPetitioner(String petitioner) {
		this.petitioner = petitioner;
	}

	public void setUsingFor(String usingFor) {
		this.usingFor = usingFor;
	}

	public void getEquipmentRecordsByPage() {
		String json = erServiceImpl.getEquipmentRecordsJsonByPage(pageSize, pageNow);
		out(erServiceImpl.getEquipmentRecordsJsonByPage(pageSize, pageNow));
	}

	public void getEquipmentRecordsBykeyWord() {
		out(erServiceImpl.getEquipmentRecordsJsonByKeyWord(key, pageSize,
				pageNow));
	}

	public void deleteRecordById() {
		EquipmentRecord er = erServiceImpl.getEquipmentRecordById(id);
		if(er != null){
			for(Equipment e : er.getEqList()){
				e.setStatus(1);
				e.setRecord(null);
				equipmentService.updateEquipmentStatus(e);
			}
			erServiceImpl.deleteRecordById(er.getId());
			out("1");
		}else{
			out("0");
		}
	}

	public void addRecord() {
		List<Equipment> eqs = equipmentService.getFreeEquipmentByType(
				borrowedType, number);
		if (eqs != null && eqs.size() == number) {
			EquipmentRecord er = new EquipmentRecord();
			er.setEqList(eqs);
			er.setBorrowedType(borrowedType);
			er.setContact(contact);
			er.setEndTime(endTime);
			er.setNumber(number);
			er.setPetitioner(petitioner);
			er.setStartTime(startTime); 
			er.setUsingFor(usingFor);
			er.setUsingUnit(unit);
			erServiceImpl.addEquipmentRecord(er);
			// 从数据库选取对应数量的物品，置状态为 0
			for (Equipment e:eqs) {
				e.setStatus(0);
				e.setRecord(er);
				equipmentService.updateEquipmentStatus(e);
				EquipmentRecordHistory erh = new EquipmentRecordHistory();
				erh.setOperateTime(new Date());
				User u = (User)ServletActionContext.getContext().getSession().get("currentUser");
				erh.setOperater(u);
				erh.setBorrowedType(er.getBorrowedType());
				erh.setContact(er.getContact());
				erh.setEndTime(er.getEndTime());
				erh.setStartTime(er.getStartTime());
				erh.setEquipment(e);
				erh.setPetitioner(er.getPetitioner());
				erh.setUsingFor(er.getUsingFor());
				erh.setUsingUnit(er.getUsingUnit());
				erHistoryServiceImpl.addHistory(erh);
			}
			out("1");
		}else{
			out("0");
		}

		// 将本操作记录至history

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
