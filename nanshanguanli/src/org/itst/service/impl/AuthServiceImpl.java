package org.itst.service.impl;

import java.util.List;
import org.itst.dao.AuthMapper;
import org.itst.dao.InvnoMapper;
import org.itst.domain.Auth;
import org.itst.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthMapper mapper;
	public void addAuth(Auth auth) {
		mapper.addAuth(auth);
	}

	public void deleteAuthById(String id) {
		mapper.deleteAuthById(id);
	}

	public Auth getAuthByName(String name) {
		return mapper.getAuthByName(name);
	}

	public int getAuthCount() {
		return mapper.getAuthCount();
	}

	public String getAuthsJsonByKeyWord(String key, int pageSize, int pageNow) {
		List<Auth> auths = mapper.getAuthsByKeyWord(key, pageSize*(pageNow-1), pageSize*pageNow);
		String res = "";
		for(Auth a:auths){
			res+=  "{\"id\":\"" + a.getAuthId() + 
					"\",\"name\":\""+ a.getAuthName() + 
					"\",\"addAuth\":\""+ a.getAddAuth() + 
					"\",\"deleteAuth\":\""+ a.getDeleteAuth() + 
					"\",\"searchAuth\":\""+ a.getSearchAuth() + 
					"\",\"updateAuth\":\""+ a.getUpdateAuth() + 
					"\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";		
	}

	public String getAuthsJsonByPage(int pageSize, int pageNow) {
		List<Auth> auths = mapper.getAuthsByPage(pageSize*(pageNow-1), pageNow*pageSize);
		String res = "";
		for(Auth a:auths){
			res+=  "{\"id\":\"" + a.getAuthId() + 
					"\",\"name\":\""+ a.getAuthName() + 
					"\",\"addAuth\":\""+ a.getAddAuth() + 
					"\",\"deleteAuth\":\""+ a.getDeleteAuth() + 
					"\",\"searchAuth\":\""+ a.getSearchAuth() + 
					"\",\"updateAuth\":\""+ a.getUpdateAuth() + 
					"\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "{\"total\":" + mapper.getAuthCount() + ",\"rows\":[" + res + "]}";	
	}

	public int getKeySearchCount(String key) {
		return mapper.getKeySearchCount(key);
	}

	public void updateAuth(Auth auth) {
		mapper.updateAuth(auth);
	}

	public Auth getAuthById(String id) {
		return getAuthById(id);
	}

	public String getAuthNameJson() {
		List<Auth> auths = mapper.getAllAuths();
		String res = "";
		for(Auth a:auths){
			res+=  "{\"id\":\"" + a.getAuthId() + 
					"\",\"text\":\""+ a.getAuthName() +
					"\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "["+res+"]";	
	}

}
