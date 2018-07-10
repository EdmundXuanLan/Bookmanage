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
import com.zhbit.Bookmanage.service.ReadersService;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;



@SuppressWarnings("serial")
@Controller("Reader_add")
@Scope(value="prototype")
public class Reader_add extends ActionSupport {
	Readers readers;
	@Resource(name="readersService")
	ReadersService readersService;
	@Resource
	HttpServletRequest request;
	private Map<String,Object> session = ActionContext.getContext().getSession();
	
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute() {
		Readers r = new Readers();
		String Readerids=request.getParameter("readerid");
		String Readernames=request.getParameter("readername");
		String Readersexs=request.getParameter("readersex");
		if(Readersexs.equals("1")){
			Readersexs="男";
		}else{
			Readersexs="女";
		}
		String Readerpasswords=request.getParameter("readerpassword");
		String phonenumbers=request.getParameter("phonenumber");
		r.setReaderid(Readerids);
		r.setReadername(Readernames);
		r.setReadersex(Readersexs);
		r.setReaderpassword(Readerpasswords);
		r.setPhonenumber(phonenumbers);
		
		try {
				readersService.add(r);
				session.put("readerid", r.getReaderid());
				session.put("readername", r.getReadername());
				session.put("readersex", r.getReadersex());
				session.put("readerpassword", r.getReaderpassword());
				session.put("phonenumber", r.getPhonenumber());
				System.out.println("Success");
				return "Success";
		
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "Faild";
		}
	}
}
