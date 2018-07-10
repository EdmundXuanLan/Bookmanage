package com.zhbit.Bookmanage.dao.impl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.zhbit.Bookmanage.dao.BorrowDao;
import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;
import com.zhbit.Bookmanage.domain.Books;

@Repository("borrowDao")
public class BorrowDaoBean implements BorrowDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	public BorrowDaoBean(){}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Borrow borrow){
		sessionFactory.getCurrentSession().save(borrow);		
	}
	
	@Override
	public void update(Borrow borrow){
		sessionFactory.getCurrentSession().update(borrow);
		
	}
	
	@Override
	public void delete(Borrow borrow){
		
		sessionFactory.getCurrentSession().delete(borrow);

	}
										
	@SuppressWarnings({ "unchecked" })
	@Override
	public Borrow getOneBorrow(String borrowid){
		/*List<Borrow> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Borrow where borrowid=:borrowids");
		query.setParameter("borrowid", borrowids);
		list=query.list();
		Borrow b=list.get(0);*/
		return (Borrow) sessionFactory.getCurrentSession().get(Borrow.class,borrowid);
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> getBorrow(){
		return sessionFactory.getCurrentSession().createQuery("from Borrow").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkBorrow(String bookids){
		List<Books> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Books where bookid=:bookids and isborrowed='1'");  
		query.setParameter("bookids", bookids);
		list=query.list();
		if(list.size()>0){
			System.out.println("@#%…………￥#"+list.size());
			return true;
		}else{
			System.out.println("@#%…………￥#"+list.size());
			return false;
		}	
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public Books getBooksByID(String bookids){
		return (Books)sessionFactory.getCurrentSession().get(Books.class,bookids);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Readers getReadersByID(String readerid){
		return (Readers)sessionFactory.getCurrentSession().get(Readers.class,readerid);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> findBorrowById(String readerid,String bookname){
		String readerids=readerid;
		String booknames=bookname;
		int x=checkBookname(booknames).size();
		Readers y=getReadersByID(readerids);
		if(x>0&&y!=null)
		{
			return sessionFactory.getCurrentSession().createQuery("from Borrow where bookname=:bookname").setParameter("bookname", booknames).list();
		}else if(x<=0&&y!=null){
			return sessionFactory.getCurrentSession().createQuery("from Borrow where readerid=:readerid").setParameter("readerid", readerids).list();
		}else{
			return sessionFactory.getCurrentSession().createQuery("from Borrow where readerid=:readerid and bookname=:bookname").setParameter("bookname", booknames).setParameter("readerid", readerids).list();
		}	
	}
	
	@Override
	public String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(sdf.format(new Date()));// new Date()为获取当前系统时间
		Date date= new Date();
		String createdate = sdf.format(date);
		return createdate;	     	
	}
	
	@Override
	public  int getDayLength(String start_date,String end_date)throws Exception{
		final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";
		Date fromDate = getStrToDate(start_date,DATE_FORMAT_NORMAL);  //开始日期
		Date toDate = getStrToDate(end_date,DATE_FORMAT_NORMAL); //结束日期
		long from = fromDate.getTime();
		long to = toDate.getTime();
		                //一天等于多少毫秒：24*3600*1000
		int day = (int)((to-from)/(24*60*60*1000));
		return day;
	}
	@Override
	public  Date getStrToDate(String date,String fomtter) throws Exception{
		DateFormat df = new SimpleDateFormat(fomtter);
		return df.parse(date);
	}

	@Override
	public String getFee(String borrowdate,String returndate) throws Exception{
		int days=getDayLength(borrowdate,returndate);
		if(days>60){
			double fee=(days-60)*0.2;
			BigDecimal   c   =   new   BigDecimal(fee);
			double   f1   =   c.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();   
			String str=""+f1;
			return str;
		}
		return null;
	}

	@Override
	public List<Books> checkBookname(String booknames) {
		List<Books> list;
		Query query=sessionFactory.getCurrentSession().createQuery("from Books where bookname=:bookname");  
		query.setParameter("bookname", booknames);
		list=query.list();
		return list;
	}

	

}

