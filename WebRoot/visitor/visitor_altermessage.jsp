<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'visitor_altermessage.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="../css/visitor_altermessage.css" />  

  </head>
  
  <body>
  <div id="wrapper">
	  <div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title">亚麻逊</div>
			<div id="subTitle">修改个人信息</div>
		</div>
	</div>
	<div id="main">
		<div id="mainBg">
			<div id="mainPanel">
				<div id="mainPane2">
					<form name="altermessageAction" namespace="/Bookmanage" action="${pageContext.servletContext.contextPath}/Bookmanage/altermessageAction.do" method="post">
						<div id="input">
							<span class="item">账&nbsp;&nbsp;&nbsp;号:<%=session.getAttribute("readerId") %></span>
							
						</div>
						
						<div class="errormessage">
								<s:fielderror>
									<s:param>readers.readername</s:param>
								</s:fielderror>
							</div>
							
							<div id="input" >
							<span class="item">姓&nbsp;&nbsp;&nbsp;名:
							<input type="text" name="readers.readername" class="form-input" value="<%=session.getAttribute("readername") %>">
							</span>
							
							
							
						</div>
						<div class="errormessage">
								
							</div>
						<div id="input">
							<span class="item">性&nbsp;&nbsp;&nbsp;别:</span>
							<span class="item">男</span>
							<input type="radio" name="readers.readersex" value="男" checked>
							<span class="item">女</span>
						<input type="radio" name="readers.readersex" value="女">
						</div>
						
						<div class="errormessage">
								<s:fielderror>
									<s:param>readers.phonenumber</s:param>
								</s:fielderror>
							</div>
						<div id="input">
							<span class="item">联系方式：
							<input type="text" name="readers.phonenumber" class="form-input2" value="<%=session.getAttribute("phonenumber") %>">
							</span>	
						</div>	
							<input type="submit" class="btn" value="确认修改">
							<input onClick="window.location.href='visitor_message.jsp'" type="button" class="btn" value="返回">
							

						</form>
				</div>
			</div>	
		</div>
	</div>
</div>
    
  </body>
</html>
