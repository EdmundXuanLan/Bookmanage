<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="../css/visitor_login.css" />
</head>

<style type="text/css">
</style>
<body>
<s:form method="post" action="visitorLoginAction">
		<s:textfield name="readers.readername" label="用户名"/>
		<s:password name="readers.readerpassword" label="密码"/>
		<s:submit value="登录"/>
	</s:form>
</body>
</html>