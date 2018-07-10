<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>

    
    <title>My JSP 'Test_query.jsp' starting page</title>
    

  </head>
  
  <body>
 <a href="/Bookmanage/BorrowAction/Borrow_queryAction.action">链接</a>
  </body>
</html>
