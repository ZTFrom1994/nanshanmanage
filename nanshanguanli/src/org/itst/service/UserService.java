package org.itst.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.itst.domain.User;

public interface UserService {
	/**
	 * 在这里注解后，方法的实现不用我们自己写，mybatis会自动帮我们实现，只需在conf.xml中配置后，直接调用就行
	 * @param u
	 * @return
	 */
//	@Insert("insert into users(username, password) values(#{username}, #{password})")
//	public int addUser(User u);
//	@Delete("delete from users where id=#{id}")
//	public int deleteUserById(int id);
//	@Update("update users set username=#{username},password=#{password} where id=#{id}")
//	public int updateUser(User u);
//	@Select("select * from users where id=#{id}")
//	public User getUserById(int id);
//	@Select("select * from users")
//	public List<User> getAllUsers();
	
	public void addUser(User u);
	public void deleteUserById(String id);
	public int updateUser(User u);
	public User getUserById(String id);
	public User getUserByName(String username);
	public List<User> getAllUsers();
	public String getUsersJsonByPage(int pageSize,int pageNow);
	public String getUsersJsonByKeyWord(String key,int pageSize,int pageNow);
}
