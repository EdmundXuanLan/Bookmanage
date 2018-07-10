<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
	<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
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
		
		<div id="user_info">
			<a href="visitor_login.jsp">登录</a>/<a href="visitor_register.jsp">注册</a>
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
$(function(){
		var _this1=null;
		$('.nav>li').hover(function(){
			_this1=$(this);
			_this1.find('.second-nav').show();
			var _this2=null;
			_this1.find('.second-nav').find('li').hover(function(){
				_this2=$(this);
				_this2.find('.third-nav').show();
				_this2.find('.third-nav').hover(function(){
					$(this).show();
				},function(){
					$(this).hide();
				});
			},function(){
				_this2.find('.third-nav').hide();
			});
		},function(){
			_this1.find('.second-nav').hide();
		});
	});

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