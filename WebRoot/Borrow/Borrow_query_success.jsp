<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>   
    <title>My JSP 'borrow_query_success.jsp' starting page</title>
  </head> 
  <link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/query_success.css" />
  <body>
  <div id="navi">
		<div id='naviDiv'>
		<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;借阅管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="/Bookmanage/BorrowAction/Borrow_queryAction.action">借阅记录</a><span>&nbsp;
			
		</div>
	</div>
	<div id="tips">
		<div id="buttonGroup">
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/Borrow/Borrow_add.jsp">新增借阅</a>
			</div>
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/Borrow/Borrow_find.jsp">查找借阅</a>
			</div>
		</div>
	</div>
	<div id="mainContainer">
		<!-- 从session中获取学生集合 -->
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
				<td>罚款</td>
				<td>操作</td>
			</tr>
			<!-- 遍历开始 -->
			 <s:iterator value="#session.borrow_list" var="stu"> 
				<tr class="list">
				<td><s:property value="#stu.borrowid" /></td>
				<td><s:property value="#stu.bookid" /></td>
				<td><s:property value="#stu.readerid" /></td>
				<td><s:property  value="#stu.borrowdate " /></td>
				<td><s:property  value="#stu.returndate " /></td>
				<td><s:property value="#stu.readername" /></td>
				<td><s:property value="#stu.bookname" /></td>
				<td><s:property value="#stu.bookfee" /></td>
					<td align=center><%-- <a
						href="/Bookmanage/BorrowAction/Borrow_deleteAction.action?bid=<s:property value="#stu.borrowid"/>"
						onclick="javascript: return confirm('真的要删除吗？');">删除</a> --%> 
						<a href="/Bookmanage/BorrowAction/Borrow_deleteAction.action?borrowid=${stu.borrowid}" onclick="return confirm('确定要删除吗？')">删除</a>
						<a href="/Bookmanage/BorrowAction/Borrow_modifyAction.action?borrowid=${stu.borrowid}">修改</a> 
						<a href="/Bookmanage/BorrowAction/Borrow_returnbookAction.action?borrowid=${stu.borrowid}" onclick="return confirm('即将进行结算，结算后无法再更改记录，确认还书？')">还书</a>					
					</td> 
				</tr>
				
			 </s:iterator> 
			 </table>
			<!-- 遍历结束 -->
	</div>
</body>
</html>
