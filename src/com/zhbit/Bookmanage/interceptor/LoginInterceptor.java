package com.zhbit.Bookmanage.interceptor;
import java.util.Map;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@Controller("loginInterceptor")
@Scope("prototype")
public class LoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation arg) throws Exception{
		Map session=arg.getInvocationContext().getSession();//获得Session对象
		String uname=(String)session.get("readerId");
		System.out.println(uname);
		//获取Session中的readerid对象，并赋值给uname；
		if(uname!=null&&!uname.equals("")){
			System.out.print("拦截器执行，1");
			return arg.invoke();
		}else{
			System.out.print("拦截器执行，2	");
			
            //自定义错误信息
            session.put("errorMsg", "您还没有登录，请登录!");
            return Action.LOGIN;
		}
	}
}
