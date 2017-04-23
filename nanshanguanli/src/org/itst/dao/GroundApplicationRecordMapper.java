package org.itst.dao;

import java.util.List;

import org.itst.domain.GroundApplicationRecord;

public interface GroundApplicationRecordMapper {
	public GroundApplicationRecord getRecordById(int id);
	public List<GroundApplicationRecord> getRecordsByPage(int start ,int end );
	public List<GroundApplicationRecord> getRecordsBykeyWord(String key,int start ,int end );
	public int getRecordCount();
	public int getKeySearchCount(String key);
	public void addRecord(GroundApplicationRecord record);
}
