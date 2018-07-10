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
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.domain.Borrow;
@SuppressWarnings("serial")
@Controller("Borrow_saveAction")
@Scope(value="prototype")
public class Borrow_saveAction extends ActionSupport{
	Borrow borrow;
	@Resource(name="borrowService")
	BorrowService borrowService;
	@Resource
	HttpServletRequest request;
	private Map<String,Object> session = ActionContext.getContext().getSession();
	public Map<String, Object> getSession() {
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
	
	public String execute() {
		
		Borrow b = new Borrow();
		String borrowids=request.getParameter("borrowid");
		b=borrowService.getBorrow(borrowids);
		if(b.getReturndate()!=null){
			return "saveEd";
		}
		String Bookids=request.getParameter("bookid");
		String Readerids=request.getParameter("readerid");
//		(!b.getReaderid().equals(Readerids)||!b.getBookid().equals(Bookids))&&
		if(!borrowService.checkId(Readerids, Bookids)){
			session.put("borrowid", b.getBorrowid());
			return "saveFaild";
		}
		b.setBookid(Bookids);
		b.setReaderid(Readerids);
		b.setBookname(borrowService.getBookName(Bookids));
		b.setReadername(borrowService.getReaderName(Readerids));
		b.setBookfee(null);
		try {
			borrowService.updateBorrow(b);
			session.put("borrowid", b.getBorrowid());
			session.put("bookid", b.getBookid());
			session.put("readerid", b.getReaderid());
			session.put("borrowdate", b.getBorrowdate());
			session.put("returndate", b.getReturndate());
			session.put("readername", b.getReadername());
			session.put("bookname", b.getBookname());
			session.put("bookfee", b.getBookfee());
			return "saveSuccess";
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			session.put("borrowid", b.getBorrowid());
			return "saveFaild";
		}
	}
}


	
	
