<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Borrow_delete_faild.jsp' starting page</title>
    

  </head>
  <link rel="stylesheet" type="text/css" href="../css/default.css" />
	<link rel="stylesheet" type="text/css" href="../css/query_success.css" />

  <body>
 <div id="navi">
		<div id='naviDiv'>
		<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;读者管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="/Bookmanage/Reader/Reader_query.action">读者列表</a><span>&nbsp;
			
		</div>
</div>
<div id="tips">
	<!-- 导航空白 -->
</div>
<div id="mainContainer">
   <strong><font size=5 color=red>修改失败，请输入正确的读者信息以进行修改！<a href="/Bookmanage/Reader/Reader_modifyAction.action?readerid=<%=session.getAttribute("readerid") %>">点击返回</a></font></strong>
   <!--数据表格空白 -->
</div>
  </body>
</html>