package com.zhbit.Bookmanage1.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.Bookmanage.dao.UsersDao;
import com.zhbit.Bookmanage.domain.Users;
import com.zhbit.Bookmanage.service.UsersService;

@Service("usersService")
@Transactional
public abstract class UsersServiceBean implements UsersService {
	@Resource
	private UsersDao usersDao;

	SessionFactory sessionFactory;
	public UsersServiceBean(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean ChackUsers(Users users) {
	
		

		Session session=null;
		try{
		
			session=sessionFactory.openSession();
		
			String hql="from Users where username=? and password=?";
		
			Query query=session.createQuery(hql);
		
			query.setParameter(0, users.getUsersname());
			query.setParameter(1, users.getPassword());
	
			List list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
	
			session.close();
		}


	}
}
