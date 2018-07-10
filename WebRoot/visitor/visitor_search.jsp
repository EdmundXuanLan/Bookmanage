<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>亚麻逊</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/visitor_search.css" />
<script type="text/javascript"
	src="http://cdn.staticfile.org/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="../js/bannerbox/jquery.js"></script>

</head>
<body>
	<div id="wrapper">

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
			<div id="table">
				<s:if test="#session.flag=='success'">
					<table class="default" width="100%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="15%">
						<col width="15%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<tr class="title">
							<td>图书编号</td>
							<td>图书名</td>
							<td>图书类型</td>
							<td>作者</td>
							<td>出版社</td>
							<td>出版时间</td>
							<td>上架时间</td>
							<td>是否被借</td>
							<td>价格</td>
						</tr>
						<!-- 遍历开始 -->
						<s:iterator value="#session.books_list" var="book">
							<tr class="list">
								<td><s:property value="#book.bookid" /></td>
								<td><s:property value="#book.bookname" /></td>
								<td><s:property value="#book.bookstyleno" /></td>
								<td><s:property value="#book.bookauthor " /></td>
								<td><s:property value="#book.bookpub " /></td>
								<td><s:property value="#book.bookpubdate.substring(0,10)" /></td>
								<td><s:property value="#book.bookindate.substring(0,10)" /></td>
								<td><s:property value="#book.isborrowed" /></td>
								<td><s:property value="#book.bookprice" /></td>

							</tr>

						</s:iterator>
					</table>
				</s:if>
				<s:else>

					<div id="word">没有查询结果！
					<input onClick="window.location.href='visitor_main.jsp'" type="button" class="btn" value="返回">
					</div>
				</s:else>
			</div>


		</div>

	</div>
</body>
<script type="text/javascript">
	function screenAdapter() {
		document.getElementById('footer').style.top = document.documentElement.scrollTop + document.documentElement.clientHeight - document.getElementById('footer').offsetHeight + "px";

		document.getElementById('main').style.height = document.documentElement.clientHeight - 100 + "px";
		document.getElementById('main').style.width = window.screen.width - 250 + "px";
	}

	window.onscroll = function() {
		screenAdapter();
	};
	window.onresize = function() {
		screenAdapter();
	};
	window.onload = function() {
		screenAdapter();
	};

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