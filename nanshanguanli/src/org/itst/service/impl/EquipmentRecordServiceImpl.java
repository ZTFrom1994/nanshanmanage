package org.itst.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.itst.dao.EquipmentRecordMapper;
import org.itst.domain.EquipmentRecord;
import org.itst.service.EquipmentRecordService;
import org.itst.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EquipmentRecordServiceImpl implements EquipmentRecordService {
	@Autowired
	private EquipmentRecordMapper mapper;
	
	public int addEquipmentRecord(EquipmentRecord record) {
		 return mapper.addEquipmentRecord(record);
	}

	public void deleteRecordById(int id) {
		mapper.deleteRecordById(id);
	}

	public EquipmentRecord getEquipmentRecordById(int id) {
		
		return mapper.getEquipmentRecordById(id);
	}

	public String getEquipmentRecordsJsonByKeyWord(String key, int pageSize,
			int pageNow) {
		List<EquipmentRecord>  list = mapper.getEquipmentRecordsByKeyWord(key, pageSize*(pageNow-1), pageSize*pageNow);
		String res = "";
			for(EquipmentRecord er : list) {
				res += "{\"id\":\"" + er.getId()
						+ "\",\"borrowedType\":\"" + er.getBorrowedType()
						+ "\",\"number\":\""+ er.getNumber()
						+ "\",\"unit\":\"" + er.getUsingUnit()
						+ "\",\"startTime\":\""+ MyUtils.dateToString(er.getStartTime())
						+ "\",\"endTime\":\""+ MyUtils.dateToString(er.getEndTime())
						+ "\",\"username\":\""+ er.getPetitioner()
						+ "\",\"contact\":\"" + er.getContact()
						+ "\",\"usingFor\":\""+ er.getUsingFor()
						+ "\",\"isOvertime\":\""+ (er.getEndTime().compareTo(new Date())<0?"是":"否")
						+  "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";
	}

	public String getEquipmentRecordsJsonByPage(int pageSize, int pageNow) {
		List<EquipmentRecord>  list = mapper.getEquipmentRecordsByPage(pageSize*(pageNow-1), pageSize*pageNow);
		String res = "";
			for(EquipmentRecord er : list) {
				res += "{\"id\":\"" + er.getId()
						+ "\",\"borrowedType\":\"" + er.getBorrowedType()
						+ "\",\"number\":\""+ er.getNumber()
						+ "\",\"unit\":\"" + er.getUsingUnit()
						+ "\",\"startTime\":\""+ MyUtils.dateToString(er.getStartTime())
						+ "\",\"endTime\":\""+ MyUtils.dateToString(er.getEndTime())
						+ "\",\"username\":\""+ er.getPetitioner()
						+ "\",\"contact\":\"" + er.getContact()
						+ "\",\"usingFor\":\""+ er.getUsingFor()
						+ "\",\"isOvertime\":\""+ (er.getEndTime().compareTo(new Date())<0?"是":"否")
						+  "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getEquipmentRecordCount() + ",\"rows\":[" + res + "]}";
	}

}
