package com.zhbit.Bookmanage.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.domain.Borrow;

@SuppressWarnings("serial")
@Controller("Borrow_modifyAction")
@Scope(value="prototype")
public class Borrow_modifyAction extends ActionSupport{
	Borrow borrow;
	@Resource(name="borrowService")
	BorrowService borrowService;
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
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
public Borrow_modifyAction(){
		
	}

public String execute() {
	Borrow b = new Borrow();
	String borrowids=request.getParameter("borrowid");
	b=borrowService.getBorrow(borrowids);	
	if(b.getReturndate()!=null){
		return "saveEd";
	}
			try {
				session.setAttribute("modify_borrow",b);
				return "modifySuccess";
			} catch (Exception e) {
				System.out.println("input c");
				e.printStackTrace();
				return null;
			}
	
}
}


