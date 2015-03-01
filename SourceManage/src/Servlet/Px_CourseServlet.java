/**    
* @Title: Px_CourseServlet.java  
* @Package Servlet  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年1月7日 下午5:20:27  
* @version V1.0    
*/
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import DAOImpl.Px_CourseDAOImpl;
import Dao.Px_CourseDAO;
import Model.Px_Course;

/**  
 * @ClassName: Px_CourseServlet  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年1月7日 下午5:20:27  
 *    
 */
public class Px_CourseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Px_CourseServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cmd=request.getParameter("c");
		JSONObject json=new JSONObject();
		System.out.println("////////////cmd is "+cmd);
		Px_CourseDAO dao=new Px_CourseDAOImpl();
		if(cmd!=null){
			//查询
			if(cmd.equals("q")){
				List<Px_Course> list=dao.queryAll();
				JSONArray array=JSONArray.fromObject(list);
				json.put("sEcho", list.size());
				json.put("iTotalRecords",list.size());
				json.put("iTotalDisplayRecords",list.size());
				json.put("aaData",array);
				System.out.println("p");
			}
			//update 更新
			else if(cmd.equals("u")){
				String aaData=request.getParameter("aData");
				String course_id=request.getParameter("course_id");
				String course_name=request.getParameter("course_name");
				String course_week=request.getParameter("course_week");
				String course_jieshu=request.getParameter("course_jieshu");
				String course_term=request.getParameter("course_term");
				String course_info=request.getParameter("course_info");
				course_name=URLDecoder.decode(course_name, "utf-8");
				Px_Course course=new Px_Course();
				course.setCourse_info(course_info);
				course.setCourse_jieshu(course_jieshu);
				course.setCourse_name(course_name);
				course.setCourse_term(course_term);
				course.setCourse_week(course_week);
				//course_id 为空 insert
				if(course_id.equals("")){
					dao.saveCourse(course);
				}
				//course_id 不为空update
				else{
					course.setCourse_id(Long.parseLong(course_id));
					System.out.print(course_id+"\n"+course_info+"\n"+course_name);
						
					boolean result=dao.updateCourse(course);
					if(result){
						System.out.println("Update Success");
					}
					else 
						System.out.println("Update failed");
				}
			}
			else if(cmd.equals("d")){
				String course_id=request.getParameter("course_id");
				if(course_id.equals("")){
					System.out.println("wrong");
				}
				else{
					dao.removeCourse(Long.parseLong(course_id));
				}
			}
		}
		System.out.println("Hello!");                      
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
