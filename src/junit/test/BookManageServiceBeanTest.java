package junit.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.Bookmanage.domain.Borrow;
import com.zhbit.Bookmanage.domain.Readers;
import com.zhbit.Bookmanage.service.BorrowService;
import com.zhbit.Bookmanage.service.ReadersService;



public class BookManageServiceBeanTest {

	private static ReadersService service1;
	private static BorrowService service2;


		@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			@SuppressWarnings("resource")
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service1 = (ReadersService) applicationContext.getBean("readersService");
			service2 = (BorrowService) applicationContext.getBean("borrowService");
			System.out.print("成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("getBean false");
		}
	}
		
		
			
		
		
		/*@Test
		public void testGetName() {
			try {
				System.out.println(service.getReaderName("150202101"));
//				System.out.println(service.getBookName("101"));
				} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		@Test
		public void testCheck(){
			Readers r = new Readers();
//			String stid="150202102";
			r=service1.getReaders("150202104");
			r.setReaderid("142");
//			r.setReaderpassword("1a");
			service1.update(r);
		}
		
/*	@Test
	public void testAddNewBorrow() {
		try {
			service.addNewBorrow(new Borrow("0101","150202101","20180312","","陈灿面","我的大师兄脑子有坑",""));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

/*	@Test
	public void testfindAllBorrow() {
		List<Borrow> borrow = service.findAllBorrow();
		
		for (Borrow borrow1: borrow){
			System.out.println(borrow1.getBorrowid());
		}
	}*/
/*	@Test
	public void textfindBorrowByRid(){
		List<Borrow> borrow = service.findBorrowByRid("150202101");
		for (Borrow borrow1: borrow){
			System.out.println(borrow1);
		}
	}*/
/*	@Test
	public void textfindBorrowByBid(){
		List<Borrow> borrow = service.findBorrowByRid("0101");
		if(borrow!=null)
		{
			System.out.println("111");
		}
	}*/
		
		/*public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";

		//计算给开始日期 结束日期 的间隔天数 yyyy-MM-dd
		public static int getDayLength(String start_date,String end_date) throws Exception{
		Date fromDate = getStrToDate(start_date,DATE_FORMAT_NORMAL);  //开始日期
		Date toDate = getStrToDate(end_date,DATE_FORMAT_NORMAL); //结束日期
		long from = fromDate.getTime();
		long to = toDate.getTime();
		                //一天等于多少毫秒：24*3600*1000
		int day = (int)((to-from)/(24*60*60*1000));
		return day;
		        }

		public static Date getStrToDate(String date,String fomtter) throws Exception{
		DateFormat df = new SimpleDateFormat(fomtter);
		return df.parse(date);
		}

		public static void main(String[] args) throws Exception{
		int days=getDayLength("2016-08-09","2016-08-30");
		System.out.println(days);
		}*/
	
/*	@Test
	public void testgetBorrowobj(){
		Borrow b=new Borrow();
		b=service.getBorrow("14");
		System.out.println(b.getBookname());
	}*/
	
/*	@Test
 public void textupdateBorrow(){
		Borrow b=new Borrow();
		b=service.getBorrow("101");
		System.out.println(b.getBookname());
		b.setBookname("长恨歌");
		service.updateBorrow(b);
	}*/
	
	/*@Test
	public void textdeleteBorrow(){
		Borrow b=new Borrow();
		b=service.getBorrow("101");
		service.deleteBorrow(b);
	}*/

}
