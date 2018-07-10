package com.zhbit.Bookmanage.dao.impl;

import com.zhbit.Bookmanage.dao.NoticeDao;
import com.zhbit.Bookmanage.domain.Notice;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDaoImpl
  implements NoticeDao
{
  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;
  
  public static void main(String[] args) {}
  
  public void addNotice(Notice notice)
  {
    Session session = this.sessionFactory.getCurrentSession();
    
    notice.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
    session.save(notice);
  }
  
  public void deleteNotice(int noticeId)
  {
    Session session = this.sessionFactory.getCurrentSession();
    Notice notice = (Notice)session.load(Notice.class, Integer.valueOf(noticeId));
    session.delete(notice);
  }
  
  public void updateNotice(Notice notice)
  {
    Session session = this.sessionFactory.getCurrentSession();
    notice.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
    session.update(notice);
  }
  
  public Notice getNoticeById(int noticeId)
  {
    return (Notice)this.sessionFactory
      .getCurrentSession()
      .get(Notice.class, Integer.valueOf(noticeId));
  }
  
  public List<Notice> getAllNoticeList()
  {
    List<Notice> result = new ArrayList();
    Session session = this.sessionFactory
      .getCurrentSession();
    Query query = session.createQuery("from Notice");
    result = query.list();
    return result;
  }
  
  
  public int getCount()
  {
    Session session = this.sessionFactory.getCurrentSession();
    int count = 0;
    return count;
  }
  
  public int getCountByType(int typeId)
  {
    Session session = this.sessionFactory.getCurrentSession();
    int count = 0;
    return count;
  }
  
  public List<Notice> getPage(int pageNo, int pageSize)
  {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from Notice");

    List<Notice> list = query.list();
    return list;
  }
  
  public SessionFactory getSessionFactory()
  {
    return this.sessionFactory;
  }
  
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }
}
