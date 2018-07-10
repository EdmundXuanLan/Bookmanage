package com.zhbit.Bookmanage.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.domain.Borrow;

@SuppressWarnings("serial")
@Controller("Borrow_queryAction")
@Scope(value="prototype")
public class Borrow_queryAction extends ActionSupport{
	Borrow borrow;
	@Resource(name="borrowService")
	BorrowService borrowService;
	@Resource
	HttpSession session;
	
	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
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
	
	public Borrow_queryAction(){
		
	}
	
	public String execute() {
		List<Borrow> list = borrowService.findAllBorrow();
		if (list != null && list.size() > 0) {
			//ActionContext.getContext().put("borrow", list);
			session.setAttribute("borrow_list", list);
		}
	/*for (Borrow b : list) {
			session.put("borrowid", b.getBorrowid());
			session.put("bookid", b.getBookid());
			session.put("readerid", b.getReaderid());
			session.put("borrowdate", b.getBorrowdate());
			session.put("returndate", b.getReturndate());
			session.put("readername", b.getReadername());
			session.put("bookname", b.getBookname());
			session.put("bookfee", b.getBookfee());
		}*/
		/*for (Borrow borrow1: list){
			System.out.println(borrow1.getBorrowid());
		}*/
		 /*for(Iterator<Borrow> it=list.iterator();it.hasNext();)
	        {
	            System.out.println(it.next().getBookid());
	        }*/
		return "querySuccess";
	
	}

}
