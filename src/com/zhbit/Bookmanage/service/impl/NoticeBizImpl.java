package com.zhbit.Bookmanage.service.impl;

import com.zhbit.Bookmanage.dao.NoticeDao;
import com.zhbit.Bookmanage.domain.Notice;
import com.zhbit.Bookmanage.service.NoticeBiz;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeBizImpl
  implements NoticeBiz
{
  @Resource
  private NoticeDao noticeDao;
  
  public NoticeDao getNoticeDao()
  {
    return this.noticeDao;
  }
  
  public void setNoticeDao(NoticeDao noticeDao)
  {
    this.noticeDao = noticeDao;
  }
  
  public List<Notice> getAllNotice()
  {
    return this.noticeDao.getAllNoticeList();
  }
  
  public Notice getNoticeById(int noticeId)
  {
    return this.noticeDao.getNoticeById(noticeId);
  }
  
  public void addNotice(Notice notice)
  {
    this.noticeDao.addNotice(notice);
  }
  
  public void updateNotice(Notice notice)
  {
    this.noticeDao.updateNotice(notice);
  }
  
  public List<Notice> getPage(int pageNo, int pageSize)
  {
    return this.noticeDao.getPage(pageNo, pageSize);
  }
  
  public int getTotalPages(int pageSize)
  {
    int result = 0;
    return result;
  }
  
}
