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
		// // �ļ�������� 5M
		// int fileMaxSize = 5 * 1024 * 1024;
		// // ����ļ�����
		// String[] fileDiscription = { null, null };
		// // �ļ���
		// String fileName = null;
		//
		// // �ļ���С
		// int file_size = 0;
		// // �ϴ��ļ���
		// int fileCount = 0;
		// // ����������
		// RandomFileRenamePolicy rfrp = new RandomFileRenamePolicy();
		//
		// // Ĭ�����������ԣ�������������1,2��3....
		// DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		//
		// // �ϴ��ļ� ��ʱ���������
		// /*
		// * MultipartRequest mulit = new MultipartRequest(request, filePath,
		// * fileMaxSize, "UTF-8", rfrp);
		// */
		//
		// // �ϴ��ļ� ���������ں������1,2,3....
		// MultipartRequest mulit = new MultipartRequest(request, filePath,
		// fileMaxSize, "UTF-8", dfrp);
		//
		// // ��ȡ�ϴ�����Ϣ���ڴ�ģ�����¼���Ӻ�����
		//
		// // String userName = mulit.getParameter("userName");
		// // System.out.println(userName);
		// // ���������Ϣ
		// Enumeration filesname = mulit.getFileNames();
		// while (filesname.hasMoreElements()) {
		// String name = (String) filesname.nextElement();
		// fileName = mulit.getFilesystemName(name);
		// String contentType = mulit.getContentType(name);
		//
		// // System.out.println("���ϴ�" + fileCount + "���ļ���");
		// // �ϴ����ļ�������·��
		// String path = filePath + "/" + fileName;
		// File test_file = new File(path);
		// // �ļ��Ĵ�С �ڴ洢�����ֽ�Ϊ��λ
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

		// �����·��
		String filePath = "D://upload";
		// �����·��
		/*
		 * ��apache-tomcat-7.0.57-windows-x86/apache-tomcat-7.0.57/webapps/
		 * SourceManage/upload��
		 */
		// String filePath = getServletContext().getRealPath("/") + "upload";
		// ����ļ����Ƿ���� ������ ����һ��
		File uploadPath = new File(filePath);
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		// ʵ�����ϴ����
		SmartUpload su = new SmartUpload();
		// ��ʼ���ϴ����
		su.initialize(this.getServletConfig(), request, response);
		// �����ļ���С
		su.setMaxFileSize(5 * 1024 * 1024);
		// ��ʼ�ϴ�
		// ���ϴ��ļ�ȫ�����浽ָ��Ŀ¼
		try {
			su.upload();
			int count = su.save(filePath);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ�ϴ����ļ��б����
		org.lxh.smart.File file = su.getFiles().getFile(0);

		System.out.println("�ļ�����" + file.getFileName());
		System.out.println("�ļ����ͣ� " + file.getFileExt());
		System.out.println("�ϴ���·��Ϊ�� " + filePath);

		int file_size = file.getSize();
		// �ж��ļ���С����K����MΪ��λ
		if (file_size / 1024 / 1024 < 1) {
			file_size = file_size / 1024;
			System.out.println("�ļ���С" + file_size + "K");
		} else {
			file_size = file_size / 1024 / 1024;
			System.out.println("�ļ���С" + file_size + "M");
		}

		String course_name = su.getRequest().getParameter("course_name");
		String course_term = su.getRequest().getParameter("course_term");
		String file_term = su.getRequest().getParameter("file_term");
		System.out.println("course_name:" + course_name);
		Course course = new Course(course_name, course_term);
		course.setCourse_Tag(1);
		// �ϴ�����
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String upload_date = sdf.format(d);
		System.out.println(upload_date);
		// �γ��ļ�����
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
		// �ϴ������ݿ�
		UploadService service = new UploadService();
		// �ϴ��γ̵����ݿ�
		// service.UploadCource(course);
		SearchService ss = new SearchService();
		// �������ݿ����пγ̣���ȡ��COURSE_ID,��������Ϊfileofcourse��ϵcourse�����
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
