package org.itst.service;

import org.itst.domain.Auth;

public interface AuthService {
	public Auth getAuthByName(String name); 
	public Auth getAuthById(String id); 
	public String getAuthsJsonByPage(int pageSize,int pageNow);
	public int getAuthCount();
	public int getKeySearchCount(String key);
	public String getAuthsJsonByKeyWord(String key,int pageSize,int pageNow );
	public void addAuth(Auth auth);
	public void updateAuth(Auth auth);
	public void deleteAuthById(String id);
	public String getAuthNameJson();
}
