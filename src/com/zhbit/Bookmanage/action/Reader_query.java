package com.zhbit.Bookmanage.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.service.ReadersService;
import com.zhbit.Bookmanage.domain.Readers;

@SuppressWarnings("serial")
@Controller("Reader_query")
@Scope(value="prototype")
public class Reader_query extends ActionSupport{
	Readers readers;
	@Resource(name="readersService")
	ReadersService readersService;
	@Resource
	HttpSession session;
	

	
	public Readers getReaders() {
		return readers;
	}

	public void setReaders(Readers readers) {
		this.readers = readers;
	}

	public ReadersService getReadersService() {
		return readersService;
	}

	public void setReadersService(ReadersService readersService) {
		this.readersService = readersService;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public Reader_query(){
		
	}
	
	public String execute() {
		List<Readers> list = readersService.getAllReader();
		if (list != null && list.size() > 0) {
			//ActionContext.getContext().put("borrow", list);
			session.setAttribute("list", list);
		}
		return "querySuccess";
	
	}

}
