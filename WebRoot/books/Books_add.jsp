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
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;图书管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="/Bookmanage/BooksAction/Books_queryAction.action">图书列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取书本集合 -->
<strong>添加书本记录</strong>
<br>
<br>
<%-- <form name="addForm" action="<%=path%>/books/Books_add.action" method="post"> --%>
<form name="addAction" namespace="/BooksAction" action="${pageContext.servletContext.contextPath}/BooksAction/Books_addAction.action" method="post">
<table width="400" >
  <tr>
    <td width="30%">书本编号：</td>
    <td><input type="text" name="bookid"  required="required"/></td>
  </tr>
<tr>
    <td width="30%">书本名字：</td>
    <td><input type="text" name="bookname"  required="required"/></td>
  </tr>
  <tr>
    <td width="30%">书本类别：</td>
    <td><input type="text" name="bookstyleno"  required="required"/></td>
  </tr>
  <tr>
    <td width="30%">书本作者：</td>
    <td><input type="text" name="bookauthor"  required="required"/></td>
  </tr>
  <tr>
    <td width="30%">出版社：</td>
    <td><input type="text" name="bookpub"  required="required"/></td>
  </tr>
  <tr>
    <td width="30%">出版日期：</td>
    <td><input type="text" name="bookpubdate"  required="required"/></td>
  </tr>
  <tr>
    <td width="30%">登记日期：</td>
    <td><input type="text" name="bookindate"  required="required"/></td>
  </tr>
  <tr>
    <td style="display:none" width="30%">是否被借阅：</td>
    <td style="display:none"><input type="text" name="isborrowed" value="1"   readonly=readonly/></td>
  </tr>
  <tr>
    <td width="30%">书本价格：</td>
    <td><input type="text" name="bookprice"  required="required"/></td>
  </tr>
  
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="添加"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>