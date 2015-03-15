/**    
* @Title: Px_UserCourseDAOImpl.java  
* @Package DAOImpl  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015��3��2�� ����10:26:14  
* @version V1.0    
*/
package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBAccess.DBAccess;
import Model.Px_UserCourse;

import com.mysql.jdbc.Statement;

/**  
 * @ClassName: Px_UserCourseDAOImpl  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015��3��2�� ����10:26:14  
 *    
 */
public class Px_UserCourseDAOImpl{
	public ResultSet queryAll(){
		Connection conn=DBAccess.getConnection();
		
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
		Connection conn=DBAccess.getConnection();
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
