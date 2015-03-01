<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.* ,Model.FileOfCourse"%>
<%
	FileOfCourse file = (FileOfCourse) request.getAttribute("file");
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
	<div class="exp1">课程文件管理</div>
	<div class="exp2">
		<table align="center" border="1" cellpadding="10">
			<form method="post"
				action="/SourceManage/servlet/FileUpdateServlet">
				<tr>
					文件ID:
					<%
					out.print(file.getFile_ID());
				%>

					<input type="hidden" name="File_ID" value="<%=file.getFile_ID()%>">
					<br>
				</tr>

				<tr>
					文件名:
					<input type="text" name="File_Name"
						value="<%=file.getFile_name()%>">
					<br>

				</tr>
				<tr>
					课程ID:
					<input type="text" name="Course_ID"
						value="<%=file.getCourse_ID()%>">
				</tr>
				<td><input type="submit" value="保存修改">
				</td>
			</form>
			<td><a
				href="/SourceManage/servlet/FileDeleteServlet?File_ID=<%=file.getFile_ID()%>">删除</a>
			</td>
			<td><a href="#"></a></td>
			</td>
			<td><a href="#"></a></td>
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