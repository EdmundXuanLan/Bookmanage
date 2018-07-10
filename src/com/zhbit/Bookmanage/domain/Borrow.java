package com.zhbit.Bookmanage.domain;
import java.util.Date;
public class Borrow {
	private String borrowid;
	private String bookid;
	private String readerid;
	private String borrowdate;
	private String returndate;
	private String readername;
	private String bookname;
	private String bookfee;
	public Borrow(){}
	public Borrow(String bookid,String readerid,String borrowdate,String returndate,String readername,String bookname,String bookfee)
	{
		super();
		this.bookid=bookid;
		this.readerid=readerid;
		this.borrowdate=borrowdate;
		this.returndate=returndate;
		this.readername=readername;
		this.bookname=bookname;
		this.bookfee=bookfee;
		
	}
	public String getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(String borrowid) {
		this.borrowid = borrowid;
	}
	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getReaderid() {
		return readerid;
	}

	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}

	public String getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getReadername() {
		return readername;
	}

	public void setReadername(String readername) {
		this.readername = readername;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookfee() {
		return bookfee;
	}

	public void setBookfee(String bookfee) {
		this.bookfee = bookfee;
	}

	
}
