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
	<!-- 导航空白 -->
	<div id='naviDiv'>
	<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;借阅管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="/Bookmanage/BorrowAction/Borrow_queryAction.action">修改借阅</a><span>&nbsp;
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
				<td>借阅编号</td>
				<td>书本编号</td>
				<td>读者编号</td>
				<td>出借日期</td>
				<td>归还日期</td>
				<td>读者姓名</td>
				<td>书名</td>
				<td>罚款</td></tr>
 					<tr><td><%=session.getAttribute("borrowid") %></td>
					<td><%=session.getAttribute("bookid") %></td>
					<td><%=session.getAttribute("readerid") %></td>
					<td><%=session.getAttribute("borrowdate") %></td>
					<td><%=session.getAttribute("returndate") %></td>
					<td><%=session.getAttribute("readername") %></td>
					<td><%=session.getAttribute("bookname") %></td>
					<td><%=session.getAttribute("bookfee") %></td> </tr></table><a href="/Bookmanage/BorrowAction/Borrow_queryAction.action">返回借阅列表</a></strong>
   <!--数据表格空白 -->
</div>
</body>
</html>