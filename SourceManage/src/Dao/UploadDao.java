package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Course;
import Model.FileOfCourse;
import Model.Source;

public class UploadDao {
	public void uploadCourse(Course course, Connection conn)
			throws SQLException {
		String sql = "insert into course (Course_Name, Course_Term,Course_Tag)"
				+ "values(?,?,?)";
		ResultSet rs;
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, course.getCourse_Name());
			pStatement.setString(2, course.getCourse_term());
			pStatement.setInt(3, course.getCourse_Tag());
			// pStatement.executeQuery();
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("Course upload failed !!!!");
		}
	}

	public void uploadFile(FileOfCourse file, Connection conn)
			throws SQLException {
		String sql = "insert into File(File_Name,File_Size,File_Path,File_DateTime,File_Type,FileComment,File_Tag,Course_ID)"
				+ " values (?,?,?,?,?,?,?,?)";

		System.out.println(sql);
		
		// String sql =
		// "insert into File(File_Name,File_Size,File_Path,File_DateTime,File_Type,File_Term_Year,FileComment,File_Tag)"
		// + " values (1,2,3,4,5,6,7,8)";
		ResultSet rs;
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, file.getFile_name());
			pStatement.setInt(2, file.getFile_size());
			pStatement.setString(3, file.getFile_path());
			pStatement.setString(4, file.getFile_DateTime());
			pStatement.setString(5, file.getFile_type());
			pStatement.setString(6, file.getFilecomment());
			pStatement.setInt(7, file.getTag());
			pStatement.setInt(8, file.getCourse_id());
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
