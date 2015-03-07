/**    
* @Title: Px_UserCourseServlet.java  
* @Package Servlet  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月1日 下午10:51:33  
* @version V1.0    
*/
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import DAOImpl.Px_UserCourseDAOImpl;
import Model.Px_Course;
import Model.Px_UserCourse;

/**  
 * @ClassName: Px_UserCourseServlet  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月1日 下午10:51:33  
 *    
 */
public class Px_UserCourseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Px_UserCourseServlet() {
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
		Px_UserCourseDAOImpl dao=new Px_UserCourseDAOImpl();
		if(cmd!=null){
			//查询
			if(cmd.equals("q")){
					ResultSet rs=dao.queryAll();
					int rowcount=0;
					LinkedList<Px_UserCourse> list=new LinkedList<Px_UserCourse>();
					try {
						while(rs.next()){
							Px_UserCourse uc =new Px_UserCourse();
							uc.setCourse_id(rs.getLong("course_id"));
							uc.setUser_email(rs.getString("user_email"));
							list.add(uc);
							rowcount++;
					}
					JSONArray array=JSONArray.fromObject(list);
					System.out.println(rowcount);
					json.put("sEcho", rowcount);
					json.put("iTotalRecords",rowcount);
					json.put("iTotalDisplayRecords",rowcount);
					json.put("aaData",array);
					System.out.println("p");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//update 更新
			else if(cmd.equals("t")){
				String course_id=request.getParameter("course_id");
				String user_email=request.getParameter("user_email");
				Px_UserCourse uc =new Px_UserCourse();
				uc.setCourse_id(Long.parseLong(course_id));
				uc.setUser_email(user_email);
				dao.insert(uc);
			}
			else if(cmd.equals("d")){
				
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

		doGet(request,response);
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
