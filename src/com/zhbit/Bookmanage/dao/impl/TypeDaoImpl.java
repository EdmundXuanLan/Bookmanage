package com.zhbit.Bookmanage.dao.impl;

import com.zhbit.Bookmanage.dao.TypeDao;
import com.zhbit.Bookmanage.domain.Type;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("typeDao")
public class TypeDaoImpl
  implements TypeDao
{
  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;
  
  public SessionFactory getSessionFactory()
  {
    return this.sessionFactory;
  }
  
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }
  
  public List<Type> getAllTypeList()
  {
    List<Type> result = new ArrayList();
    Session session = this.sessionFactory.getCurrentSession();
    result = session.createQuery("from Type").list();
    System.out.println("====================");
    return result;
  }
  
  public Type selectType(int id)
  {
    Session session = this.sessionFactory.getCurrentSession();
    Type type = null;
    type = (Type)session.get(Type.class, Integer.valueOf(id));
    return type;
  }
}
