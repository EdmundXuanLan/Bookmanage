package com.zhbit.Bookmanage.action;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BooksService;
import com.zhbit.Bookmanage.domain.Books;
@SuppressWarnings("serial")
@Controller("Books_findAction")
@Scope(value="prototype")

public class Books_findAction extends ActionSupport{
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



	@Resource
	HttpSession session;
	
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



public String execute() {
		String shuru=request.getParameter("shuru");
		String bookselect=request.getParameter("bookselect");
		System.out.println("@#$%^&*"+bookselect);
		System.out.println("@#$%^&*"+shuru);
		if(bookselect.equals("bookname")) { 
			String Bookname=request.getParameter("shuru");
				List<Books> list=booksService.findBooksByBn(Bookname);
				session.setAttribute("books_list", list);
		return "findSuccess";}
		
		else if(bookselect.equals("bookauthor"))  {
			String Bookauthor=request.getParameter("shuru");
		List<Books> list=booksService.findBooksByBa(Bookauthor);
		session.setAttribute("books_list", list);
		return "findSuccess";	
		}
		else if(bookselect.equals("bookpub"))  {
			String Bookauthor=request.getParameter("shuru");
		List<Books> list=booksService.findBooksBypub(Bookauthor);
		session.setAttribute("books_list", list);
		return "findSuccess";	
		}
		else if(bookselect.equals("bookprice"))  {
			String Bookauthor=request.getParameter("shuru");
		List<Books> list=booksService.findBooksBybp(Bookauthor);
		session.setAttribute("books_list", list);
		return "findSuccess";	
		}
		
		else{return "findFaild";}
		
		
		
	}
}




	
	
