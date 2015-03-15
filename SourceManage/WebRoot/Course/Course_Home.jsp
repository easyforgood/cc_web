<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.mysql.MyConnectio"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Home</title>
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
	<%
		//驱动程序名   
		String driverName = "com.mysql.jdbc.Driver";
		//数据库用户名   
		String userName = "cc";
		//密码   
		String userPasswd = "ccuser";
		//数据库名   
		String dbName = "cc";
		//表名   
		String tableName = "course";
		//联结字符串   
		String url = "jdbc:mysql://219.219.220.227:3306/" + dbName + "?user="
				+ userName + "&password=" + userPasswd;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM " + tableName + " WHERE Course_Tag = 1";
		ResultSet rs = statement.executeQuery(sql);
	%>
	<div class="exp1">课程</div>
	<div class="exp2">
		<table align="center" border="1" cellpadding="10">
			<tr>
				<th>
					<%
						out.print("课程ID");
					%>
				</th>
				<th>
					<%
						out.print("课程名");
					%>
				</th>
				<th>
					<%
						out.print("课程学期");
					%>
				</th>
				<th>
					<%
						out.print(" ");
					%>
				</th>
				<th>
					<%
						out.print(" ");
					%>
				</th>
			</tr>

			<%
				while (rs.next()) {
			%>
			<tr>
				<td>
					<%
						out.print(rs.getInt(1));
					%>
				</td>
				<td>
					<%
						out.print(rs.getString(2));
					%>
				</td>
				<td>
					<%
						out.print(rs.getString(3));
					%>
				</td>
				<td><a
					href="/SourceManage/servlet/CourseManageServlet?Course_ID=<%=rs.getInt(1)%>">管理课程</a>
				</td>
				<td><a
					href="/SourceManage/servlet/CourseFileHomeManageServlet?Course_ID=<%=rs.getInt(1)%>">管理课程文件</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<br>
</body>
</html>