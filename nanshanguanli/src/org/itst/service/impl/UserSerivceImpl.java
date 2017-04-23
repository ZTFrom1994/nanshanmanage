package org.itst.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.itst.dao.SaltMapper;
import org.itst.dao.UserMapper;
import org.itst.domain.User;
import org.itst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserSerivceImpl implements UserService {
	@Autowired
	private UserMapper mapper;//注入dao
	@Autowired
	private SaltMapper saltMapper;
	public void addUser(User u) {
		 mapper.addUser(u);
	}
	
	public void deleteUserById(String id) {
		 mapper.deleteUserById(id);
		 saltMapper.deleteSaltById(id);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return mapper.getAllUsers();
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return mapper.getUserById(id);
	}

	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return mapper.updateUser(u);
	}

	public User getUserByName(String username) {
		return mapper.getUserByName(username);
	}

	public String getUsersJsonByKeyWord(String key,int pageSize,int pageNow) {
		List<User> users = mapper.getUsersByKeyWord(key,pageSize*(pageNow-1),pageSize*pageNow);
		String str = "";
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(User u:users){
			str += "{\"authName\":\"" + u.getAuth().getAuthName() + "\",\"id\":\""
			+ u.getId() + "\",\"username\":\""
			+ u.getUsername() + "\",\"registerDate\":\""
			+ sFormat.format(u.getRegisterDate()) + "\"},";
		}
		if (!str.equals("")) {
			str = str.substring(0, str.length() - 1);
		}
		return "{\"total\":" + 1 + ",\"rows\":[" + str + "]}";
	}

	public String getUsersJsonByPage(int pageSize,int pageNow) {
		List<User> users = mapper.getUsersByPage(pageSize*(pageNow-1),pageSize*pageNow);
		String str = "";
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(User u:users){
			str += "{\"authName\":\"" + u.getAuth().getAuthName() 
			+ "\",\"id\":\"" + u.getId() 
			+ "\",\"username\":\"" + u.getUsername()
			 + "\",\"registerDate\":\"" + sFormat.format(u.getRegisterDate())
			 + "\"},";
		}
		if (!str.equals("")) {
			str = str.substring(0, str.length() - 1);
		}
		return "{\"total\":" + mapper.getUsersCount()+ ",\"rows\":[" + str + "]}";
	}
}
