<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'visitor_main_success.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="../css/visitor_success.css" />

<span style="font-size:24px;"> 
<s:if test="#session.success=='登录'">
<meta http-equiv="refresh"
		content="3;http://localhost:8080/Bookmanage/visitor/visitor_index_login.jsp">
 </s:if>
 <s:if test="#session.success=='注册'">
<meta http-equiv="refresh"
		content="3;http://localhost:8080/Bookmanage/visitor/visitor_login.jsp">
 </s:if>
 <s:if test="#session.success=='修改信息'">
<meta http-equiv="refresh"
		content="3;http://localhost:8080/Bookmanage/visitor/visitor_message.jsp">
 </s:if>
 <s:if test="#session.success=='修改密码'">
<meta http-equiv="refresh"
		content="3;http://localhost:8080/Bookmanage/visitor/visitor_login.jsp">
 </s:if>
</span>
</head>

<body>
	<div id="wrapper">
		<div id="main">
			<div id="main2">
				<div id="main3">
					<img id="img" src="../images/dagou.png"> <s:property value="#session.success"/>成功</br>
					<s:if test="#session.success=='修改密码'">
					请重新登录</br>
					</s:if>
					自动跳转中 </br> 
					<s:if test="#session.success=='登录'">
					<a href="visitor_index_login.jsp">3秒内未跳转，请点击这里</a>
					</s:if>
					<s:if test="#session.success=='注册'">
					<a href="visitor_login.jsp">3秒内未跳转，请点击这里</a>
					</s:if>
					<s:if test="#session.success=='修改信息'">
					<a href="visitor_message.jsp">3秒内未跳转，请点击这里</a>
					</s:if>
					<s:if test="#session.success=='修改密码'">
					<a href="visitor_login.jsp">3秒内未跳转，请点击这里</a>
					</s:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
