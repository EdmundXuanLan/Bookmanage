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
@Controller("Reader_save")
@Scope(value="prototype")
public class Reader_save extends ActionSupport{
	Readers readers;
	Borrow borrow;
	@Resource(name="readersService")
	ReadersService readersService;
	@Resource
	HttpServletRequest request;
	@Resource(name="borrowService")
	BorrowService borrowService;
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


	public String execute() {
		int i;
		Readers r = new Readers();
		String readerids=request.getParameter("readerid");
		System.out.println(readerids);
		String readernames=request.getParameter("readername");
		String readersexs=request.getParameter("readersex");
		if(readersexs.equals("1")){
			readersexs="男";
		}else{
			readersexs="女";
		}
		String readerpasswords=request.getParameter("readerpassword");
		String phonenumbers=request.getParameter("phonenumber");
		r=readersService.getReadersByName(readernames);
//		r=readersService.getReaders(readerids);
/*	if(!r.getReadername().equals(readernames)){
		List<Borrow> blist=readersService.getBorrow(readerids);
		if(blist.size()>0){
			for (i=0;i<blist.size();i++){
				blist.get(i).setReadername(r.getReadername());
				borrowService.updateBorrow(blist.get(i)); 
			}
		}
		}*/
		r.setReaderid(readerids);
		r.setReadername(readernames);
		r.setReadersex(readersexs);
		r.setReaderpassword(readerpasswords);
		r.setPhonenumber(phonenumbers);
		try {
			readersService.update(r);
			session.put("readerid", r.getReaderid());
			session.put("readername", r.getReadername());
			session.put("readersex", r.getReadersex());
			session.put("readerpassword", r.getReaderpassword());
			session.put("phonenumber", r.getPhonenumber());
			return "Success";
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "Faild";
		}
	}
}





