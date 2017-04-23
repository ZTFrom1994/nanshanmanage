package org.itst.service.impl;


import java.util.List;

import org.itst.dao.EquipmentRecordHistoryMapper;
import org.itst.domain.EquipmentRecordHistory;
import org.itst.service.EquipmentRecordHistoryService;
import org.itst.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EquipmentRecordHistoryServiceImpl implements
		EquipmentRecordHistoryService {
	@Autowired
	private EquipmentRecordHistoryMapper mapper;
	
	public void addHistory(EquipmentRecordHistory erh) {
		mapper.addHistory(erh);
	}

	public EquipmentRecordHistory getHistoryById(String id) {
		return mapper.getHistoryById(id);
	}

	public String getHistoryJsonByKeyWord(String key, int pageSize, int pageNow) {
		List<EquipmentRecordHistory> list = mapper.getHistoryByKeyWord(key, pageSize*(pageNow-1), pageSize*pageNow);
		String res = "";
			for(EquipmentRecordHistory erh : list){
				res += "{\"id\":\"" + erh.getId()
						+ "\",\"equipmentId\":\"" + String.format("%06d", erh.getEquipment().getId())
						+ "\",\"endTime\":\"" + MyUtils.dateToString(erh.getEndTime())
						+ "\",\"startTime\":\"" + MyUtils.dateToString(erh.getStartTime())
						+ "\",\"borrowedType\":\""+ erh.getBorrowedType()
						+ "\",\"usingFor\":\""+ erh.getUsingFor()
						+ "\",\"usingUnit\":\"" + erh.getUsingFor()
						+ "\",\"contact\":\""+ erh.getContact()
						+ "\",\"petitioner\":\"" + erh.getPetitioner()
						+ "\",\"operator\":\""+ erh.getOperator().getUsername() 
						+ "\",\"operaterTime\":\""+ MyUtils.dateToString(erh.getOperateTime())
						+ "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";
	}

	public String getHistoryJsonByPage(int pageSize, int pageNow) {
		List<EquipmentRecordHistory> list = mapper.getHistoryByPage(pageSize*(pageNow-1), pageSize*pageNow);
		String res = "";
			for(EquipmentRecordHistory erh : list){
				res += "{\"id\":\"" + erh.getId()
						+ "\",\"equipmentId\":\"" + String.format("%06d", erh.getEquipment().getId())
						+ "\",\"endTime\":\"" + MyUtils.dateToString(erh.getEndTime())
						+ "\",\"startTime\":\"" + MyUtils.dateToString(erh.getStartTime())
						+ "\",\"borrowedType\":\""+ erh.getBorrowedType()
						+ "\",\"usingFor\":\""+ erh.getUsingFor()
						+ "\",\"usingUnit\":\"" + erh.getUsingFor()
						+ "\",\"contact\":\""+ erh.getContact()
						+ "\",\"petitioner\":\"" + erh.getPetitioner()
						+ "\",\"operator\":\""+ erh.getOperator().getUsername() 
						+ "\",\"operaterTime\":\""+ MyUtils.dateToString(erh.getOperateTime())
						+ "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getHistroyCount() + ",\"rows\":[" + res + "]}";
	}

}
