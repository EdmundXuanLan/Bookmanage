package com.zhbit.Bookmanage.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BooksService;
import com.zhbit.Bookmanage.domain.Books;

@Controller("showSearchAction")
@Scope("prototype")
public class ShowSearchAction extends ActionSupport {

	Books books;
	@Resource
	BooksService booksService;
	@Resource
	HttpSession session;
	@Resource
	HttpServletRequest request;

	public ShowSearchAction() {

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

	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String ChackStyle(){
		String no=request.getParameter("bookstyleno");
		int a=Integer.parseInt(no);
		String bookstyleno="";
		switch(a){
		case 1:bookstyleno="修真小说";break;
		case 2:bookstyleno="穿越小说";break;
		case 3:bookstyleno="恐怖小说";break;
		case 4:bookstyleno="都市小说";break;
		case 5:bookstyleno="科幻小说";break;
		case 6:bookstyleno="仙侠小说";break;
		case 7:bookstyleno="言情小说";break;
		}
		System.out.println(bookstyleno);
		List<Books> Bookslist = booksService.findBooksStyle(bookstyleno);
		session.setAttribute("books_list", Bookslist);
		session.setAttribute("flag", "success");
		return "success";
	}
	public String execute() throws Exception {
		System.out.println(books.getBookname());
		
		if (books.getBookname()!= null) {
			List<Books> Bookslist = booksService.findBooks(books.getBookname());
			if (Bookslist != null && Bookslist.size() > 0) {

				System.out.println("showActionif执行");
				// books=Bookslist.get(0);
				// System.out.println(books.getBookid());
				session.setAttribute("books_list", Bookslist);
				session.setAttribute("flag", "success");
				return "success";

			}else{
			System.out.println("showActionifsuccess");
			session.setAttribute("flag", "false");
			return "success";
			}
		} else {
			System.out.println("showActionif执行input");
			return "input";
		}

	}
}
