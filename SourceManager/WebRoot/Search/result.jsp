<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.* ,Model.FileOfCourse"%>
<%@page import="java.util.* ,Model.Course"%>
<%
	ArrayList<FileOfCourse> filelist = (ArrayList<FileOfCourse>) request
			.getAttribute("search_filelist");
	ArrayList<Course> courselist = (ArrayList<Course>) request
			.getAttribute("search_courselist");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'result.jsp' starting page</title>

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
	<div class="exp1">查询结果</div>


	<div class="exp2">
		<%
			if (filelist == null) {
		%>
		<br> <br>

		<table align="center" border="1" cellpadding="10">
			<tr>
				<th>
					<%
						out.print("课程名称");
					%>
				</th>
				<th>
					<%
						out.print("");
					%>
				</th>
				<th>
					<%
						out.print("");
					%>
				</th>
			</tr>
			<%
				for (int i = 0; i < courselist.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.print(courselist.get(i).getCourse_Name());
					%>
				</td>
				<td><a
					href="/SourceManage/servlet/CourseManageServlet?Course_ID=<%=courselist.get(i).getCourse_ID()%>">管理课程</a>
				</td>
				<td><a
					href="/SourceManage/servlet/CourseFileHomeManageServlet?Course_ID=<%=courselist.get(i).getCourse_ID()%>">管理课程文件</a>
				</td>
			</tr>
			<%
				}
			%>

		</table>
		<%
			} else {
		%>




		<table align="center" border="1" cellpadding="10">
			<tr>
				<th>
					<%
						out.print("文件名称");
					%>
				</th>
				<th>
					<%
						out.print("");
					%>
				</th>
			</tr>


			<%
				for (int i = 0; i < filelist.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.print(filelist.get(i).getFile_name());
					%>
				</td>
				<td><a
					href="/SourceManage/servlet/CourseFileHomeManageServlet?Course_ID=<%=filelist.get(i).getFile_ID()%>">管理课程文件</a>
				</td>

			</tr>
			<%
				}
			%>
		</table>





		<%
			}
		%>
	</div>





</body>
</html>
