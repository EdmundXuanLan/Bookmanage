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
@Controller("Borrow_findAction")
@Scope(value="prototype")

public class Borrow_findAction extends ActionSupport{
	Borrow borrow;
	@Resource(name="borrowService")
	BorrowService borrowService;
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



public String execute() {
		String Bookname=request.getParameter("bookname");
		if(Bookname.length()==0) Bookname=null;
		String Readerids=request.getParameter("readerid");
		if(Readerids.length()==0) Readerids=null;
		if(!borrowService.checkfindId(Readerids,Bookname)){
			System.out.println("check错了");
			return "findNullId";
		}
		List<Borrow> list=borrowService.findBorrow(Readerids, Bookname);
		if (list != null && list.size() > 0) {
			session.setAttribute("borrow_list", list);
			return "findSuccess";
		}else{
			return "findFaild";
		}
		
	}
}




	
	
