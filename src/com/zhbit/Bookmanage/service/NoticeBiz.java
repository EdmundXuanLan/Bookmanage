package com.zhbit.Bookmanage.service;

import com.zhbit.Bookmanage.domain.Notice;
import java.util.List;

public abstract interface NoticeBiz
{
  public abstract List<Notice> getAllNotice();
  
  public abstract Notice getNoticeById(int paramInt);
  
  public abstract void addNotice(Notice paramNotice);
  
  public abstract void updateNotice(Notice paramNotice);
  
  public abstract List<Notice> getPage(int paramInt1, int paramInt2);
  
public abstract int getTotalPages(int paramInt);
  
}
