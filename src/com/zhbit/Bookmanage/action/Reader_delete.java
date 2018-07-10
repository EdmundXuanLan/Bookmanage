package com.zhbit.Bookmanage.action;
import java.text.SimpleDateFormat;
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
@Controller("Reader_delete")
@Scope(value="prototype")
public class Reader_delete extends ActionSupport{
	Readers readers;
	Borrow borrow;
	@Resource(name="readersService")
	ReadersService readersService;
	@Resource
	HttpServletRequest request;
	@Resource(name="borrowService")
	BorrowService borrowService;

	
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
		Readers r = new Readers();
		String readerids=request.getParameter("readerid");
		r=readersService.getReaders(readerids);
//		List<Borrow> blist=readersService.getBorrow(readerids);
		try {
			/*if(blist.size()>0){
				for (int i=0;i<blist.size();i++){
					if(blist.get(i).getReturndate()==null){
						return "Borrowing";
					}
					borrowService.deleteBorrow(blist.get(i)); 
				}
			}*/
			readersService.delete(r);
			return "Success";
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "Faild";
		}
	}
}





