package com.zhbit.Bookmanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.Bookmanage.dao.UsersDao;

import com.zhbit.Bookmanage.domain.Users;
import com.zhbit.Bookmanage.service.UsersService;

@Service("usersService")
@Transactional
public class UsersServiceBean implements UsersService {
	@Resource
	UsersDao usersDao;

	SessionFactory sessionFactory;
	public UsersServiceBean(){
		
	}
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addNewUsers(Users users) {

		boolean isSameName=false;
		List<Users> user =  usersDao.getUsersByName(users.getUsersname());
		for (Users u: user){
			if (u.getUsersname().equals(users.getUsersname())){
				isSameName=true;
			}
		}
		if (!isSameName){
			usersDao.save(users);
		}else{
			throw new RuntimeException("已存在相同用户");
		}
	}

	@Override
	public List<Users> findAllUsers() {
		return usersDao.getUsers();
	}
	@Override
	public boolean ChackUsers(Users users) {
		
		try{
			System.out.println("这里执行22");
			List<Users> list =  usersDao.getLogin(users.getUsersname(),users.getPassword());
			//Query query=sessionFactory.getCurrentSession().createQuery("from Users where usersname=:usersname and password=:password");
			//query.setParameter("usersname", users.getUsersname());
			//query.setParameter("password", users.getPassword());
			//list=query.list();
			if (list.size()>0){
				System.out.println("登录成功");
				return true;
			}else {
				System.out.println("登录失败");
				return false;
			}	
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}


}
