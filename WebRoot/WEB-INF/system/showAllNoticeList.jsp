<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,com.zhbit.Bookmanage.domain.*"%>
<%@ page import="javax.servlet.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告列表</title>
<link href="${pageContext.request.contextPath}/css/ncss_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
		<table border="0">
		<tr>
			<td>通知标题	</td><td>操作</td>
		</tr> 
		<s:iterator value="noticeList">
		<tr>
		<td>
	 		<s:a action="notice_getDetailById" target="showNotice">
	 			<s:property value="title"/> 
	 			<s:param name="notice.id" value="id"/>
	 		</s:a>
		</td> 		
		<td>
			<s:a action="notice_showDetailForModify" namespace="/notice" target="showNotice">
			修改
				<s:param name="notice.id" value="id"/>
			</s:a>
			
		</td>
	 	</tr>
	 	</s:iterator>
		</table>
	</div>
</body>
</html>
