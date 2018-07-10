<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zhbit.Bookmanage.domain.*, java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改通知公告</title>
<link rel="stylesheet" href="css/ncss_style.css" type="text/css" />
<script type="text/javascript" language="javascript">
	function checkNotice(){
		var title = form1.notice.title.value;
		if ((title==null)||(title=="")){
			alert("请填写标题！");
			return false;		
		}
		var editor = form1.notice.editor.value;
		if ((editor==null)||(editor=="")){
			alert("请填写作者！");
			return false;		
		}
		var content = form1.notice.content.value;
		if ((content==null)||(content=="")){
			alert("请填写内容！");
			return false;		
		}
		return true;
	}
</script>
</head>
<body>
<s:form method="post" name="form1" action="notice_update" onsubmit="javascript: return checkNotice();">
  <table>
    <tr>
      <td>标题:</td>
      <td><s:textfield name="notice.title" size="35" value="%{notice.title}"/></td>
      
    </tr>
    <tr>
      <td>作者:</td>
      <td><s:textfield name="notice.editor" size="35" value="%{notice.editor}"/></td>
    </tr>
    <tr>
      <td>内容:</td>
      <td><s:textarea name="notice.content" rows="10" cols="30" value="%{notice.content}"/></td>
    </tr>
    <tr>
      <td> 类型:</td>
      <td><s:select name="typeId" list="typeList" listKey="id" listValue="typeName" headerKey="0" headerValue="请选择"/></td>
    </tr>
    <tr>
  	  <s:hidden name="notice.id" value="%{notice.id}"/>
      <td><s:submit value="提交" name="submit" /></td>
    </tr>
  </table>
</s:form>
</body>
</html>
