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
import com.zhbit.Bookmanage.domain.Books;
@SuppressWarnings("serial")
@Controller("Books_saveAction")
@Scope(value="prototype")
public class Books_saveAction extends ActionSupport{
	Books books;
	@Resource(name="booksService")
	BooksService booksService;
	@Resource
	HttpServletRequest request;
	private Map<String,Object> session = ActionContext.getContext().getSession();
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public BooksService getBooksService() {
		return booksService;
	}
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() {
		
		Books b = new Books();
		String booksids=request.getParameter("bookid");
		b=booksService.getBooks(booksids);
		if(b.getBookid()==null){
			return "saveEd";
		}
		String Bookids=request.getParameter("bookid");
		String Booknames=request.getParameter("bookname");
		String Bookstylenos=request.getParameter("bookstyleno");
		String Bookauthors=request.getParameter("bookauthor");
		String Bookpubs=request.getParameter("bookpub");
		String Bookpubdates=request.getParameter("bookpubdate");
		String Bookindates=request.getParameter("bookindate");
		String Isborroweds=request.getParameter("isborrowed");
		String Bookprices=request.getParameter("bookprice");
/*		if(!borrowService.checkId(Readerids, Bookids)){
//			session.setAttribute"borrowid",b.getBorrowid());
			session.put("borrowid", b.getBorrowid());
			return "saveFaild";
		}*/
		b.setBookid(Bookids);
		b.setBookname(Booknames);
		b.setBookstyleno(Bookstylenos);
		b.setBookauthor(Bookauthors);
		b.setBookpub(Bookpubs);
		b.setBookpubdate(Bookpubdates);
		b.setBookindate(Bookindates);
		b.setIsborrowed(Isborroweds);
		b.setBookprice(Bookprices);
		try {
			booksService.updateBooks(b);
			session.put("bookid", b.getBookid());
			session.put("bookname", b.getBookname());
			session.put("bookstyleno", b.getBookstyleno());
			session.put("bookauthor", b.getBookauthor());
			session.put("bookpub", b.getBookpub());
			session.put("bookpubdate", b.getBookpubdate());
			session.put("bookindate", b.getBookindate());
			session.put("isborrowed", b.getIsborrowed());
			session.put("bookprice", b.getBookprice());
			return "saveSuccess";
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			session.put("bookid", b.getBookid());
			return "saveFaild";
		}
	}
}


	
	
