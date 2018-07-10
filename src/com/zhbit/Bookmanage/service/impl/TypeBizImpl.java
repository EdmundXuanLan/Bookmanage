package com.zhbit.Bookmanage.service.impl;

import com.zhbit.Bookmanage.dao.TypeDao;
import com.zhbit.Bookmanage.domain.Type;
import com.zhbit.Bookmanage.service.TypeBiz;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("typeService")
public class TypeBizImpl
  implements TypeBiz
{
  @Resource
  private TypeDao typeDao;
  
  public List<Type> getAllType()
  {
    return this.typeDao.getAllTypeList();
  }
  
  public Type selectType(int id)
  {
    return this.typeDao.selectType(id);
  }
  
  public TypeDao getTypeDao()
  {
    return this.typeDao;
  }
  
  public void setTypeDao(TypeDao typeDao)
  {
    this.typeDao = typeDao;
  }
}
