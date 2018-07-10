<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>   
    <title>My JSP 'books_query_success.jsp' starting page</title>
  </head> 
  <link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/query_success.css" />
  <body>
  <div id="navi">
		<div id='naviDiv'>
		<span>&nbsp;<a href="../user/Users_login_success.jsp">管理系统</a></span>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;系统管理&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="/Bookmanage/BooksAction/Books_queryAction.action">书本记录</a>&nbsp;
			
		</div>
	</div>
	<div id="tips">
		<div id="buttonGroup">
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/books/Books_add.jsp">新增书本</a>
			</div>
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/books/Books_find.jsp">查找书本</a>
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
				<td>书本编号</td>
				<td>书本名字</td>
				<td>书本类别</td>
				<td>书本作者</td>
				<td>出版社</td>
				<td>出版日期</td>
				<td>登记日期</td>
				<td>能否借阅</td>
				<td>书本价格</td>
				<td>操作</td>
			</tr>
			<!-- 遍历开始 -->
			 <s:iterator value="#session.books_list" var="stu"> 
			 
				<tr class="list">
				<td><s:property value="#stu.bookid" /></td>
				<td><s:property value="#stu.bookname" /></td>
				<td><s:property value="#stu.bookstyleno" /></td>
				<td><s:property  value="#stu.bookauthor " /></td>
				<td><s:property  value="#stu.bookpub " /></td>
			
			
				<%--<td><s:date name="#stu.bookpubdate" format="yyyy年MM月dd日" /></td>
				<td><s:date name="#stu.bookindate" format="yyyy年MM月dd日" /></td>--%>
			<td><s:property value="#stu.bookpubdate.substring(0,10)"   /></td>
				<td><s:property value="#stu.bookindate.substring(0,10)"   /></td>				
			
			    <s:if test="#stu.isborrowed=='1'.toString()">
     					 <td>是</td>
     				 </s:if>
      			<s:if test="#stu.isborrowed=='0'.toString()">
                   <td>否 </td>
      				</s:if>             
				<td><s:property value="#stu.bookprice" /></td>
					<%-- <td><%=session.getAttribute("bookid") %></td>
					<td><%=session.getAttribute("bookname") %></td>
					<td><%=session.getAttribute("bookstyleno") %></td>
					<td><%=session.getAttribute("bookauthor") %></td>
					<td><%=session.getAttribute("bookpub") %></td>
					<td><%=session.getAttribute("bookpubdate") %></td>
					<td><%=session.getAttribute("bookindate") %></td>
					<td><%=session.getAttribute("isborrowed") %></td> 
					<td><%=session.getAttribute("bookprice") %></td>--%>
					<%-- <td><a href="<%=path%>/books/Books_modify.action?sid=<s:property value="#stu.sid"/>"><s:property value="#stu.sname"/></a></td>
					<td><s:date name="#stu.loandate" format="yyyy年MM月dd日" /></td>
					<td><s:property value="#stu.total" /></td> --%>
					<td align=center><%-- <a
						href="/Bookmanage/BooksAction/Books_deleteAction.action?bid=<s:property value="#stu.bookid"/>"
						onclick="javascript: return confirm('真的要删除吗？');">删除</a> --%> 
						<a href="/Bookmanage/BooksAction/Books_deleteAction.action?bookid=${stu.bookid}" onclick="return confirm('确定要删除吗？')">删除</a>
						<a href="/Bookmanage/BooksAction/Books_modifyAction.action?bookid=${stu.bookid}">修改</a> 
					</td> 
				</tr>
				
			 </s:iterator> 
			 </table>
			<!-- 遍历结束 -->
	</div>
</body>
</html>
