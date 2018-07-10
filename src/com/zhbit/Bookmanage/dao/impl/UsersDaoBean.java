package com.zhbit.Bookmanage.dao.impl;

import java.util.List;


import org.hibernate.Query;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.Bookmanage.dao.UsersDao;
import com.zhbit.Bookmanage.domain.Users;




@Repository("usersDao")
public class UsersDaoBean implements UsersDao{
	@Autowired
	private SessionFactory sessionFactory;
	public UsersDaoBean(){
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Users users) {
		sessionFactory.getCurrentSession().save(users);
	}

	@Override
	public void update(Users users) {
		sessionFactory.getCurrentSession().update(users);
	}

	@Override
	public void delete(String... usersIds) {
		for (String usersId: usersIds){
			sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Users.class, usersId));
		}
		
	}
	@Override
	public Users getUsers(Integer userstId) {
		return (Users) sessionFactory.getCurrentSession().get(Users.class,userstId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsers() {
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsersByName(String usersname) {
		return sessionFactory.getCurrentSession().createQuery("from Users where usersname=:usersname").setParameter("usersname", usersname).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getLogin(String usersname,String password) {
		List<Users> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Users where usersname=:usersname and password=:password");
		query.setParameter("usersname", usersname);
		query.setParameter("password", password);
		list=query.list();
		return list;
	}
	
}
