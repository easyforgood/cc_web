package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Model.Course;
import Model.FileOfCourse;
import Service.SearchService;
import Service.UpdateService;

public class SearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchServlet() {
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

		// response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject json=new JSONObject();
		// int id = Integer.parseInt(request.getParameter("Course_ID"));
		String name = request.getParameter("search_name");
	//	String string = request.getParameter("seleteString");
		// name = new String(name.getBytes("iso-8859-1"), "utf-8");
		// term = new String(term.getBytes("iso-8859-1"), "utf-8");
		// System.out.println("id:" + id);
		System.out.println("name:" + name);
		//System.out.println("string:" + string);

		// System.out.println("id:" + id + "  name " + name + " term " + term);
		SearchService ss = new SearchService();
		ArrayList<FileOfCourse> list = ss.searchbynamegetfilelist(name);
		JSONArray array=JSONArray.fromObject(list);
		json.put("sEcho", list.size());
		json.put("iTotalRecords",list.size());
		json.put("iTotalDisplayRecords",list.size());
		json.put("aaData",array);
		out.println(json);
		/*if (na'me.endsWith("File_Name")) {
			System.out.println("File_Name choose");
			ArrayList<FileOfCourse> filelist = ss.searchbynamegetfilelist(name);
			request.setAttribute("search_filelist", filelist);
		} else if (string.endsWith("Course_Name")) {
			System.out.println("courselist choose");
			ArrayList<Course> courselist = ss.searchbynamegetcourselist(name);
			request.setAttribute("search_courselist", courselist);
			System.out.println("courselist name"
					+ courselist.get(0).getCourse_Name());
		}*/
		
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
