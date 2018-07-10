package com.zhbit.Bookmanage.dao;

import java.util.List;

import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;

public interface ReadersDao {
	public void save(Readers readers);
	public void update(Readers readers);
	public void delete(Readers readers);
	public Readers getReaders(String readersId);
	public Readers getReadersByName(String readersName);
	public List<Readers> getReaders();
	public List<Borrow> getBorrow(String readersId);
	public List<Readers> findReaders(String readerid,String readername,
	String readersex,String phonenumber);
	public List<Readers> getReadersById(String readersid);
	public List<Readers> getLogin(String readerid,String readerpassword);
}
