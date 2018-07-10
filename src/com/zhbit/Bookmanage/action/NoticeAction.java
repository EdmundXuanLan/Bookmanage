package com.zhbit.Bookmanage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.Bookmanage.domain.Notice;
import com.zhbit.Bookmanage.domain.Type;
import com.zhbit.Bookmanage.service.NoticeBiz;
import com.zhbit.Bookmanage.service.TypeBiz;
import java.io.PrintStream;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("noticeAction")
@Scope("prototype")
public class NoticeAction
  extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNo = 1;
  private int pageSize = 10;
  private int pageCount;
  boolean all = true;
  private Notice notice;
  private int typeId;
  private int noticeId;
  private List<Notice> noticeList;
  private List<Type> typeList;
  @Resource
  private NoticeBiz noticeService;
  @Resource
  TypeBiz typeService;
  
  public NoticeBiz getNoticeService()
  {
    return this.noticeService;
  }
  
  public void setNoticeService(NoticeBiz noticeService)
  {
    this.noticeService = noticeService;
  }

  public void getPage(boolean flag)
  {

      this.pageCount = this.noticeService.getTotalPages(this.pageSize);
  }
  
  public String getDetailById()
  {
    this.notice = this.noticeService.getNoticeById(this.notice.getId());
    
    return "showNoticeDetail";
  }
  
  public String showAdd()
  {
   this.typeList = this.typeService.getAllType();
    
    return "showAddNotice";
  }
  
  public String add()
  {
    this.notice.setType(this.typeService.selectType(this.typeId));
    this.noticeService.addNotice(this.notice);
    this.noticeList = this.noticeService.getPage(this.pageNo, this.pageSize);
    return "showAllNotice";
  }
  
  public String showAll()
  {
    this.noticeList = this.noticeService.getAllNotice();
    
    return "showAllNotice";
  }
  
  public String showPage()
  {
    getPage(this.all);
    this.noticeList = this.noticeService.getPage(this.pageNo, this.pageSize);
    
    return "showAllNotice";
  }
  
/*  public String delete()
  {
    this.noticeService.deleteNotice(this.notice.getId());
    this.noticeList = this.noticeService.getPage(this.pageNo, this.pageSize);
    return "showAllNotice";
  }*/
  
  public String showDetailForModify()
  {
    this.notice = this.noticeService.getNoticeById(this.notice.getId());
    this.typeId = this.notice.getType().getId();
    
   this.typeList = this.typeService.getAllType();
    
    return "noticeEdit";
  }
  
  public String update()
  {
    this.notice.setType(this.typeService.selectType(this.typeId));
    this.noticeService.updateNotice(this.notice);
    this.noticeList = this.noticeService.getPage(this.pageNo, this.pageSize);
    return "showAllNotice";
  }
  
 public List<Type> getTypeList()
  {
    return this.typeList;
  }
  
  public void setTypeList(List<Type> typeList)
  {
    this.typeList = typeList;
  }
  
  public Notice getNotice()
  {
    return this.notice;
  }
  
  public void setNotice(Notice notice)
  {
    this.notice = notice;
  }
  public int getTypeId()
  {
    return this.typeId;
  }
  
  public void setTypeId(int typeId)
  {
    this.typeId = typeId;
  }
  
 public List<Notice> getNoticeList()
  {
    return this.noticeList;
  }
  
  public void setNoticeList(List<Notice> noticeList)
  {
    this.noticeList = noticeList;
  }
  
  public int getNoticeId()
  {
    return this.noticeId;
  }
  
  public void setNoticeId(int noticeId)
  {
    this.noticeId = noticeId;
  }
  
  public int getPageNo()
  {
    return this.pageNo;
  }
  
  public void setPageNo(int pageNo)
  {
    this.pageNo = pageNo;
  }
  
  public int getPageSize()
  {
    return this.pageSize;
  }
  
  public void setPageSize(int pageSize)
  {
    this.pageSize = pageSize;
  }
  
}
