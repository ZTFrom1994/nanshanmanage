package org.itst.dao;

import java.util.List;

import org.itst.domain.EquipmentRecordHistory;

public interface EquipmentRecordHistoryMapper {
	public EquipmentRecordHistory getHistoryById(String id);
	public List<EquipmentRecordHistory> getHistoryByPage(int start,int end);
	public int getHistroyCount();
	public int getKeySearchCount(String key);
	public List<EquipmentRecordHistory> getHistoryByKeyWord(String key ,int start,int end);
	public void addHistory(EquipmentRecordHistory erh);
}
