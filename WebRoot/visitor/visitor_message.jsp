<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'visitor_message.jsp' starting page</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/visitor_message.css" />  
  </head>
  
  <body>
  <div id="wrapper">
	  <div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title">亚麻逊</div>
			<div id="subTitle">个人信息</div>
		</div>
	</div>
	<div id="main">
		<div id="mainBg">
			<div id="mainPanel">
				<div id="mainPane2">
					<form name="visitorLogoutAction" namespace="/Bookmanage" action="${pageContext.servletContext.contextPath}/Bookmanage/visitorLogoutAction.do" method="post">
						<div id="input">
							<span class="item">账&nbsp;&nbsp;&nbsp;号:&nbsp;&nbsp;&nbsp;<%=session.getAttribute("readerId") %></span>
							
						</div>
						<div id="input" >
							<span class="item">姓&nbsp;&nbsp;&nbsp;名:&nbsp;&nbsp;&nbsp;<%=session.getAttribute("readername") %></span>
							
						</div>
						
						<div id="input">
							<span class="item">性&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;&nbsp;<%=session.getAttribute("readersex") %></span>
							
						</div>
						<div id="input">
							<span class="item">联系方式：<%=session.getAttribute("phonenumber") %></span>
							
						</div>	
							<input onClick="window.location.href='visitor_altermessage.jsp'" type="button" class="btnalter1" value="修改个人信息">
							<input onClick="window.location.href='visitor_alterpassword.jsp'" type="button" class="btnalter2" value="修改密码">
							<input type="submit" class="btnout" value="退出登录">
							<input onClick="window.location.href='visitor_index_login.jsp'" type="button" class="btn" value="返回主页">

						</form>
				</div>
			</div>	
		</div>
	</div>
</div>
	
  </body>
</html>
