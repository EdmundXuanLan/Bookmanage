package com.zhbit.Bookmanage.action;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BooksService;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.domain.Borrow;
@SuppressWarnings("serial")
@Controller("Borrow_returnbookAction")
@Scope(value="prototype")
public class Borrow_returnbookAction  extends ActionSupport{
	Borrow borrow;
	@Resource(name="borrowService")
	BorrowService borrowService;
	@Resource(name="booksService")
	BooksService booksService;
	public BooksService getBooksService() {
		return booksService;
	}
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	@Resource
	HttpServletRequest request;
	private Map<String,Object> session = ActionContext.getContext().getSession();
	public Map getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Borrow getBorrow() {
		return borrow;
	}
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	public BorrowService getBorrowService() {
		return borrowService;
	}
	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
public String execute() throws Exception {
		
		Borrow b = new Borrow();
		String borrowids=request.getParameter("borrowid");
		b=borrowService.getBorrow(borrowids);
		if(b.getReturndate()!=null){
			return "returnEd";
		}
		b.setReturndate(borrowService.setTime());
		b.setBookfee(borrowService.setFee(b.getBorrowdate(), b.getReturndate()));
		session.put("borrowid", b.getBorrowid());
		session.put("bookid", b.getBookid());
		session.put("readerid", b.getReaderid());
		session.put("borrowdate", b.getBorrowdate());
		session.put("returndate", b.getReturndate());
		session.put("readername", b.getReadername());
		session.put("bookname", b.getBookname());
		session.put("bookfee", b.getBookfee());
		try {
			booksService.updateBooks(borrowService.setIsBorrowed(b.getBookid(),"1"));
			borrowService.updateBorrow(b);
			return "returnSuccess";
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "returnFaild";
		}
	}
}

	
	
