package com.zhbit.Bookmanage.dao.impl;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.zhbit.Bookmanage.dao.BooksDao;
import com.zhbit.Bookmanage.dao.BorrowDao;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Books;

@Repository("booksDao")
public class BooksDaoBea implements BooksDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	public BooksDaoBea(){}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Books books){
		sessionFactory.getCurrentSession().save(books);		
	}
	
	@Override
	public void update(Books books){
		sessionFactory.getCurrentSession().update(books);
		
	}
	
	@Override
	public void delete(Books books){
		
		sessionFactory.getCurrentSession().delete(books);

	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public Books getOneBooks(String bookid){
		/*List<Borrow> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Borrow where bookid=:bookid");
		query.setParameter("bookid", bookid);
		list=query.list();
		Borrow b=list.get(0);*/
		return (Books) sessionFactory.getCurrentSession().get(Books.class,bookid);
		
		
	}
										
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooks(){
		return sessionFactory.getCurrentSession().createQuery("from Books").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooksByBn(String bookname){
		return sessionFactory.getCurrentSession().createQuery("from Books where bookname=:bookname").setParameter("bookname", bookname).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooksByBa(String bookauthor) {
		return sessionFactory.getCurrentSession().createQuery("from Books where bookauthor=:bookauthor").setParameter("bookauthor", bookauthor).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooksBypub(String bookpub){
		return sessionFactory.getCurrentSession().createQuery("from Books where bookpub=:bookpub").setParameter("bookpub",bookpub).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooksBybp(String bookprice){
		return sessionFactory.getCurrentSession().createQuery("from Books where bookprice=:bookprice").setParameter("bookprice",bookprice).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooks(String bookname){
		List<Books> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Books where bookname=:bookname");
		query.setParameter("bookname", bookname);
		list=query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> getBooksStyle(String bookstyleno){
		List<Books> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Books where bookstyleno=:bookstyleno");
		query.setParameter("bookstyleno",bookstyleno);
		list=query.list();
		return list;
	}
}
	