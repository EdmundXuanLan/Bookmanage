package com.zhbit.Bookmanage.dao;

import java.util.List;

import com.zhbit.Bookmanage.domain.Users;


public interface UsersDao {

	public void save(Users users);
	public void update(Users users);
	public void delete(String... usersIds);
	public Users getUsers(Integer usersId);
	public List<Users> getUsers();
	public List<Users> getUsersByName(String usersname);
	public List<Users> getLogin(String usersname,String password);
	
}
