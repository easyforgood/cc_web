/**    
* @Title: Px_CourseDAOImpl.java  
* @Package Impl  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015��1��6�� ����10:28:05  
* @version V1.0    
*/
package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DBAccess.DBAccess;
import Dao.Px_CourseDAO;
import Model.Px_Course;

/**  
 * @ClassName: Px_CourseDAOImpl  
 * @Description: TODO(������һ�仰��������������)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015��1��6�� ����10:28:05  
 *    
 */
public class Px_CourseDAOImpl implements Px_CourseDAO{

	/* (�� Javadoc) 
	
	* <p>Title: saveCourse</p> 
	
	* <p>Description: </p> 
	
	* @param course
	* @return 
	
	* @see Dao.Px_CourseDAO#saveCourse(Model.Px_Course) 
	
	*/ 
	@Override
	public boolean saveCourse(Px_Course course) {
		// TODO Auto-generated method stub
		Connection conn=DBAccess.getConnection();
		
		try {
			PreparedStatement stmt=conn.prepareStatement("insert into Course(course_name,course_term,course_info,course_jieshu,course_week) values(?,?,?,?,?)");
			stmt.setString(1, course.getCourse_name());
			stmt.setString(2, course.getCourse_term());
			stmt.setString(3, course.getCourse_info());
			stmt.setString(4, course.getCourse_jieshu());
			stmt.setString(5, course.getCourse_week());
			stmt.execute();
			stmt.close();
			DBAccess.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	/* (�� Javadoc) 
	
	* <p>Title: queryCourse</p> 
	
	* <p>Description: </p> 
	
	* @param course_id
	* @return 
	
	* @see Dao.Px_CourseDAO#queryCourse(int) 
	
	*/ 
	@Override
	public Px_Course queryCourse(Long course_id) {
		// TODO Auto-generated method stub
		Px_Course course=null;
		Connection conn=DBAccess.getConnection();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Course where Course_Id ="+course_id);
			course=new Px_Course();
			if(rs.next()){
				course.setCourse_id(rs.getLong(0));
				course.setCourse_info(rs.getString("Course_Info"));
				course.setCourse_jieshu(rs.getString("Course_Jieshu"));
				course.setCourse_name(rs.getString("Course_Name"));
				course.setCourse_term(rs.getString("Course_Term"));
				course.setCourse_week(rs.getString("Course_Week"));
			}
			rs.close();
			stmt.close();
			DBAccess.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}

	/* (�� Javadoc) 
	
	* <p>Title: removeCourse</p> 
	
	* <p>Description: </p> 
	
	* @param course_id
	* @return 
	
	* @see Dao.Px_CourseDAO#removeCourse(int) 
	
	*/ 
	@Override
	public boolean removeCourse(Long course_id) {
		// TODO Auto-generated method stub
		Connection conn=DBAccess.getConnection();
		try {
			Statement stmt=conn.createStatement();
			stmt.execute("delete from Course where Course_Id ="+course_id);
			stmt.close();
			DBAccess.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/* (�� Javadoc) 
	
	* <p>Title: updateCourse</p> 
	
	* <p>Description: </p> 
	
	* @param course
	* @return 
	
	* @see Dao.Px_CourseDAO#updateCourse(Model.Px_Course) 
	
	*/ 
	@Override
	public boolean updateCourse(Px_Course course) {
		// TODO Auto-generated method stub
		Connection conn=DBAccess.getConnection();
		try {
			PreparedStatement stmt=conn.prepareStatement("update  Course set Course_Name=?,"
					+ "Course_Term=?,Course_Info=?,Course_Jieshu=?,	Course_Week=?"
					+ "where Course_Id = ?");
			//stmt.setLong(0, course.getCourse_id());
			stmt.setString(1, course.getCourse_name());
			stmt.setString(2, course.getCourse_term());
			stmt.setString(3, course.getCourse_info());
			stmt.setString(4, course.getCourse_jieshu());
			stmt.setString(5, course.getCourse_week());
			stmt.setLong(6, course.getCourse_id());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/* 
	
	* <p>Title: queryAll</p> 
	
	* <p>Description: </p> 
	
	* @return 
	
	* @see Dao.Px_CourseDAO#queryAll() 
	
	*/ 
	@Override
	public List<Px_Course> queryAll() {
		// TODO Auto-generated method stub
		Connection conn=DBAccess.getConnection();
		List<Px_Course> list = null;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Course");
			list=new LinkedList<Px_Course>();
			while(rs.next()){
				Px_Course course=new Px_Course();
				course.setCourse_id(rs.getLong("Course_Id"));
				course.setCourse_jieshu(rs.getString("Course_Jieshu"));
				course.setCourse_name(rs.getString("Course_Name"));
				course.setCourse_term(rs.getString("Course_Term"));
				course.setCourse_week(rs.getString("Course_Week"));
				course.setCourse_info(rs.getString("Course_Info"));
				list.add(course);
			}
			DBAccess.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/* 
	
	* <p>Title: queryById</p> 
	
	* <p>Description: </p> 
	
	* @param id
	* @return 
	
	* @see Dao.Px_CourseDAO#queryById(java.lang.Long) 
	
	*/ 
	@Override
	public List<Px_Course> queryById(Long id) {
		// TODO Auto-generated method stub
		Connection conn=DBAccess.getConnection();
		List<Px_Course> list = null;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Course where course_id ="+id);
			list=new LinkedList<Px_Course>();
			while(rs.next()){
				Px_Course course=new Px_Course();
				course.setCourse_id(rs.getLong("Course_Id"));
				course.setCourse_jieshu(rs.getString("Course_Jieshu"));
				course.setCourse_name(rs.getString("Course_Name"));
				course.setCourse_term(rs.getString("Course_Term"));
				course.setCourse_week(rs.getString("Course_Week"));
				course.setCourse_info(rs.getString("Course_Info"));
				list.add(course);
			}
			DBAccess.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	


}
