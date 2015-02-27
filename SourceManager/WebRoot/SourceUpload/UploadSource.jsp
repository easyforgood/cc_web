<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%
	request.setCharacterEncoding("gbk");
%>
<%@page import="javax.mail.*,javax.mail.internet.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Source Add Home</title>

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


<script type="text /javascript">
function getFileSize(filePath){  
   var image=new Image();  
   image.dynsrc=filePath;  
   alert(image.fileSize);  
}  
</script>
</head>
<body>
	<div class="exp1">上传资料</div>
	<br>
	<div class="exp2">请输入文件的相关信息：</div>
	<form method="post" action="/SourceManage/servlet/SourceUploadServlet"
		enctype="multipart/form-data">
		<br> 课程名： <input id="course_name" type="text" name="course_name">
		<br> <br>课程所属学期： <input id="course_term" type="text"
			name="course_term"> <br> <br>资料所属学期： <input
			id="file_term" type="text" name="file_term"> <br> <br>上传文件:<input
			type="file" name="File1" size="20" maxlength="20"><br> <input
			type="submit" value="上传">
	</form>

</body>
</html>