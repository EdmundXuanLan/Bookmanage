package com.zhbit.Bookmanage.service.impl;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhbit.Bookmanage.dao.BorrowDao;
import com.zhbit.Bookmanage.domain.Books;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.service.BorrowService;

@Service("borrowService")
@Transactional
public class BorrowServiceBean implements BorrowService {
	@Resource
	private BorrowDao borrowDao;

	public BorrowDao getBorrowDao() {
		return borrowDao;
	}
	public void setBorrowDao(BorrowDao borrowDao) {
		this.borrowDao = borrowDao;
	}

	SessionFactory sessionFactory;
	public BorrowServiceBean(){
}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Borrow getBorrow(String borrowid){
		String borrowids;
		borrowids=borrowid;
		return borrowDao.getOneBorrow(borrowids);
	}
	@Override
	public void addNewBorrow(Borrow borrows){
			borrowDao.save(borrows);
	}
	
	
	@Override
	public List<Borrow> findAllBorrow(){
		return borrowDao.getBorrow();
	}
	
	@Override
	public List<Borrow> findBorrow(String readerid,String bookname){
		return borrowDao.findBorrowById(readerid, bookname);
	}
	
	@Override
	public String getReaderName(String readerid){
		String NAME;
		NAME=borrowDao.getReadersByID(readerid).getReadername();
		return NAME;
	}
	@Override
	public String getBookName(String bookid){
		String NAME;
		NAME=borrowDao.getBooksByID(bookid).getBookname();
		return NAME;
	}
	@Override
	public String setTime(){
		return borrowDao.getTime();     	
	}
	
	@Override
	public String setFee(String borrowdate,String returndate) throws Exception{
		return borrowDao.getFee(borrowdate,returndate);     	
	}
	
	@Override
	public void updateBorrow(Borrow borrow){
		borrowDao.update(borrow); 
	}
	
	@Override
	public void deleteBorrow(Borrow borrow){
		borrowDao.delete(borrow);
	}
	@Override
	public boolean checkId(String readerid,String bookid) {
		if(borrowDao.getReadersByID(readerid)!=null&&borrowDao.getBooksByID(bookid)!=null){
			return true;
		}
			return false;
	}
	@Override
	public boolean checkfindId(String readerids, String booknames) {
		if(readerids!=null&&booknames!=null)
		{
			System.out.println("b!=null,r!=null");
			if(borrowDao.getReadersByID(readerids)!=null&&borrowDao.checkBookname(booknames).size()>0){
				return true;
			}else return false;
		}else if(readerids!=null&&booknames==null){
			System.out.println("b=null,r!=null");
			if(borrowDao.getReadersByID(readerids)!=null){
				return true;
			}else{
				System.out.println("b=null,r!=null,none r");
				return false;
			}
		}else if(readerids==null&&booknames!=null){
			System.out.println("b!=null,r=null");
			if(borrowDao.checkBookname(booknames).size()>0){
				return true;
			}else{	
				System.out.println("b=!null,r=null,none b");
				return false;
			}
		}else{
			System.out.println("b=null,r=null");
			return false;
		}
	}
	@Override
	public Books setIsBorrowed(String bookid,String i) {
		Books b=borrowDao.getBooksByID(bookid);
		b.setIsborrowed(i);
		return b;
		
	}
	@Override
	public boolean checkIsBorrowed(String bookid) {
		return borrowDao.checkBorrow(bookid);
	}
}

