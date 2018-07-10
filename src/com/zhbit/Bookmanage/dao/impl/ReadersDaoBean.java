package com.zhbit.Bookmanage.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.Bookmanage.dao.ReadersDao;
import com.zhbit.Bookmanage.dao.BorrowDao;
import com.zhbit.Bookmanage.domain.Books;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;
import com.zhbit.Bookmanage.domain.Users;

@Repository("readersDao")
public class ReadersDaoBean implements ReadersDao{
	@Autowired
	private SessionFactory sessionFactory;
	public ReadersDaoBean(){
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Readers readers) {
		sessionFactory.getCurrentSession().save(readers);
	}
	@Override
	public void update(Readers readers) {
		Transaction tx = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(readers);

	
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
	@Override
	public void delete(Readers readers) {
		sessionFactory.getCurrentSession().delete(readers);
	}
	@Override
	public Readers getReaders(String readersId) {
		return (Readers) sessionFactory.getCurrentSession().get(Readers.class,readersId);
		}
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> getBorrow(String readerId) {
		List<Borrow> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Borrow where readerid=:readerids");  
		query.setParameter("readerids", readerId);
		list=query.list();
		return list;	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Readers> findReaders(String readerid, String readername,  String readersex,
			String phonenumber) {
		int a = 0,b=0,c=0,d=0;
		String	hql="from Readers where ";
		if(readerid!=null){
			a=1;
			hql+="readerid=:readerids";
		}
		if(readername!=null){
			b=1;
			if(a==1){
				hql+=" and readername=:readernames";
			}else{
				hql+="readername=:readernames";
			}
		}
		if(readersex!=null){
			c=1;
			if(a==1||b==1){
				hql+=" and readersex=:readersexs";
			}else{
				hql+="readersex=:readersexs";
			}
		}
		if(phonenumber!=null){
			d=1;
			if(a==1||b==1||c==1){
				hql+=" and phonenumber=:phonenumbers";
			}else{
				hql+="phonenumber=:phonenumbers";
			}
		}
		List<Readers> list;
		Query query=sessionFactory.getCurrentSession().createQuery(hql); 
		if(a==1)
		{
			query.setParameter("readerids", readerid);
		}
		if(b==1){
			query.setParameter("readernames", readername);
		}
		if(c==1){
			query.setParameter("readersexs", readersex);
		}
		if(d==1){
			query.setParameter("phonenumbers", phonenumber);
		}
		list=query.list();
		return list;	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Readers> getReaders() {
		
		return sessionFactory.getCurrentSession().createQuery("from Readers").list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Readers> getReadersById(String readerid) {
		return sessionFactory.getCurrentSession().createQuery("from Readers where readerid=:readerid").setParameter("readerid", readerid).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Readers> getLogin(String readerid,String readerpassword) {
		List<Readers> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Readers where readerid=:readerid and readerpassword=:readerpassword");
		query.setParameter("readerid", readerid);
		query.setParameter("readerpassword", readerpassword);
		list=query.list();
		return list;
	}
	@Override
	public Readers getReadersByName(String readersName) {
		List<Readers> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Readers where readername=:readername");  
		query.setParameter("readername", readersName);
		list=query.list();
		return list.get(0);
	}
}
