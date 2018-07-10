<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统登录</title>
  </head>
  
  <body>
	<s:form method="post" namespace="/Bookmanage" action="loginAction">
		<s:textfield name="users.usersname" label="用户名"/>
		<s:password name="users.password" label="密码"/>
		<s:submit value="登录"/>
	</s:form>
  </body>
</html>
