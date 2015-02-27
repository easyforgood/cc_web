package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.Files;
import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import Model.Course;
import Model.FileOfCourse;
import Service.SearchService;
import Service.UploadService;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.RandomFileRenamePolicy;

public class SourceUploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SourceUploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// File uploadPath = new File(filePath);
		//
		// // 文件最大容量 5M
		// int fileMaxSize = 5 * 1024 * 1024;
		// // 存放文件描述
		// String[] fileDiscription = { null, null };
		// // 文件名
		// String fileName = null;
		//
		// // 文件大小
		// int file_size = 0;
		// // 上传文件数
		// int fileCount = 0;
		// // 重命名策略
		// RandomFileRenamePolicy rfrp = new RandomFileRenamePolicy();
		//
		// // 默认重命名策略，有重名则后面加1,2，3....
		// DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		//
		// // 上传文件 用时间进行命名
		// /*
		// * MultipartRequest mulit = new MultipartRequest(request, filePath,
		// * fileMaxSize, "UTF-8", rfrp);
		// */
		//
		// // 上传文件 有重名则在后面添加1,2,3....
		// MultipartRequest mulit = new MultipartRequest(request, filePath,
		// fileMaxSize, "UTF-8", dfrp);
		//
		// // 获取上传者信息，在此模块与登录链接后再做
		//
		// // String userName = mulit.getParameter("userName");
		// // System.out.println(userName);
		// // 输出反馈信息
		// Enumeration filesname = mulit.getFileNames();
		// while (filesname.hasMoreElements()) {
		// String name = (String) filesname.nextElement();
		// fileName = mulit.getFilesystemName(name);
		// String contentType = mulit.getContentType(name);
		//
		// // System.out.println("共上传" + fileCount + "个文件！");
		// // 上传的文件的完整路径
		// String path = filePath + "/" + fileName;
		// File test_file = new File(path);
		// // 文件的大小 在存储均以字节为单位
		// file_size = (int) test_file.length();
		// if (!test_file.exists()) {
		// System.out.println("no file");
		// }
		//
		// if (fileName != null) {
		// fileCount++;
		// }
		//
		// }
		response.setContentType("text/html");
		request.setCharacterEncoding("gbk");

		// 存绝对路径
		String filePath = "D://upload";
		// 存相对路径
		/*
		 * 在apache-tomcat-7.0.57-windows-x86/apache-tomcat-7.0.57/webapps/
		 * SourceManage/upload下
		 */
		// String filePath = getServletContext().getRealPath("/") + "upload";
		// 检查文件夹是否存在 不存在 创建一个
		File uploadPath = new File(filePath);
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		// 实例化上传组件
		SmartUpload su = new SmartUpload();
		// 初始化上传组件
		su.initialize(this.getServletConfig(), request, response);
		// 设置文件大小
		su.setMaxFileSize(5 * 1024 * 1024);
		// 开始上传
		// 将上传文件全部保存到指定目录
		try {
			su.upload();
			int count = su.save(filePath);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取上传的文件列表对象
		org.lxh.smart.File file = su.getFiles().getFile(0);

		System.out.println("文件名：" + file.getFileName());
		System.out.println("文件类型： " + file.getFileExt());
		System.out.println("上传的路径为： " + filePath);

		int file_size = file.getSize();
		// 判断文件大小是以K还是M为单位
		if (file_size / 1024 / 1024 < 1) {
			file_size = file_size / 1024;
			System.out.println("文件大小" + file_size + "K");
		} else {
			file_size = file_size / 1024 / 1024;
			System.out.println("文件大小" + file_size + "M");
		}

		String course_name = su.getRequest().getParameter("course_name");
		String course_term = su.getRequest().getParameter("course_term");
		String file_term = su.getRequest().getParameter("file_term");
		System.out.println("course_name:" + course_name);
		Course course = new Course(course_name, course_term);
		course.setCourse_Tag(1);
		// 上传日期
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String upload_date = sdf.format(d);
		System.out.println(upload_date);
		// 课程文件设置
		FileOfCourse foc = new FileOfCourse();
		foc.setFile_name(file.getFileName());
		foc.setFile_Type(file.getFileExt());
		foc.setFile_Path(filePath);
		foc.setFile_Term_Year(file_term);
		foc.setFile_Size(file_size);
		foc.setTag(1);
		foc.setFile_DateTime(upload_date);
		foc.setFileComment(0);
		// System.out.println(foc.getFile_name());
		// System.out.println(foc.getFile_Type());
		// System.out.println(foc.getFile_Path());
		// System.out.println(foc.getFile_Term_Year());
		// System.out.println(foc.getFile_Size());
		// System.out.println(foc.getTag());
		// System.out.println(foc.getFile_DateTime());
		// System.out.println(foc.getFileComment());
		// 上传到数据库
		UploadService service = new UploadService();
		// 上传课程到数据库
		// service.UploadCource(course);
		SearchService ss = new SearchService();
		// 假设数据库已有课程，获取其COURSE_ID,并将其设为fileofcourse联系course的外键
		course = ss.getCourse(course_name, course_term);
		int course_id = course.getCourse_ID();
		// System.out.println("course_id:"+course_id);
		foc.setCourse_ID(course_id);
		service.UploadFile(foc);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
