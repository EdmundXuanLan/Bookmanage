package com.zhbit.Bookmanage.domain;

import java.util.Date;

public class Notice
{
  private int id;
  private String title;
  private String content;
  private String editor;
  private Date createTime;
  private Type type;
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public String getEditor()
  {
    return this.editor;
  }
  
  public void setEditor(String editor)
  {
    this.editor = editor;
  }
  
  public Date getCreateTime()
  {
    return this.createTime;
  }
  
  public void setCreateTime(Date createTime)
  {
    this.createTime = createTime;
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public void setType(Type type)
  {
    this.type = type;
  }
  
  public String toString()
  {
    return "鏍囬锛� + this.title + " + this.editor;
  }
}
