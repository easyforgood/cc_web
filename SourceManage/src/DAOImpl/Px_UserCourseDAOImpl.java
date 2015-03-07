/**    
* @Title: Px_UserCourseDAOImpl.java  
* @Package DAOImpl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月2日 上午10:26:14  
* @version V1.0    
*/
package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.DAO;
import Dao.MySQLDAO;
import Model.Px_UserCourse;

import com.mysql.jdbc.Statement;

/**  
 * @ClassName: Px_UserCourseDAOImpl  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月2日 上午10:26:14  
 *    
 */
public class Px_UserCourseDAOImpl{
	DAO dao=new MySQLDAO();
	public ResultSet queryAll(){
		Connection conn=dao.openConnection();
		
		ResultSet rs =null;
		try {
			Statement stmt = (Statement) conn.createStatement();
			rs=stmt.executeQuery("select * from user_course");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void insert(Px_UserCourse uc){
		Connection conn=dao.openConnection();
		ResultSet rs=null;
		try {
			Statement stmt=(Statement)conn.createStatement();
			stmt.execute("insert into user_course values('"+uc.getUser_email()+"',"+uc.getCourse_id()+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
