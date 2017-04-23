package org.itst.dao;

import java.util.List;

import org.itst.domain.Ground;

public interface GroundMapper {
	public Ground getGroundByName(String name); 
	public Ground getGroundById(String id); 
	public List<Ground> getGroundByPage(int start,int end);
	public int getGroundCount();
	public int getKeySearchCount(String key);
	public List<Ground> getGroundByKeyWord(String key,int start,int end );
	public void addGround(Ground Ground);
	public void deleteGroundById(String id);
	public List<Ground> getAllGrounds();
	public void updateGroundStatus(Ground g);
}
