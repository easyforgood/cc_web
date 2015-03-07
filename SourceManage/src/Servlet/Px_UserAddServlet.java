/**    
* @Title: Px_UserAddServlet.java  
* @Package Servlet  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月4日 下午7:34:15  
* @version V1.0    
*/
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOImpl.Px_UserDAOImpl;
import Dao.Px_UserDAO;
import Model.Px_User;
import Model.Px_UserNickName;
import Model.Px_UserRank;

/**  
 * @ClassName: Px_UserAddServlet  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月4日 下午7:34:15  
 *    
 */
public class Px_UserAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Px_UserAddServlet() {
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
		Px_UserDAO dao=new Px_UserDAOImpl();
		//username=&password=&rpassword=&email=&nick_name=&rank_name=
		String user_name=request.getParameter("username");
		String user_password=request.getParameter("password");
		String user_email=request.getParameter("email");
		String nick_name=request.getParameter("nick_name");
		String rank_name=request.getParameter("rank_name");
		Px_UserNickName nickname=new Px_UserNickName();
		nickname.setNick_name(nick_name);
		Px_UserRank rank=new Px_UserRank();
		rank.setRank_name(rank_name);
		Px_User user=new Px_User();
		user.setNickname(nickname);
		user.setRank(rank);
		user.setUser_email(user_email);
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		dao.insert(user);
		
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
