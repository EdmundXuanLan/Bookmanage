package com.zhbit.Bookmanage.dao;

import com.zhbit.Bookmanage.domain.Notice;
import java.util.List;

public abstract interface NoticeDao
{
  public abstract void addNotice(Notice paramNotice);

  public abstract void updateNotice(Notice paramNotice);
  
  public abstract Notice getNoticeById(int paramInt);

  public abstract List<Notice> getAllNoticeList();

  public abstract int getCount();
  
  public abstract List<Notice> getPage(int paramInt1, int paramInt2);
}
