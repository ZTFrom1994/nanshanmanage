package org.itst.dao;

import java.util.List;

import org.itst.domain.Auth;

public interface AuthMapper {
	public Auth getAuthByName(String name); 
	public Auth getAuthById(String id); 
	public List<Auth> getAuthsByPage(int start,int end);
	public int getAuthCount();
	public int getKeySearchCount(String key);
	public List<Auth> getAuthsByKeyWord(String key,int start,int end );
	public void addAuth(Auth auth);
	public void updateAuth(Auth auth);
	public void deleteAuthById(String id);
	public List<Auth> getAllAuths();
}
