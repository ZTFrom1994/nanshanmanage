package org.itst.service;

import org.itst.domain.GroundApplicationRecord;

public interface GroundApplicationRecordService {
	public GroundApplicationRecord getRecordById(int id);
	public String getRecordsJsonByPage(int pageSize ,int pageNow);
	public String getRecordsJsonBykeyWord(String key,int pageSize ,int pageNow );
	public void addRecord(GroundApplicationRecord record);
}
