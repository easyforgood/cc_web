<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'Search_home.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
body {
	font-size: 12px;
	line-height: 24px;
	text-align: center;
}

.exp1 {
	font-size: 32px;
	text-align: center;
}

.exp2 {
	font-size: 22px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="exp1">查询资料</div>
	<br>
	<div class="exp2">请输入需要查询的相关信息：</div>
	<form method="post" action="/SourceManage/servlet/SearchServlet"
		>
		<br> 名称： <input id="search_name" type="text" name="search_name">
		<br> <br> <select name="seleteString">
			<option value="File_Name">文件名</option>
			<option value="Course_Name">课程名</option>
			
		</select> <input type="submit" value="搜索">
	</form>
	<br>
</body>
</html>
