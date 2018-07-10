package com.zhbit.Bookmanage.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Type
  implements Serializable
{
  private int id;
  private String typeName;
  private Set<Notice> notice = new HashSet();
  
  public Type() {}
  
  public Type(int id, String typeName)
  {
    this.id = id;
    this.typeName = typeName;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getTypeName()
  {
    return this.typeName;
  }
  
  public void setTypeName(String typeName)
  {
    this.typeName = typeName;
  }
  
  public Set<Notice> getNotice()
  {
    return this.notice;
  }
  
  public void setNotice(Set<Notice> notice)
  {
    this.notice = notice;
  }
}
