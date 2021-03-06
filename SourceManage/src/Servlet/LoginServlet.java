package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Admin;
import Model.Course;
import Model.FileOfCourse;
import Service.LoginService;
import Service.SearchService;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		doPost(request, response);
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

		request.setCharacterEncoding("UTF-8");
		// int id = Integer.parseInt(request.getParameter("Course_ID"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// System.out.println("username:" + username);
		// System.out.println("password:" + password);
		Admin admin = new Admin();

		LoginService ls = new LoginService();
		admin = ls.login(username, password);
		System.out.println("Admin username:" + admin.getUsername());
		System.out.println("Admin password:" + admin.getPassword());
		System.out.println("Admin uthority:" + admin.getAuthority());
		// 0��ͨ
		if (admin.getAuthority() == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("/SourceManage/px/index.html");
		}
		// 1����
		else if (admin.getAuthority() == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("/Login/error.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("/Login/error.jsp").forward(request,
					response);
		}
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
