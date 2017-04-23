package org.itst.service;


import java.util.List;

import org.itst.domain.Equipment;
import org.itst.domain.EquipmentRecord;

public interface EquipmentRecordService {
	public EquipmentRecord getEquipmentRecordById(int id);
	public String getEquipmentRecordsJsonByPage(int pageSize,int pageNow);
	public String getEquipmentRecordsJsonByKeyWord(String key,int pageSize,int pageNow);
	public int addEquipmentRecord(EquipmentRecord record);
	public void deleteRecordById(int id);
}
