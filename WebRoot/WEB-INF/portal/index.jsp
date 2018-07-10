<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*,com.zhbit.Bookmanage.domain.*"  %>
<%@ page import="javax.servlet.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学校通知公告发布后台管理系统</title>
<link href="${pageContext.request.contextPath }/css/ncss_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="ncss_banner_wrapper">
  <div id="ncss_banner">
    <div id="ncss_banner_image">
      <div id="ncss_banner_image_wrapper"> <br/>
      </div>
    </div>
  </div>
  <!-- end of banner --> 
</div>
<!-- end of banner wrapper -->

<div id="ncss_content_wrapper">
  <div id="ncss_content">
    <div id="column_w300">
      <div class="header_03">通知公告</div>
      <div class="column_w300_section_01">
        <div class="notice_content"> <s:a action="notice_showAdd" namespace="/notice" target="showNotice">添加公告</s:a> </div>
        <div class="cleaner"></div>
      </div>
      <div class="cleaner"></div>
      <div class="column_w300_section_01 even_color">
        <div class="notice_content"> <s:a action="notice_showPage" namespace="/notice" target="showNotice">公告列表</s:a> </div>
        <div class="cleaner"></div>
      </div>
    </div>
    <div id="column_w530">
      <div class="header_02">欢迎 访问通知公告发布后台管理</div>
      <div class="content_section_01">
        <div>
        	<s:url action="notice_showAdd" namespace="/notice" id="showAddNotice"></s:url>
          <iframe name="showNotice" src="<s:property value="#showAddNotice"/>" height="320px" width="400px" frameborder="0" marginheight="0" marginwidth="0"  scrolling="auto"/>
        </div>
      </div>
      <div class="cleaner"></div>
    </div>
    <div class="cleaner"></div>
  </div>
  <!-- end of content wrapper --> 
</div>
<!-- end of content wrapper -->

<div id="ncss_footer_wrapper">

</div>
<!-- end of footer -->

</body>
</html>
