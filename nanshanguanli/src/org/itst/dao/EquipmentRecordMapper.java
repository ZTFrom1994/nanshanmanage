package org.itst.dao;

import java.util.List;

import org.itst.domain.EquipmentRecord;

public interface EquipmentRecordMapper {
	public EquipmentRecord getEquipmentRecordById(int id);
	public List<EquipmentRecord> getEquipmentRecordsByPage(int start,int end);
	public List<EquipmentRecord> getEquipmentRecordsByKeyWord(String key,int start,int end);
	public int getEquipmentRecordCount();
	public int getKeySearchCount(String key);
	public int addEquipmentRecord(EquipmentRecord record);
	public void deleteRecordById(int id);
}
