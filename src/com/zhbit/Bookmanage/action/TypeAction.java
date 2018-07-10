package com.zhbit.Bookmanage.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.domain.Type;
import com.zhbit.Bookmanage.service.TypeBiz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("typeAction")
@Scope("prototype")
public class TypeAction
  extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  Type noticeType;
  List<Type> noticeTypeList;
  String today;
  @Resource
  TypeBiz typeService;
  
  public TypeBiz getTypeService()
  {
    return this.typeService;
  }
  
  public void setTypeService(TypeBiz typeService)
  {
    this.typeService = typeService;
  }
  
  public String getToday()
  {
    return this.today;
  }
  
  public void setToday(String today)
  {
    this.today = today;
  }
  
  public Type getNoticeType()
  {
    return this.noticeType;
  }
  
  public void setNoticeType(Type noticeType)
  {
    this.noticeType = noticeType;
  }
  
  public List<Type> getNoticeTypeList()
  {
    return this.noticeTypeList;
  }
  
  public void setNoticeTypeList(List<Type> noticeTypeList)
  {
    this.noticeTypeList = noticeTypeList;
  }
  
  public String execute()
    throws Exception
  {
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    this.today = formater.format(new Date());
    ActionContext ac = ActionContext.getContext();
    Integer count = (Integer)ac.getApplication().get("count");
    if (count != null) {
      count = Integer.valueOf(count.intValue() + 1);
    } else {
      count = Integer.valueOf(1);
    }
    ac.getApplication().put("count", count);
    
    this.noticeTypeList = this.typeService.getAllType();
    return "";
  }
}
