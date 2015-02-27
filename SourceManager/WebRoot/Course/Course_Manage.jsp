<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.* ,Model.Course"%>
<%
	Course course = (Course) request.getAttribute("course");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Course Manage</title>
<style type="text/css">
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
	<div class="exp1">课程管理</div>
	<div class="exp2">
		<table align="center" border="1" cellpadding="10">
			<form method="post"
				action="/SourceManage/servlet/CourseUpdateServlet">
				<tr>
					课程ID:
					<%
					out.print(course.getCourse_ID());
				%>
					<input type="hidden" name="Course_ID"
						value="<%=course.getCourse_ID()%>">
					<br>
				</tr>
				<tr>
					课程名:
					<input type="text" name="Course_Name"
						value="<%=course.getCourse_Name()%>">
					<br>

				</tr>
				<tr>
					课程学期:
					<input type="text" name="Course_Term"
						value="<%=course.getCourse_term()%>">
				</tr>
				<td><input type="submit" value="保存修改">
				</td>
			</form>
			<td><a
				href="/SourceManage/servlet/CourseDeleteServlet?Course_ID=<%=course.getCourse_ID()%>">删除</a>
			</td>
			<td><a href="#">更改分类</a></td>
			</td>
			<td><a href="#">权限设置</a></td>
			</tr>

		</table>
		<!--  
		<form action="/SourceManage/servlet/CourseUpdateServlet" method="post">
			<input type="hidden" name="Course_Name_Update1" value="你好"> <input
				type="submit" value="提交">
		</form>
		-->
</body>
</html>