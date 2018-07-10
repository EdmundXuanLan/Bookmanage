<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>

    
    <title>游客注册</title>

<link rel="stylesheet" type="text/css" href="../css/visitor_register.css" />  
  </head>
  
  <body>
  <div id="wrapper">
	  <div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title">亚麻逊</div>
			<div id="subTitle">注册界面</div>
		</div>
	</div>
	<div id="main">
		<div id="mainBg">
			<div id="mainPanel">
				<div id="mainPane2">
					<form name="addAction" namespace="/Bookmanage" action="${pageContext.servletContext.contextPath}/Bookmanage/addAction.do" method="post">
						<div id="input">
							<span class="item">账&nbsp;&nbsp;&nbsp;号:</span>
							<span class="errormessage">
								<s:fielderror >
									<s:param>readers.readerid</s:param>
								</s:fielderror>
								</span>
							</br>
							<span><input type="text" name="readers.readerid" class="form-input" 
							maxlength="12" placeholder="请输入账号"
						 onkeyup="value=value.replace(/[\W]/g,'') " 
						 onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"></span>
						</div>
						<div id="input" >
							<span class="item">姓&nbsp;&nbsp;&nbsp;名:</span>
							<span class="errormessage">
								<s:fielderror>
									<s:param>readers.readername</s:param>
								</s:fielderror>
							</span>
							</br>
							<span><input type="text" name="readers.readername" class="form-input"
							maxlength="5" placeholder="请输入真实姓名"
							onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" 
						 onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5]/g,''))" ></span>
						</div>
						<div id="input">
							<span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
							<span class="errormessage">
								<s:fielderror>
									<s:param>readers.readerpassword</s:param>
								</s:fielderror>
							</span>
							</br>
							<span><input type="password" name="readers.readerpassword" class="form-input"
							maxlength="16" placeholder="请输入16位以内密码"></span>
						</div>
						<div id="input">
							<span class="item">性&nbsp;&nbsp;&nbsp;别:</span></br>
							<span >男</span>
							<input type="radio" name="readers.readersex" value="男" checked>
							<span >女</span>
						<input type="radio" name="readers.readersex" value="女">
						</div>
						<div id="input">
							<span class="item">联系方式：</span>
							<span class="errormessage">
								<s:fielderror>
									<s:param>readers.phonenumber</s:param>
								</s:fielderror>
							</span>
							</br>
							<span><input type="text" name="readers.phonenumber" class="form-input"
							maxlength="11" placeholder="请输入手机号码"
							onkeyup="this.value=this.value.replace(/\D/g,'')" 
							 onafterpaste="this.value=this.value.replace(/\D/g,'')"></span>
						</div>	
							<input type="submit" class="btn" value="注册">
							<div id="denglu">已有账户，<a href="visitor_login.jsp">登录→</a></div>

						</form>
				</div>
			</div>	
		</div>
	</div>
</div>
 </body>
</html>
