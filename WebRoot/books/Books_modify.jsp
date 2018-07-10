<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat,java.util.Date"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/modify.css" />
<body>
<%-- <!-- 在页面中显示当前时间并发送一个信号量给Action -->
<script>
function setTime()
{

 tim.style.display = "";
document.getElementById("Tes").innerText='1';
document.getElementById("Tes").value='1';
 
}
</script> --%>

	<script type="text/javascript" src="../js/Calendar3.js"></script>
	<div id="navi">
		<div id='naviDiv'>
		<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;书本管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="/Bookmanage/BooksAction/Books_queryAction.action">书本列表</a><span>&nbsp;
			
		</div>
	</div>
	
	<div id="tips"></div>
	<div id="mainContainer">
		<!-- 从session中获取书本集合 -->
		<strong>修改借阅记录</strong> <br> <br>
		<form name="modifyForm" action="/Bookmanage/BooksAction/Books_saveAction.action"
			method="post">
			<table width="400">
			<tr>
					<td width="30%">书本编号：</td>
					<td><input type="text" name="bookid"
						 value='<s:property value="#session.modify_books.bookid"/>'
						readonly=readonly/></td>
				</tr>
				<tr>
					<td style="display:none width="30%">书本名字：</td>
					<td><input type="text" name="bookname"
						 value='<s:property value="#session.modify_books.bookname"/>'
						/></td>
				</tr>
				<tr>
					<td width="30%">书本类别：</td>
					<td><input type="text" name="bookstyleno"
						 value='<s:property value="#session.modify_books.bookstyleno"/>'
						/></td>
				</tr>
				
				<tr>
					<td width="30%">书本作者：</td>
					<td><input type="text" name="bookauthor"
						 value='<s:property value="#session.modify_books.bookauthor"/>'
						/></td>
				</tr>
				<tr>
					<td width="30%">出版社：</td>
					<td><input type="text" name="bookpub"
						 value='<s:property value="#session.modify_books.bookpub"/>'
						/></td>
				</tr>
				<tr>
					<td width="30%">出版日期：</td>
					<td><input type="text" name="bookpubdate"
						 value='<s:property value="#session.modify_books.bookpubdate.substring(0,10)"/>'
						/></td>
				</tr>
				<tr>
					<td width="30%">登记日期：</td>
					<td><input type="text" name="bookindate"
						 value='<s:property value="#session.modify_books.bookindate.substring(0,10)"/>'
						/></td>
				</tr>
				<tr>
					<td style="display:none" width="30%">是否借阅</td>
					<td style="display:none"><input type="text" name="isborrowed"
						 value='<s:property value="#session.modify_books.isborrowed"/>'
						readonly=readonly/></td>
				</tr>
				<tr>
					<td width="30%">书本价格：</td>
					<td><input type="text" name="bookprice"
						value='<s:property value="#session.modify_books.bookprice"/>' /></td>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="submit" value="修改"></td>
				</tr>
			</table>
		</form>
	</div> 
</body>
</html>