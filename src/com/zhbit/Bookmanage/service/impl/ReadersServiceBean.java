package com.zhbit.Bookmanage.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhbit.Bookmanage.dao.ReadersDao;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;
import com.zhbit.Bookmanage.service.ReadersService;
@Service("readersService")
@Transactional
public class ReadersServiceBean implements ReadersService {
	@Resource
	private ReadersDao readersDao;
	SessionFactory sessionFactory;
	public ReadersDao getReadersDao() {
		return readersDao;
	}
	public void setReadersDao(ReadersDao readersDao) {
		this.readersDao = readersDao;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ReadersServiceBean(){
}
	@Override
	public boolean add(Readers readers) {	
		boolean isSameName=false;
		List<Readers> reader =  readersDao.getReadersById(readers.getReaderid());
		for (Readers r: reader){
			if (r.getReaderid().equals(readers.getReaderid())){
				isSameName=true;
			}
		}
		if (!isSameName){
			readersDao.save(readers);
	
			return true;
		}else{

			return false;
		}	
	}
	@Override
	public boolean update(Readers readers) {
			try{
			readersDao.update(readers);

			return true;
			}catch(Exception e){

				return false;
		}
				
	}
	@Override
	public void delete(Readers reades) {
		readersDao.delete(reades);
		
	}
	@Override
	public Readers getReaders(String readersId) {
		 return readersDao.getReaders(readersId);
	}
	@Override
	public List<Readers> getAllReader() {
		return readersDao.getReaders();
	}
	@Override
	public List<Borrow> getBorrow(String readerId) {
		return readersDao.getBorrow(readerId);
	}
	@Override
	public List<Readers> findReaders(String readerid, String readername, String readersex,
			String phonenumber) {
		return readersDao.findReaders(readerid, readername,readersex, phonenumber);
	}
	@Override
	public boolean ChackPassword(Readers readers,Readers newreaders,Readers chackreaders){
		try{
			System.out.println(readers.getReaderid());
				if(newreaders.getReaderpassword().equals(chackreaders.getReaderpassword())){
					
					readers.setReaderpassword(newreaders.getReaderpassword());
					newreaders=readers;
	
					readersDao.update(newreaders);
			
					return true;
				}else{
			
					return false;
				}
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

@Override
	public boolean ChackReaders(Readers readers) {
		
		try{
	
			List<Readers> list =  readersDao.getLogin(readers.getReaderid(),readers.getReaderpassword());
			if (list.size()>0){
			
				return true;
			}else {
	
				return false;
			}	
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
@Override
public Readers getReadersByName(String readerName) {
	return readersDao.getReadersByName(readerName);
}
}


	
	

	

	
	
	