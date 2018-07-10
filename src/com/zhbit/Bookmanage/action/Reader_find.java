package com.zhbit.Bookmanage.action;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.service.ReadersService;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;
@SuppressWarnings("serial")
@Controller("Reader_find")
@Scope(value="prototype")

public class Reader_find extends ActionSupport{
	Readers readers;
	@Resource(name="readersService")
	ReadersService readersService;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpSession session;

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

public String execute() {
		String Readerid=request.getParameter("readerid");
		if(Readerid.length()==0) Readerid=null;
		String Readername=request.getParameter("readername");
		if(Readername.length()==0) Readername=null;
		String Readersex=request.getParameter("readersex");
		System.out.println("@#$%^&*"+Readersex);
		if(Readersex.equals("1")){
			Readersex="男";
		}else{
			Readersex="女";
		}
		String Phonenumber=request.getParameter("phonenumber");
		if(Phonenumber.length()==0) Phonenumber=null;
		
		List<Readers> list=readersService.findReaders(Readerid, Readername, Readersex, Phonenumber);
		if (list != null && list.size() > 0) {
			session.setAttribute("list", list);
			return "Success";
		}else{
			return "Faild";
		}
		
	}
}




	
	
