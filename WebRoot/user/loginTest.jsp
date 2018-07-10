<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'loginTest.jsp' starting page</title>
    


  </head>
  
  <body>
   <s:form method="post" namespace="Bookmanage" action="LoginAction">
   <s:textfield name="users.usersname" label="1"/>
   <s:password name="users.password" label="2"/>
   <s:submit value="3"/>
   </s:form>
   
  </body>
</html>
