package com.zhbit.Bookmanage.service;
import java.util.List;

import com.zhbit.Bookmanage.domain.Users;


public interface UsersService {


	public void addNewUsers(Users users);
	
	public List<Users> findAllUsers();
	public boolean ChackUsers(Users users);

}