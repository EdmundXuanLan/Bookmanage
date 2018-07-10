package com.zhbit.Bookmanage.action;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.BooksService;
import com.zhbit.Bookmanage.domain.Books;

@SuppressWarnings("serial")
@Controller("Books_queryAction")
@Scope(value="prototype")
public class Books_queryAction extends ActionSupport{
	Books books;
	@Resource(name="booksService")
	BooksService booksService;
	@Resource
	HttpSession session;
	
	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
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
	
	public Books_queryAction(){
		
	}
	
	public String execute() {
		List<Books> list = booksService.findAllBooks();
		if (list != null && list.size() > 0) {
			//ActionContext.getContext().put("borrow", list);
			session.setAttribute("books_list", list);
			System.out.println("@#$$%%^^&^%%$"+list);
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
	        }单个取出*/
		System.out.println("@#$$%%^^&^%%$success");
		return "querySuccess";
	
	}

}
