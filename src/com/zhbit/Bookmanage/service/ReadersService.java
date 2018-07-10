package com.zhbit.Bookmanage.service;






import java.util.List;

import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;


public interface ReadersService {
	public boolean add(Readers readers);
	public boolean update(Readers readers);
	public void delete(Readers readers);
	public Readers getReaders(String readerId);
	public Readers getReadersByName(String readerName);
	public List<Readers> getAllReader();
	public List<Borrow> getBorrow(String readerId); 
	public List<Readers> findReaders(String readerid,String readername,
		String readersex,String phonenumber);
	public boolean ChackPassword(Readers readers,Readers newreaders,Readers chackreaders);
	public boolean ChackReaders(Readers readers);
}