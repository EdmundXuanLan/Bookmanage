package com.zhbit.Bookmanage.action;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.dao.ReadersDao;
import com.zhbit.Bookmanage.service.ReadersService;
import com.zhbit.Bookmanage.domain.Readers;

@Controller("visitorAction")
@Scope("prototype")
public class VisitorAction extends ActionSupport {
	Map session;
	
	Readers readers;
	Readers newreaders;
	Readers chackreaders;
	@Resource
	ReadersDao readersDao;
	@Resource
	ReadersService readersService;

	public VisitorAction() {
		session = ActionContext.getContext().getSession();
	}

	public Readers getReaders() {
		return readers;
	}

	public void setReaders(Readers readers) {
		this.readers = readers;
	}


	public Readers getNewreaders() {
		return newreaders;
	}

	public void setNewreaders(Readers newreaders) {
		this.newreaders = newreaders;
	}

	public Readers getChackreaders() {
		return chackreaders;
	}

	public void setChackreaders(Readers chackreaders) {
		this.chackreaders = chackreaders;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public ReadersDao getReadersDao() {
		return readersDao;
	}

	public void setReadersDao(ReadersDao readersDao) {
		this.readersDao = readersDao;
	}

	public ReadersService getReadersService() {
		return readersService;
	}

	public void setReadersService(ReadersService readersService) {
		this.readersService = readersService;
	}

	public String add() {
		try {

			if (readersService.add(readers)) {
				System.out.println("success");
				session.put("success", "注册");
				return "success";
			} else {
				System.out.println("input e");
				return "input";
			}
		} catch (Exception e) {
			System.out.println("input c");
			e.printStackTrace();
			return "input";
		}

	}

	public String updatemessage() {
		
		try {
			//System.out.println(readers.getReaderid());
		    //System.out.println(readers.getReadername());
			//System.out.println(readers.getReaderpassword());
			//System.out.println(readers.getReadersex());
			//System.out.println(readers.getPhonenumber());
			String id = (String) session.get("readerId");
			String password = (String) session.get("readerpassword");
			readers.setReaderid(id);
			readers.setReaderpassword(password);

			if (readersService.update(readers)) {
				System.out.println("success");
				List<Readers> list = readersDao.getReadersById(readers.getReaderid());

				for (Readers r : list) {
					session.put("readerId", r.getReaderid());
					session.put("readername", r.getReadername());
					session.put("readerpassword", r.getReaderpassword());
					session.put("readersex", r.getReadersex());
					session.put("phonenumber", r.getPhonenumber());
				}
				session.put("success", "修改信息");
				return "success";
			} else {
				System.out.println("input e");
				return "input";
			}
		} catch (Exception e) {
			System.out.println("input c");
			return "input";
		}
	}

	public String updatepassword() {
		try {
			String password = (String) session.get("readerpassword");
			String id = (String) session.get("readerId");
			String name = (String) session.get("readername");
			String sex = (String) session.get("readersex");
			String phonenumber = (String) session.get("phonenumber");
			readers.setReaderid(id);
			readers.setReadername(name);
			readers.setReadersex(sex);
			readers.setPhonenumber(phonenumber);
			// System.out.println(newreaders.getReaderid());
			// System.out.println(newreaders.getReadername());
			// System.out.println(readers.getReaderpassword());
			// System.out.println(newreaders.getReadersex());
			// System.out.println(newreaders.getPhonenumber());
			if (readers.getReaderpassword().equals(password)) {
				if (readersService.ChackPassword(readers, newreaders, chackreaders)) {
					System.out.println("success");
					List<Readers> list = readersDao.getReadersById(readers.getReaderid());

					for (Readers r : list) {
						session.put("readerId", r.getReaderid());
						session.put("readername", r.getReadername());
						session.put("readerpassword", r.getReaderpassword());
						session.put("readersex", r.getReadersex());
						session.put("phonenumber", r.getPhonenumber());
					}
					session.put("success", "修改密码");
					return "success";
				} else {
					this.addFieldError("errorNew","两次新密码输入不同");
					return "input";
				}
			} else {
				System.out.print("原密码错误");
				this.addFieldError("errorPassword","原密码错误");
				return "input";
			}
		} catch (Exception e) {
			System.out.println("input c");
			return "input";
		}
	}

	public String logout(){
		
		session.clear();
		
		return "success";
	}
	public String execute() throws Exception {

		System.out.println("readers.readerid:" + readers.getReaderid());
		if (readersService.ChackReaders(readers)) {
			System.out.println("success:" + readers.getReaderid());
			List<Readers> list = readersDao.getReadersById(readers.getReaderid());

			for (Readers r : list) {

				session.put("readerId", r.getReaderid());
				session.put("readername", r.getReadername());
				session.put("readerpassword", r.getReaderpassword());
				session.put("readersex", r.getReadersex());
				session.put("phonenumber", r.getPhonenumber());
			}
			session.put("success", "登录");
			
			
			return "success";
		}else{
		this.addFieldError("errorMessage","账号或密码错误，请重新输入");
		System.out.println("input");
		return "input";
		}
	}
}
