package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.itst.domain.Auth;
import org.itst.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AuthAction extends ActionSupport {
	@Autowired
	private AuthService authServiceImpl;
	private String key;
	private int pageNow;
	private int pageSize;
	public void setRows(String rows) {
		this.pageSize = Integer.parseInt(rows);
	}
	public void setPage(String page) {
		this.pageNow = Integer.parseInt(page);
	}
	public void setKey(String key) {
		this.key = key;
	}
	private String id ;
	private String name;
	private String addAuth;
	private String deleteAuth;
	private String updateAuth;
	private String searchAuth;
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddAuth(String addAuth) {
		this.addAuth = addAuth;
	}
	public void setDeleteAuth(String deleteAuth) {
		this.deleteAuth = deleteAuth;
	}
	public void setUpdateAuth(String updateAuth) {
		this.updateAuth = updateAuth;
	}
	public void setSearchAuth(String searchAuth) {
		this.searchAuth = searchAuth;
	}

	
	public void getAuthsByPage(){
		out(authServiceImpl.getAuthsJsonByPage(pageSize,pageNow));
	}
	public void getAuthsByKeyWord(){
		out(authServiceImpl.getAuthsJsonByKeyWord(key, pageSize,pageNow));
	}
	public void addAuth(){
		Auth auth = new Auth();
		auth.setAuthName(name);
		auth.setAddAuth(addAuth);
		auth.setDeleteAuth(deleteAuth);
		auth.setSearchAuth(searchAuth);
		auth.setUpdateAuth(updateAuth);
		authServiceImpl.addAuth(auth);
		out("1");
	}
	public void updateAuth(){
		Auth auth = authServiceImpl.getAuthById(id);
		auth.setAuthName(name);
		auth.setAddAuth(addAuth);
		auth.setDeleteAuth(deleteAuth);
		auth.setSearchAuth(searchAuth);
		auth.setUpdateAuth(updateAuth);
		authServiceImpl.updateAuth(auth);
		out("1");
	}
	public void deleteAuthById(){
		authServiceImpl.deleteAuthById(id);
		out("1");
	}
	public void getAuthName(){
		out(authServiceImpl.getAuthNameJson());
	}
	public void out(String msg){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");  
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(msg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
