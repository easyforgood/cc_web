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
		String sql = "insert into file(File_Name,File_Size,File_Path,File_DateTime,File_Type,File_Term_Year,FileComment,File_Tag,Course_ID)"
				+ " values (?,?,?,?,?,?,?,?,?)";

		
		
		// String sql =
		// "insert into file(File_Name,File_Size,File_Path,File_DateTime,File_Type,File_Term_Year,FileComment,File_Tag)"
		// + " values (1,2,3,4,5,6,7,8)";
		ResultSet rs;
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, file.getFile_name());
			pStatement.setInt(2, file.getFile_Size());
			pStatement.setString(3, file.getFile_Path());
			pStatement.setString(4, file.getFile_DateTime());
			pStatement.setString(5, file.getFile_Type());
			pStatement.setString(6, file.getFile_Term_Year());
			pStatement.setInt(7, file.getFileComment());
			pStatement.setInt(8, file.getTag());
			pStatement.setInt(9, file.getCourse_ID());
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("File upload failed !!!!");
		}
	}
}
