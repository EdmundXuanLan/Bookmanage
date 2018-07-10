package com.zhbit.Bookmanage.dao;

import com.zhbit.Bookmanage.domain.Type;
import java.util.List;

public abstract interface TypeDao
{
  public abstract List<Type> getAllTypeList();
  
  public abstract Type selectType(int paramInt);
}
