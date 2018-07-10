package com.zhbit.Bookmanage.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.service.ReadersService;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;

@SuppressWarnings("serial")
@Controller("Reader_modify")
@Scope(value="prototype")
public class Reader_modify extends ActionSupport{
	Readers readers;
	@Resource(name="readersService")
	ReadersService readersService;
	@Resource
	HttpSession session;
	@Resource
	HttpServletRequest request;
	public Readers getReaders() {
		return readers;
	}
	public void setReaders(Readers readers) {
		this.readers = readers;
	}
	public ReadersService getReadersService() {
		return readersService;
	}
	public void setReadersService(ReadersService readersService) {
		this.readersService = readersService;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
public Reader_modify(){
		
	}

public String execute() {
	Readers r = new Readers();
	String Readerids=request.getParameter("readerid");
	r=readersService.getReaders(Readerids);
			try {
				session.setAttribute("list",r);
				return "Success";
			} catch (Exception e) {
				System.out.println("input c");
				e.printStackTrace();
				return null;
			}
	
}
}


