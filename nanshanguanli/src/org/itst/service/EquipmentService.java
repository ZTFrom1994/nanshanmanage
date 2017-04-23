package org.itst.service;

import java.util.List;
import java.util.Map;

import org.itst.domain.Equipment;

public interface EquipmentService {
	public Equipment getEquipmentById(int id);
	public String getEquipmentsJsonByPage(int pageSize,int pageNow);
	public void addEquipments(List<Equipment> list);
	public void deleteEquipmentById(int id);
	public void updateEquipmentStatus(Equipment e);
	public List<Equipment> getFreeEquipmentByType(String type,int num); 
}
