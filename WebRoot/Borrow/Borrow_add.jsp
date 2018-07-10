<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
	<link rel="stylesheet" type="text/css" href="../css/add.css" />
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
	<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;借阅管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="/Bookmanage/BorrowAction/Borrow_queryAction.action">借阅列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>添加借阅记录</strong>
<br>
<br>
<%-- <form name="addForm" action="<%=path%>/books/Books_add.action" method="post"> --%>
<form name="addAction" namespace="/BorrowAction" action="${pageContext.servletContext.contextPath}/BorrowAction/Borrow_addAction.action" method="post">
<table width="400" >
  <tr>
  	
    <td width="30%">书本编号：</td>
    <td><input type="text" name="bookid"  onkeyup="this.value=this.value.replace(/[^\d]/g,'');" /></td><br>
    <td><s:fielderror fieldName="bookid"/></td>
  </tr>
  <tr>
    <td>读者编号：</td>
    <td><input type="text" name="readerid" onkeyup="this.value=this.value.replace(/[, ]/g,'')" /></td><br>
    <td><s:fielderror fieldName="readerid"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="添加"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>