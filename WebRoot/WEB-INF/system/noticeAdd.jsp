<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zhbit.Bookmanage.domain.*, java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加通知公告</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ncss_style.css" type="text/css" />
<script type="text/javascript" language="javascript">
	function checkNotice(){
		var title = document.getElementById('title').value;
		if ((title==null)||(title=="")){
			alert("请填写标题！");
			return false;		
		}
		var editor = document.getElementById('editor').value;
		if ((editor==null)||(editor=="")){
			alert("请填写作者！");
			return false;		
		}
		var content = document.getElementById('content').value;
		if ((content==null)||(content=="")){
			alert("请填写内容！");
			return false;		
		}
		var typeId = form1.typeId.value;
		if ((typeId==0)){
			alert("请选择公告类型！");
			return false;		
		}
		return true;
	}
</script>
</head>
<body>
<span style="color=red" style="font-size:12px" ><s:fielderror/> </span>
<s:form method="post" name="form1" action="validateAdd!add" namespace="/notice" onsubmit="javascript: return checkNotice(); ">
  <table>
    <tr>
      <td>标题:</td>
      <td><s:textfield id="title" name="notice.title" size="35" value=""/></td>
    </tr>
    <tr>
      <td>作者:</td>
      <td><s:textfield id="editor" name="notice.editor" size="35" value=""/></td>
    </tr>
    <%-- 
    <tr>
      <td>发布日期:</td>
      <td><s:textfield name="createTime" size="35" value="默认当前时间"/></td>
    </tr> 
    --%>
    <tr>
      <td>内容:</td>
      <td><s:textarea id="content" name="notice.content" rows="10" cols="30" /></td>
    </tr>
    <tr>
      <td> 类型:</td>
      <td><s:select name="typeId" list="typeList" listKey="id" listValue="typeName" headerKey="0" headerValue="请选择"/></td>
    </tr>
    <tr>
          <%-- <s:hidden name="method" value="addNotice"/> --%>     	
      <td><s:submit value="提交"/></td>
    </tr>
  </table>
</s:form>
</body>
</html>
