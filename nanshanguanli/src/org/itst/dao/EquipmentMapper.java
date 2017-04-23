package org.itst.dao;

import java.util.List;

import org.itst.domain.Equipment;

public interface EquipmentMapper {
	public Equipment getEquipmentById(int id);
	public List<Equipment> getEquipmentsByPage(int start,int end);
	public int getEquipmentCount();
	public void addEquipments(List<Equipment> list);
	public void deleteEquipmentById(int id);
	public void updateEquipmentStatus(Equipment e);
	public List<Equipment> getFreeEquipmentByType(String type,int num); 
}
