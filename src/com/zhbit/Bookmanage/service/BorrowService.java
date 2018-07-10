package com.zhbit.Bookmanage.service;
import java.util.List;

import com.zhbit.Bookmanage.domain.Books;
import com.zhbit.Bookmanage.domain.Borrow;

public interface BorrowService {
	public Borrow getBorrow(String borrowid);
	public void addNewBorrow(Borrow borrow);
	public List<Borrow> findAllBorrow();
	public List<Borrow> findBorrow(String readerid,String Bookid);
	public String getReaderName(String readerid);
	public String getBookName(String bookid);
	public String setTime();
	public String setFee(String borrowdate,String returndate) throws Exception;
	public void updateBorrow(Borrow borrow);
	public void deleteBorrow(Borrow borrow);
	public boolean checkId(String readerids,String bookids);
	public boolean checkfindId(String readerids,String booknames);
	public boolean checkIsBorrowed(String bookid);
	public Books setIsBorrowed(String bookid,String i);
}
