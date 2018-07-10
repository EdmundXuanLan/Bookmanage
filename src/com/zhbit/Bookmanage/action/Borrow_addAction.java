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
import com.zhbit.Bookmanage.service.BooksService;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.domain.Borrow;

@SuppressWarnings("serial")
@Controller("Borrow_addAction")
@Scope(value="prototype")
public class Borrow_addAction extends ActionSupport {
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
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
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
	
	public String execute() {
		Borrow b = new Borrow();
		String Bookids=request.getParameter("bookid");	
		System.out.println("书本号为："+Bookids);
		String Readerids=request.getParameter("readerid");
		System.out.println("读者号为："+Readerids);
		if((!borrowService.checkId(Readerids, Bookids))||(!(borrowService.checkIsBorrowed(Bookids)))){
			System.out.println("idwrong");
			return "addIdWrong";
		}
		System.out.println("ID检测返回值为："+borrowService.checkId(Readerids, Bookids));
		System.out.println("借阅状态检测返回值为："+borrowService.checkIsBorrowed(Bookids));
		b.setBookid(Bookids);
		b.setReaderid(Readerids);
		b.setReadername(borrowService.getReaderName(Readerids));
		b.setBookname(borrowService.getBookName(Bookids));
		b.setBorrowdate(borrowService.setTime());
		b.setBookfee(null);
		b.setReturndate(null);
		try {

			if ((b.getBookname()!=null)&&(b.getReadername()!=null)) {
				borrowService.addNewBorrow(b);
				booksService.updateBooks(borrowService.setIsBorrowed(Bookids,"0"));   
				session.put("borrowid", b.getBorrowid());
				session.put("bookid", b.getBookid());
				session.put("readerid", b.getReaderid());
				session.put("borrowdate", b.getBorrowdate());
				session.put("returndate", b.getReturndate());
				session.put("readername", b.getReadername());
				session.put("bookname", b.getBookname());
				session.put("bookfee", b.getBookfee());
				System.out.println("addSuccess");
				return "addSuccess";
			} else {
				System.out.println("input e");
				return "addFaild";
			}
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "addFaild";
		}
	}
}
