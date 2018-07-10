package com.zhbit.Bookmanage.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhbit.Bookmanage.dao.BooksDao;
import com.zhbit.Bookmanage.domain.Books;
import com.zhbit.Bookmanage.service.BooksService;

@Service("booksService")
@Transactional
public class BooksServiceBean implements BooksService {
	@Resource
	private BooksDao booksDao;

	public BooksDao getBooksDao() {
		return booksDao;
	}
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	SessionFactory sessionFactory;
	public BooksServiceBean(){
}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Books getBooks(String bookid){
		String bookids;
		bookids=bookid;
		return booksDao.getOneBooks(bookids);
	}
	
	@Override
	public void addNewBooks(Books books){
		//boolean isSameBorrow=false;
		//if(borrowDao.checkBorrow(borrows.getBookid())!=null){
	//		isSameBorrow=true;
	//	};
	//	if (!isSameBorrow){
			booksDao.save(books);
			
	//	}else{
	//		throw new RuntimeException("已借阅该书，不得重复");
//		}
	}
	
	@Override
	public List<Books> findAllBooks(){
		return booksDao.getBooks();
	}
	
	@Override
	public List<Books> findBooksByBn(String bookname){
		
		return booksDao.getBooksByBn(bookname);
	}
	
	@Override
	public List<Books> findBooksByBa(String bookauthor){
		return booksDao.getBooksByBa(bookauthor);
	}
	
	@Override
	public void updateBooks(Books books){
		booksDao.update(books); 
	}
	
	@Override
	public void deleteBooks(Books books){
		booksDao.delete(books);
	}
	
	@Override
	public List<Books> findBooksBypub(String bookpub){
		return booksDao.getBooksBypub(bookpub);
	}
	
	@Override
	public List<Books> findBooksBybp(String bookprice){
		return booksDao.getBooksBybp(bookprice);
	}
	
	@Override
	public List<Books> findBooks(String bookname){
		return booksDao.getBooks(bookname);
	}
	@Override
	public List<Books> findBooksStyle(String bookstyleno){
		return booksDao.getBooksStyle(bookstyleno);
	}
}
