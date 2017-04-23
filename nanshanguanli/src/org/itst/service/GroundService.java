package org.itst.service;

import java.util.List;

import org.itst.domain.Ground;

public interface GroundService {
	public Ground getGroundByName(String name); 
	public Ground getGroundById(String id); 
	public String getGroundJsonByPage(int pageSize,int pageNow);
	public String getGroundJsonByKeyWord(String key,int pageSize,int pageNow );
	public void addGround(Ground ground);
	public void deleteGroundById(String id);
	public List<Ground> getAllGrounds();
	public void updateGroundStatus(Ground g);
}
