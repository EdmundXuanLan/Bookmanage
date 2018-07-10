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
				border="0" alt=""></span>&nbsp;借阅管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="/Bookmanage/BorrowAction/Borrow_queryAction.action">借阅列表</a><span>&nbsp;
			
		</div>
	</div>
	
	<div id="tips"></div>
	<div id="mainContainer">
		<!-- 从session中获取学生集合 -->
		<strong>修改借阅记录</strong> <br> <br>
		<form name="modifyForm" action="/Bookmanage/BorrowAction/Borrow_saveAction.action"
			method="post">
			<table width="400">
			<tr>
					<td width="30%">借阅号：</td>
					<td><input type="text" name="borrowid"
						 value='<s:property value="#session.modify_borrow.borrowid"/>'
						readonly=readonly/></td>
				</tr>
				<tr>
					<td width="30%">读者号：</td>
					<td><input type="text" name="readerid"
						 value='<s:property value="#session.modify_borrow.readerid"/>'
						/></td>
				</tr>
				<tr>
					<td width="30%">书本号：</td>
					<td><input type="text" name="bookid"
						value='<s:property value="#session.modify_borrow.bookid"/>' /></td>
				<%-- </tr>
				<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(sdf.format(new Date()));// new Date()为获取当前系统时间
		Date date= new Date();
		String createdate = sdf.format(date);
		request.setAttribute("createdate",createdate);
		%> --%>
				<%-- <tr>
					<td><input type="button" onclick="setTime()" value="添加归还时间"></td>
					<td><div id=timv style="display:none"><input type="text" id="tim" value="<% out.println(createdate);%>" readonly="readonly"/></div></td>
					<td><div id=Tesv style="display:none"><input type="text" id="Tes" value="0"/></div></td>
				</tr> --%>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="submit" value="修改"></td>
				</tr>
			</table>
		</form>
	</div> 
</body>
</html>