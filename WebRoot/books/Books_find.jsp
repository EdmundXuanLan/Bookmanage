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
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;书本管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="/Bookmanage/BooksAction/Books_queryAction.action">书本列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取集合 -->
<strong>查询书本记录</strong>
<br>
<br>
<%-- <form name="addForm" action="<%=path%>/books/Books_add.action" method="post"> --%>
<form name="selectAction" namespace="/BooksAction" action="${pageContext.servletContext.contextPath}/BooksAction/Books_findAction.action" method="post" >
<table width="400" >
<tr>
    <td><input type="text" name="shuru" required="required"/></td>
  </tr>
  <tr>
    <td width="30%">书名</td>
    <td><input checked type="radio" name="bookselect" value="bookname"/></td>
  </tr>
  <tr>
    <td>书本作者</td>
    <td><input type="radio" name="bookselect" value="bookauthor" /></td>
  </tr>
  <tr>
    <td width="30%">出版社</td>
    <td><input type="radio" name="bookselect" value="bookpub"/></td>
  </tr>
  <tr>
    <td width="30%">书价</td>
    <td><input type="radio" name="bookselect" value="bookprice"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="查询"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>