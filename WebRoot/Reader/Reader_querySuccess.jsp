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
				border="0" alt=""></span>&nbsp;读者管理&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<span><a
				href="/Bookmanage/Reader/Reader_query.action">读者列表</a></span>&nbsp;
		</div>
	</div>
	<div id="tips">
		<div id="buttonGroup">
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/Reader/Reader_add.jsp">添加读者</a>
			</div>
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/Reader/Reader_find.jsp">查找读者</a>
			</div>
		</div>
	</div>
	<div id="mainContainer">
		<!-- 从session中获取学生集合 -->
		<table class="default" width="100%">
			<col width="20%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
			<col width="20%">
			<col width="10%">
			<tr class="title">
				<td>读者编号</td>
				<td>读者姓名</td>
				<td>读者性别</td>
				<td>读者密码</td>
				<td>读者电话</td>
				<td>操作</td>
			</tr>
			<!-- 遍历开始 -->
			 <s:iterator value="#session.list" var="R"> 
				<tr class="list">
				<td><s:property value="#R.readerid" /></td>
				<td><s:property value="#R.readername" /></td>
				<td><s:property value="#R.readersex" /></td>
				<td><s:property  value="#R.readerpassword " /></td>
				<td><s:property  value="#R.phonenumber" /></td>
					<td align=center>
						<a href="/Bookmanage/Reader/Reader_modify.action?readerid=${R.readerid}">修改</a> 	
						<a href="/Bookmanage/Reader/Reader_delete.action?readerid=${R.readerid}" onclick="return confirm('确定要删除吗？')">删除</a>
				
					</td> 
				</tr>
				
			 </s:iterator> 
			 </table>
			<!-- 遍历结束 -->
	</div>
</body>
</html>
