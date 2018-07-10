<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'visitor_alterpassword.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="../css/visitor_alterpassword.css" />

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo"></div>
			<div id="heading">
				<div id="title">亚麻逊</div>
				<div id="subTitle">修改密码</div>
			</div>
		</div>
		<div id="main">
			<div id="mainBg">
				<div id="mainPanel">
					<div id="mainPane2">
						<form name="alterpasswordAction" namespace="/Bookmanage"
							action="${pageContext.servletContext.contextPath}/Bookmanage/alterpasswordAction.do"
							method="post">
							<div class="errormessage">
								<s:fielderror>
									<s:param>readers.readerpassword</s:param>
								</s:fielderror>
								
								<s:fielderror >
									<s:param>errorPassword</s:param>
								</s:fielderror>
								
							</div>
							<div id="input">
								<span class="item">原密码: <input type="password"
									name="readers.readerpassword" class="form-input">
								</span>
							</div>
							<div class="errormessage">
								<s:fielderror>
									<s:param>newreaders.readerpassword</s:param>
								</s:fielderror>
							</div>
							<div id="input">
								<span class="item">新密码: <input type="password"
									name="newreaders.readerpassword" class="form-input">
								</span>
							</div>
							<div class="errormessage">
								<s:fielderror>
									<s:param>chackreaders.readerpassword</s:param>
								</s:fielderror>
								
								<s:fielderror >
									<s:param>errorNew</s:param>
								</s:fielderror>
								
							</div>
							<div id="input">
								<span class="item">确认密码: <input type="password"
									name="chackreaders.readerpassword" class="form-input2">
								</span>
							</div>
							<input type="submit" class="btn" value="确认修改"> <input
								onClick="window.location.href='visitor_message.jsp'"
								type="button" class="btn" value="返回">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
