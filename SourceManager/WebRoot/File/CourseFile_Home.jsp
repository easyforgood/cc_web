<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="Model.FileOfCourse"%>
<%
	ArrayList<FileOfCourse> filelist = new ArrayList<FileOfCourse>();
	filelist = (ArrayList<FileOfCourse>) request
			.getAttribute("filelist");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'CourseFile_Home.jsp' starting page</title>
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
	<div class="exp1">课程文件</div>
	<div class="exp2">


		<%
			if (filelist == null) {
		%>
		<table align="center" border="1" cellpadding="10">
			<tr>
				<th>
					<%
						out.print("课程ID");
					%>
				</th>
				<th>
					<%
						out.print("文件名");
					%>
				</th>
				<th>
					<%
						out.print("文件学期");
					%>
				</th>
				<th>
					<%
						out.print("文件上传日期");
					%>
				</th>
				<th>
					<%
						out.print("文件ID ");
					%>
				</th>
				<th>
					<%
						out.print(" ");
					%>
				</th>
			</tr>
		</table>
		<%
			} else {
		%>


		<table align="center" border="1" cellpadding="10">
			<tr>
				<th>
					<%
						out.print("课程ID");
					%>
				</th>
				<th>
					<%
						out.print("文件名");
					%>
				</th>
				<th>
					<%
						out.print("文件学期");
					%>
				</th>
				<th>
					<%
						out.print("文件上传日期");
					%>
				</th>
				<th>
					<%
						out.print("文件ID ");
					%>
				</th>
				<th>
					<%
						out.print(" ");
					%>
				</th>
			</tr>

			<%
				for (int i = 0; i < filelist.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.print(filelist.get(i).getCourse_ID());
					%>
				</td>
				<td>
					<%
						out.print(filelist.get(i).getFile_name());
					%>
				</td>
				<td>
					<%
						out.print(filelist.get(i).getFile_Term_Year());
					%>
				</td>
				<td>
					<%
						out.print(filelist.get(i).getFile_DateTime());
					%>
				</td>
				<td>
					<%
						out.print(filelist.get(i).getFile_ID());
					%>
				</td>
				<td><a
					href="/SourceManage/servlet/CourseFileManageServlet?File_ID=<%=filelist.get(i).getFile_ID()%>"">管理文件</a>
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
	<br>
</body>
</html>
