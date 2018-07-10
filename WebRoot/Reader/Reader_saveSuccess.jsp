<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
    <link rel="stylesheet" type="text/css" href="../css/modify_success.css" />
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
 <div id="mainContainer">
   <strong>修改成功，结果如下：
  	<table class="default" width="100%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<tr class="title">
				<td>读者编号</td>
				<td>读者姓名</td>
				<td>读者性别</td>
				<td>读者密码</td>
				<td>读者电话</td>
			</tr>
 					<tr><td><%=session.getAttribute("readerid") %></td>
					<td><%=session.getAttribute("readername") %></td>
					<td><%=session.getAttribute("readersex") %></td>
					<td><%=session.getAttribute("readerpassword") %></td>
					<td><%=session.getAttribute("phonenumber") %></td> </tr></table> <a href="/Bookmanage/Reader/Reader_query.action">返回</a></strong>
   <!--数据表格空白 -->
</div>
</body>
</html>