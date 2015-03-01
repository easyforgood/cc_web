package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DeleteService;
import Service.UpdateService;

public class CourseUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CourseUpdateServlet() {
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
		// response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("Course_ID_Update"));
		String name = request.getParameter("Course_Name");
		String term = request.getParameter("Course_Term");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		term = new String(term.getBytes("iso-8859-1"), "utf-8");
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("term:" + term);

		// System.out.println("id:" + id + "  name " + name + " term " + term);
		UpdateService ds = new UpdateService();
		// ds.updateCourse(id, name, term);
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

		// response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("Course_ID"));
		String name = request.getParameter("Course_Name");
		String term = request.getParameter("Course_Term");
		//name = new String(name.getBytes("iso-8859-1"), "utf-8");
		//term = new String(term.getBytes("iso-8859-1"), "utf-8");
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("term:" + term);

		// System.out.println("id:" + id + "  name " + name + " term " + term);
		UpdateService ds = new UpdateService();
		ds.updateCourse(id, name, term);
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
