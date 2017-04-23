package org.itst.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.itst.dao.EquipmentMapper;
import org.itst.domain.Equipment;
import org.itst.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentMapper mapper;
	public void addEquipments(List<Equipment> list) {
		mapper.addEquipments(list); 
	}

	public void deleteEquipmentById(int id) {
		mapper.deleteEquipmentById(id);
	}

	public Equipment getEquipmentById(int id) {
		return mapper.getEquipmentById(id);
	}

	public String getEquipmentsJsonByPage(int pageSize, int pageNow) {
		List<Equipment> eqs = mapper.getEquipmentsByPage(pageSize*(pageNow-1), pageSize*pageNow);
		String res = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			for(Equipment e : eqs){
				res += "{\"id\":\"" + String.format("%06d", e.getId())
						+ "\",\"type\":\"" + e.getType()
						+ "\",\"usingUnit\":\"" + (e.getRecord()==null?"暂无":e.getRecord().getUsingUnit())
						+ "\",\"status\":\"" + (e.getStatus()==1?"闲置":"使用中")
						+ "\",\"addTime\":\"" + formatter.format(e.getAddTime())
						+ "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getEquipmentCount() + ",\"rows\":[" + res + "]}";
	}

	public void updateEquipmentStatus(Equipment e) {
		mapper.updateEquipmentStatus(e);
	}

	public List<Equipment> getFreeEquipmentByType(String type, int num) {
		
		return mapper.getFreeEquipmentByType(type, num);
	}

	public List<Equipment> getFreeEquipmentByType(String type, String num) {
		// TODO Auto-generated method stub
		return null;
	}

}
