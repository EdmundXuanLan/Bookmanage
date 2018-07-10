<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/modify_success.css" />
<body>
	<div id="navi">
		<!-- 导航空白 -->
		<div id='naviDiv'>
		<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;书本管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="<%=path%>/books/Books_query_success.jsp">书本列表</a><span>&nbsp;
			
		</div>
	</div>
	<div id="tips">
		<!-- 导航空白 -->
	</div>
	<div id="mainContainer">
		<strong>修改成功，结果如下：
			<table class="default" width="100%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="15%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<tr class="title">
					<td>书本编号</td>
					<td>书本名字</td>
					<td>书本类别</td>
					<td>书本作者</td>
					<td>出版社</td>
					<td>出版日期</td>
					<td>登记日期</td>
					
					<td>书本价格</td>
				</tr>
				<tr>
					<td><%=session.getAttribute("bookid")%></td>
					<td><%=session.getAttribute("bookname")%></td>
					<td><%=session.getAttribute("bookstyleno")%></td>
					<td><%=session.getAttribute("bookauthor")%></td>
					<td><%=session.getAttribute("bookpub")%></td>
					<td><%=session.getAttribute("bookpubdate")%></td>
					<td><%=session.getAttribute("bookindate")%></td>
					<td><%=session.getAttribute("bookprice")%></td>
				</tr>
			</table>
			<a href="Books_query_success.jsp">返回图书列表</a>
		</strong>
		<!--数据表格空白 -->
	</div>
</body>
</html>