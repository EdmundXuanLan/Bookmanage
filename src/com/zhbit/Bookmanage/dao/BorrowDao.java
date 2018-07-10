package com.zhbit.Bookmanage.dao;
import java.util.Date;
import java.util.List;
import com.zhbit.Bookmanage.domain.Readers;
import com.zhbit.Bookmanage.domain.Books;
import com.zhbit.Bookmanage.domain.Borrow;
public interface BorrowDao {
public void save (Borrow borrow);
public void delete (Borrow borrow);
public Borrow getOneBorrow(String borrowid);
public void update (Borrow borrow);
public List<Borrow> getBorrow();
public boolean checkBorrow(String bookid);
public List<Books> checkBookname(String bookname);
public Books getBooksByID(String bookid);
public Readers getReadersByID(String readerid);
public List<Borrow> findBorrowById (String readerid,String bookid);
public String getTime();
public  int getDayLength(String start_date,String end_date) throws Exception;
public  Date getStrToDate(String date,String fomtter) throws Exception;
public String getFee(String borrowdate,String returndate) throws Exception;
}