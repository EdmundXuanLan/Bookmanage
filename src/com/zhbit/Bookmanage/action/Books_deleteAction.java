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
@Controller("Books_deleteAction")
@Scope(value="prototype")
public class Books_deleteAction extends ActionSupport{
	Books books;
	@Resource(name="booksService")
	BooksService booksService;
	@Resource
	HttpServletRequest request;
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
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() {
		Books b = new Books();
		String booksids=request.getParameter("bookid");
		b=booksService.getBooks(booksids);
		int i = Integer.parseInt(b.getIsborrowed()); 
		System.out.println(i);
		System.out.println(b.getIsborrowed());
		if(i==0){return "deleteFaild"; }
		try {
			booksService.deleteBooks(b);
			return "deleteSuccess";
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "deleteFaild";
		}
	}
}





