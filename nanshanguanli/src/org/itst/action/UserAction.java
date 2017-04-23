package org.itst.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;
import org.apache.struts2.ServletActionContext;
import org.itst.domain.Auth;
import org.itst.domain.Invno;
import org.itst.domain.Salt;
import org.itst.domain.User;
import org.itst.service.AuthService;
import org.itst.service.InvnoService;
import org.itst.service.SaltService;
import org.itst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String invno;
	private String changepsd;

	public void setChangepsd(String changepsd) {
		this.changepsd = changepsd;
	}

	public void setInvno(String invno) {
		this.invno = invno;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
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
	private String authName;
	public void setId(String id) {
		this.id = id;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private SaltService saltServiceImpl;
	@Autowired
	private AuthService authServiceImpl;
	@Autowired
	private InvnoService invnoServiceImpl;
	
	
	public void userLoginCheck() throws NoSuchAlgorithmException {
		User u = userServiceImpl.getUserByName(username);
		if (u != null) {
			Salt salt = saltServiceImpl.getSalt(Integer.parseInt(u.getId()));
			String encryptPwd = encryptPwd(username, password, salt.getSaltValue());
			if(u.getPassword().equals(encryptPwd)){
				Map<String, Object> session = ServletActionContext.getContext()
						.getSession();
				session.put("currentUser", u);
				out("1");
			}else{
				out("0");
			}
		} else {
			out("0");
		}
	}

	public void userRegister() {
		Invno i = invnoServiceImpl.getInvnoByName(invno);
		if (i != null ) {
			System.out.println(1);
			if( userServiceImpl.getUserByName(username) == null){
				Salt salt = new Salt();
				String saltValue = (Math.random() + "").substring(3, 13);
				salt.setSaltValue(saltValue);
				String psw = encryptPwd(username, password, saltValue);
				User u = new User();
				u.setUsername(username);
				u.setPassword(psw);
				u.setAuth(i.getAuth());
				u.setRegisterDate(new Date());
				userServiceImpl.addUser(u);
				salt.setUserId(Integer.parseInt(u.getId()));
				saltServiceImpl.addSalt(salt);
				out("1");
			}else{
				out("0");
			}
		} else {
			System.out.println(2);
			out("-1");
		}
	}
	public void updateUser() {
		User u = userServiceImpl.getUserByName(username);
		if ( u != null) {
			u.setAuth(authServiceImpl.getAuthByName(authName));
			userServiceImpl.updateUser(u);
			out("1");
		} else {
			out("0");
		}
	}

	public void changePassword() {
		User u = userServiceImpl.getUserByName(username);
		if (u != null && u.getPassword().equals(password)) {
			u.setPassword(changepsd);
			userServiceImpl.updateUser(u);
			out("1");
		} else {
			out("0");
		}
	}

	public void logout() {
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		session.remove("currentUser");
	}

	public void out(String msg) {
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

	public void isLogged() {
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		if (session.get("currentUser") != null) {
			out("1");
		} else {
			out("0");
		}
	}
	
	public void getCurrentAuth() {
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		User u = (User) session.get("currentUser");
		Auth auth = u.getAuth();
		String s = "[{\"addAuth\":\"" + auth.getAddAuth()
				+ "\",\"deleteAuth\":\"" + auth.getDeleteAuth()
				+ "\",\"updateAuth\":\"" + auth.getDeleteAuth()
				+ "\",\"searchAuth\":\"" + auth.getSearchAuth() + "\"}]";
		out("{\"auth\":"+s+"}"); 
	}
	public void getUsersByPage(){
		String json = userServiceImpl.getUsersJsonByPage(pageSize, pageNow);
		out(json);
	}
	public void getUsersByKeyWord(){
		String json = userServiceImpl.getUsersJsonByKeyWord(key, pageSize, pageNow);
		System.out.println(json);
		out(json);
	}
	public void deleteUser(){
		userServiceImpl.deleteUserById(id);
		out("1");
	}
	private String encryptPwd(String usr, String pwd, String salt) {
		return sha256(
				sha256(usr + sha256(pwd + salt)) + salt + sha256(usr + salt))
				.substring(3, 25);
	}
	
	private String sha256(String s) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("sha-256");
			byte[] bytes = digest.digest(s.getBytes());
			return Hex.encodeHexString(bytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
