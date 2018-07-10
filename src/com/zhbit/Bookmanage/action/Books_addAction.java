package com.zhbit.Bookmanage.action;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BooksService;
import com.zhbit.Bookmanage.domain.Books;



@SuppressWarnings("serial")
@Controller("Books_addAction")
@Scope(value="prototype")
public class Books_addAction extends ActionSupport {
	Books books;
	@Resource(name="booksService")
	BooksService booksService;
	@Resource
	HttpServletRequest request;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public BooksService getBooksService() {
		return booksService;
	}
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	
	public String execute() {
		Books b = new Books();
		String Bookids=request.getParameter("bookid");
		String Booknames=request.getParameter("bookname");
		String Bookstylenos=request.getParameter("bookstyleno");
		String Bookauthors=request.getParameter("bookauthor");
		String Bookpubs=request.getParameter("bookpub");
		String Bookpubdates=request.getParameter("bookpubdate");
		String Bookindates=request.getParameter("bookindate");
		String Isborroweds=request.getParameter("isborrowed");
		String Bookprices=request.getParameter("bookprice");
		System.out.println(Bookids);
		b.setBookid(Bookids);
		b.setBookname(Booknames);
		b.setBookstyleno(Bookstylenos);
		b.setBookauthor(Bookauthors);
		b.setBookpub(Bookpubs);
		b.setBookpubdate(Bookpubdates);
		b.setBookindate(Bookindates);
		b.setIsborrowed(Isborroweds);
		b.setBookprice(Bookprices);
		System.out.println(b.getBookid());
//		b.setReadername(borrowService.getReaderName(Readerids));
//		b.setBookname(borrowService.getBookName(Bookids));		
		try {

			if ((b.getBookname()!=null)&&(b.getBookid()!=null)) {
				booksService.addNewBooks(b);
				System.out.println("addSuccess");
				return "addSuccess";
			} else {
				System.out.println("input e");
				return "addFaild";
			}
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "addFaild";
		}
	}
}
