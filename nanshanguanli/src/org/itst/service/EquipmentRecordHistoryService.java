package org.itst.service;


import org.itst.domain.EquipmentRecordHistory;

public interface EquipmentRecordHistoryService {
	public EquipmentRecordHistory getHistoryById(String id);
	public String getHistoryJsonByPage(int pageSize,int pageNow);
	public String getHistoryJsonByKeyWord(String key ,int pageSize,int pageNow);
	public void addHistory(EquipmentRecordHistory erh);
}
