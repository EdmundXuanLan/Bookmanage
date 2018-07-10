package com.zhbit.Bookmanage.domain;

public class Books {
	private String bookid;
	private String bookname;
	private String bookstyleno;
	private String bookauthor;
	private String bookpub;//出版社
	private String bookpubdate;//出版日期
	private String bookindate;//登记日期
	private String isborrowed;
	private String bookprice;
	public Books(){}
	public Books(String bookid,String bookname,String bookstyleno,String bookauthor,String bookpub,String bookpubdate,String bookindate,String isborrowed,String bookprice)
	{
		super();
		this.bookid=bookid;
		this.bookname=bookname;
		this.bookstyleno=bookstyleno;
		this.bookauthor=bookauthor;
		this.bookpub=bookpub;
		this.bookpubdate=bookpubdate;
		this.bookindate=bookindate;
		this.isborrowed=isborrowed;
		this.bookprice=bookprice;
	}
	
	
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookstyleno() {
		return bookstyleno;
	}
	public void setBookstyleno(String bookstyleno) {
		this.bookstyleno = bookstyleno;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookpub() {
		return bookpub;
	}
	public void setBookpub(String bookpub) {
		this.bookpub = bookpub;
	}
	public String getBookpubdate() {
		return bookpubdate;
	}
	public void setBookpubdate(String bookpubdate) {
		this.bookpubdate = bookpubdate;
	}
	public String getBookindate() {
		return bookindate;
	}
	public void setBookindate(String bookindate) {
		this.bookindate = bookindate;
	}
	public String getIsborrowed() {
		return isborrowed;
	}
	public void setIsborrowed(String isborrowed) {
		this.isborrowed = isborrowed;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}

}
