<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="com.zhbit.Bookmanage.domain.Readers" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>亚麻逊</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/indexV.css" />
<style type="text/css">
	#title{
	font-size:30px;
	font-family: "楷体";
	text-align:center;
	text-shadow:1px 1px 1px #000;
	}
	
</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<img src="../images/logo.png" height="48px" width="48px" style="margin-left:30px">
		</div>
		<div id="title">亚麻逊图书馆</div>
		<div id="menu">
			
		</div>
		<div id="user_info">
		您好，

		 <a href="visitor_message.jsp"><%=session.getAttribute("readerId") %> </a>!
		</div>
	</div>
	<div id="navigator">
		<iframe src="visitor_tree.jsp"></iframe>
        </div>
	<div id="main">

		<iframe name="MainFrame" src="visitor_main.jsp"></iframe>

	</div>
	<div id="footer">Copyright © 2009-2016 All Rights Reserved Powered By Doli</div>
</div>
</body>
<script type="text/javascript">
function screenAdapter(){
	document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
		document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.width=window.screen.width-230+"px";
}

window.onscroll=function(){screenAdapter();};
window.onresize=function(){screenAdapter();};
window.onload=function(){screenAdapter();};
</script>
</html>