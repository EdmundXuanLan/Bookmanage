package com.zhbit.Bookmanage.service;
import java.util.List;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Books;

public interface BooksService {
	public Books getBooks(String bookid);
	public void addNewBooks(Books books);
	public List<Books> findAllBooks();
	public List<Books> findBooksByBn(String bookname);
	public List<Books> findBooksByBa(String bookauthor);
	public void updateBooks(Books books);
	public void deleteBooks(Books books);
	public List<Books> findBooksBypub(String bookpub);
	public List<Books> findBooksBybp(String bookpricec);
	public List<Books> findBooks(String bookname);
	public List<Books> findBooksStyle(String bookstyleno);
}
