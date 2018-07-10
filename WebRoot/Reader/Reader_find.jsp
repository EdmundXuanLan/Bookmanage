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
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;读者管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="/Bookmanage/Reader/Reader_query.action">读者记录</a><span>&nbsp;
			
		</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>查询读者记录</strong>
<br>
<br>
<s:fielderror/>
<form name="findAction" namespace="/Reader" action="${pageContext.servletContext.contextPath}/Reader/Reader_find.action" method="post">
<table width="400" >
    <tr>
    <td width="30%">读者编号：</td>
    <td><input type="text" name="readerid"/></td><br>
    <td><s:fielderror fieldName="readerid"/></td>
  </tr>
 <tr>   
  <tr>
    <td>读者姓名：</td>
    <td><input type="text" name="readername"   /></td><br>
    <td><s:fielderror fieldName="readername"/></td>
  </tr>
  
   <tr>
    <td>读者性别：</td>
    <td><s:radio list="#{'1':'男','0':'女'}" name="readersex" value="1"/><br>
  </tr>
  
   <%-- <tr>
    <td>读者密码：</td>
    <td><input type="text" name="readerpassword" /></td><br>
    <td><s:fielderror fieldName="readerpassword"/></td>
  </tr> --%>
   <tr>
    <td>读者电话：</td>
    <td><input type="text" name="phonenumber"  /></td><br>
    <td><s:fielderror fieldName="phonenumber"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="查询"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>