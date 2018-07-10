<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>

<title>My JSP 'visitor_main.jsp' starting page</title>

<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/visitor_main.css" />

<link rel="stylesheet" type="text/css" href="../css/boxstyle.css">

<script type="text/javascript"
	src="http://cdn.staticfile.org/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="../js/bannerbox/jquery.js"></script>



<style type="text/css">
</style>
</head>


<body>

	<div id="wrapper1">
		<div class="header">
			<ul class="nav">
				<li><a href="visitor_main.jsp">首页</a>
					</li>
				<li><a href="#">热度排行</a></li>
				<li><a href="#">图书类型</a>
					<ul class="second-nav">
						<li><a href="#">小说</a>
							<ul class="third-nav">
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=1"> 修真小说</a></li>
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=2"> 穿越小说</a></li>
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=3"> 恐怖小说</a></li>
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=4"> 都市小说</a></li>
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=5"> 科幻小说</a></li>
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=6"> 仙侠小说</a></li>
								<li><a href="/Bookmanage/Bookmanage/chackStyleAction.action?bookstyleno=7"> 言情小说</a></li>
							</ul></li>
						<li><a href="#"> 文学</a></li>
						<li><a href="#"> 历史、经济、哲学</a></li>
						<li><a href="#"> 政治、法律、军事</a></li>
						<li><a href="#">人文科学 </a></li>
						<li><a href="#"> 自然科学</a></li>
					</ul></li>
				<li><a href="#">中文图书</a>
					<ul class="second-nav">
						<li><a href="#"> 少儿</a></li>
						<li><a href="#"> 文学</a></li>
						<li><a href="#"> 科研</a></li>
						<li><a href="#"> 经营</a></li>
						<li><a href="#">教材教辅 </a></li>
					</ul></li>
				<li><a href="#">进口图书</a>
					<ul class="second-nav">
						<li><a href="#">Children's Books </a></li>
						<li><a href="#"> Literature & Fiction</a></li>
						<li><a href="#">进口港台图书  </a></li>
					</ul></li>
				<li><a href="#">教材教辅</a>
					<ul class="second-nav">
						<li><a href="#">考试辅导 </a></li>
						<li><a href="#"> 外语学习</a></li>
						<li><a href="#">中小学教辅 </a></li>
						<li><a href="#"> 大中专教材</a></li>
						<li><a href="#"> 词典与工具书</a></li>
					</ul></li>
				<li><a href="#">其他</a></li>
			</ul>
		</div>
		<div id="main">
			<div id="searchbig">
				<div id="search2">
					<div id="error">
						<s:fielderror>
							<s:param>books.bookname</s:param>
						</s:fielderror>
					</div>
					<div id="search">
						<form name="showSearchAction" namespace="/Bookmanage"
							action="${pageContext.servletContext.contextPath}/Bookmanage/showSearchAction.do"
							method="post">

							<input type="text" class="form-input" name="books.bookname" placeholder="请输入想找的图书名">
							<input type="submit" class="btn" value="搜索" />

						</form>
					</div>
				</div>
			</div>
			<div id="main2">
				<div id="show">
				
					
			
				</div>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	$(function fun1() {
		<!--下拉菜单 -->
		var _this1 = null;
		$('.nav>li').hover(function fun1() {
			_this1 = $(this);
			_this1.find('.second-nav').show();
			var _this2 = null;
			_this1.find('.second-nav').find('li').hover(function fun1() {
				_this2 = $(this);
				_this2.find('.third-nav').show();
				_this2.find('.third-nav').hover(function fun1() {
					$(this).show();
				}, function fun1() {
					$(this).hide();
				});
			}, function fun1() {
				_this2.find('.third-nav').hide();
			});
		}, function fun1() {
			_this1.find('.second-nav').hide();
		});

	});
</script>
</html>
