package com.zhbit.Bookmanage.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name = "Readers")  
@Table(name = "Readers") 
public class Readers {
	private String readerid;
	private String readername;
	private String readerpassword;
	private String readersex;
	private String phonenumber;
	private Set<Borrow> borrow= new HashSet<Borrow>(0);  // 开始长度为0


	public Set<Borrow> getBorrow() {
		return borrow;
	}
	public void setBorrow(Set<Borrow> borrow) {
		this.borrow = borrow;
	}
	public Readers(){
		
	}
	public String getReaderid() {
		return readerid;
	}
	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public String getReaderpassword() {
		return readerpassword;
	}
	public void setReaderpassword(String readerpassword) {
		this.readerpassword = readerpassword;
	}
	public String getReadersex() {
		return readersex;
	}
	public void setReadersex(String readersex) {
		this.readersex = readersex;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
