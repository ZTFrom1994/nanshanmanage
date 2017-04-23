package org.itst.dao;

import java.util.List;

import org.itst.domain.User;

public interface UserMapper {
	public void addUser(User u);
	public int deleteUserById(String id);
	public int updateUser(User u);
	public User getUserById(String id);
	public User getUserByName(String username);
	public List<User> getAllUsers();
	public List<User> getUsersByPage(int start ,int end);
	public List<User>  getUsersByKeyWord(String key,int start,int end);
	public int getUsersCount();
}
