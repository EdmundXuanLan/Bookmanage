package com.zhbit.Bookmanage.action;
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
@Controller("Books_modifyAction")
@Scope(value="prototype")
public class Books_modifyAction extends ActionSupport{
	Books books;
	@Resource(name="booksService")
	BooksService booksService;
	@Resource
	HttpSession session;
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
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
public Books_modifyAction(){
		
	}

public String execute() {
	Books b = new Books();
	String bookids=request.getParameter("bookid");
	b=booksService.getBooks(bookids);	
			try {
				session.setAttribute("modify_books",b);
				return "modifySuccess";
			} catch (Exception e) {
				System.out.println("input c");
				e.printStackTrace();
				return null;
			}
	
}
}


