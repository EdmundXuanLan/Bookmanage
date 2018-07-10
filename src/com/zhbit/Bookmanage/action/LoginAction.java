package com.zhbit.Bookmanage.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.UsersService;
import com.zhbit.Bookmanage.domain.Users;


@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport{
	Users users;
@Resource
	UsersService usersService;
	
	public LoginAction(){
		
	}

	
	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}




	public UsersService getUsersService() {
		return usersService;
	}


	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}


	public String execute()throws Exception{
		//Users u=new Users("chaomian","666666");
		//if(users.getUsersname().equals(u.getUsersname())){
		//System.out.println("users.name:"+users.getUsersname());
		
		if(usersService.ChackUsers(users)){
			System.out.print("success");
			return "success";
		}else{
			System.out.print("input");
			return "input";
		}

	}
}
