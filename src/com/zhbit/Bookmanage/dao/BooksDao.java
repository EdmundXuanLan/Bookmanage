package com.zhbit.Bookmanage.dao;
import java.util.List;
import com.zhbit.Bookmanage.domain.Books;
public interface BooksDao {
public void save (Books books);
public void delete (Books books);
public void update (Books books);
public Books getOneBooks(String bookid);
public List<Books> getBooks();
public List<Books> getBooksByBn (String bookname);
public List<Books> getBooksByBa (String bookauthor);
public List<Books> getBooksBypub (String bookpub);
public List<Books> getBooksBybp (String bookprice);
public List<Books> getBooks(String bookname);
public List<Books> getBooksStyle(String bookstyleno);
}