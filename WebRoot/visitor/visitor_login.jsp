<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 这是一个html5 doctype声明 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="../css/visitor_login.css" />
<script type="text/javascript"
	src="http://cdn.staticfile.org/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="../js/bannerbox/jquery.js"></script>
</head>

<style type="text/css">
</style>
<body>

	<div id="wrapper">
		<div id="header">
			<div id="logo"></div>
			<div id="heading">
				<div id="title">亚麻逊</div>
				<div id="subTitle">登陆界面</div>
			</div>
		</div>
		<div id="main">
			<div id="mainBg">
				<div id="mainPanel">
					<form name="visitorLoginAction" namespace="/Bookmanage"
							action="${pageContext.servletContext.contextPath}/Bookmanage/visitorLoginAction.do"
							method="post">
							<!-- start of login form -->
							<div id="welcome" >
								<span id="welcome-text">会&nbsp;员&nbsp;登&nbsp;录</span>
							</div>
							<div id="error">
								<span>
								<s:fielderror >
									<s:param>readers.readerid</s:param>
								</s:fielderror>
								</span>
							</div>

							<div id="user-name">
								
								<span class="item">用户名:</span> 
								<span>
									
						<input type="text" name="readers.readerid" class="form-input"
						 maxlength="12" placeholder="请输入账号"
						 onkeyup="value=value.replace(/[\W]/g,'') " 
						 onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/></span>

							</div>
							<div id="error">
								<span>
							<s:fielderror>
										
										<s:param>readers.readerpassword</s:param>
									</s:fielderror>
									</span>
							</div>

							<div id="user-password" >
							
								<span class="item">密&nbsp;&nbsp;&nbsp;码:</span> 
								<span class="input"> 
									
								<input type="password"name="readers.readerpassword" class="form-input" maxlength="16" placeholder="请输入密码"></span>
							</div>
							<div id="error">
								<span>
								<s:fielderror >
									<s:param>errorMessage</s:param>
								</s:fielderror>
								</span>
								
							</div>
							<div id="button-group">
								<input type="submit" class="btn" value="登录" /> 
								<input type="reset" class="btn" value="重置" />
								<input type="button" class="btn" onclick="window.location.href='../user/Users_login.jsp'" value="我是管理员" />
								</br> <a href="visitor_register.jsp">还没有账号，快来注册一个吧</a></br> 
									<span id="errorMsg">
									
									<s:property value="#session.errorMsg"/>
								</font>
								</span>
							</div>

							<div></div>
							<!-- end of form -->
						</form>


					
				</div>
			</div>
		</div>
		<div id="footer">
			<div id="text">Copyright © 2009-2016 All Rights Reserved
				Powered By Doli</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function () {    
    if (window != top) {    
        top.location.href = location.href;    
    }    
});   
</script>
</html>