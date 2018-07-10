package com.zhbit.Bookmanage.service;

import com.zhbit.Bookmanage.domain.Type;
import java.util.List;

public abstract interface TypeBiz
{
  public abstract List<Type> getAllType();
  
  public abstract Type selectType(int paramInt);
}
