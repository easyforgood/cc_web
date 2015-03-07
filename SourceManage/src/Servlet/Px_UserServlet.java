/**    
* @Title: Px_UserServlet.java  
* @Package Servlet  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月2日 下午10:11:56  
* @version V1.0    
*/
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import DAOImpl.Px_UserCourseDAOImpl;
import DAOImpl.Px_UserDAOImpl;
import Dao.Px_UserDAO;
import Model.Px_User;
import Model.Px_UserCourse;
import Model.Px_UserNickName;
import Model.Px_UserRank;

/**  
 * @ClassName: Px_UserServlet  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月2日 下午10:11:56  
 *    
 */
public class Px_UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Px_UserServlet() {
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
		Px_UserDAO dao=new Px_UserDAOImpl();
		if(cmd!=null){
			//查询
			if(cmd.equals("q")){
					List<Px_User> list=dao.queryAll();
					JSONArray array=JSONArray.fromObject(list);
					json.put("sEcho", list.size());
					json.put("iTotalRecords",list.size());
					json.put("iTotalDisplayRecords",list.size());
					json.put("aaData",array);
					System.out.println("p");
					System.out.println(json);
			}
			//update 更新
			else if(cmd.equals("u")){
				/*String course_id=request.getParameter("course_id");
				String user_email=request.getParameter("user_email");
				Px_UserCourse uc =new Px_UserCourse();
				uc.setCourse_id(Long.parseLong(course_id));
				uc.setUser_email(user_email);
				dao.insert(uc);*/
				String rank_id=request.getParameter("rank[rank_id]");
				String rankname=request.getParameter("rank[rank_name]");
				String nick_id=request.getParameter("nickname[nick_id]");
				String nickname=request.getParameter("nickname[nick_name]");
				String user_email=request.getParameter("user_email");
				String user_name=request.getParameter("user_name");
				String user_password=request.getParameter("user_password");
				Px_UserNickName nick=new Px_UserNickName();
				Px_UserRank rank=new Px_UserRank();
				rank.setRank_id(Long.parseLong(rank_id));
				rank.setRank_name(rankname);
				nick.setNick_id(Long.parseLong(nick_id));
				nick.setNick_name(nickname);
				Px_User user=new Px_User();
				user.setUser_email(user_email);
				user.setUser_name(user_name);
				user.setUser_password(user_password);
				user.setRank(rank);
				user.setNickname(nick);
				dao.update(user);
			}
			else if(cmd.equals("d")){
				String user_email=request.getParameter("user_email");
				Px_User user=new Px_User();
				user.setUser_email(user_email);
				dao.delete(user);
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
