package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Course;

public class UpdateDao {
	public void updateCourse(int id, String name, String term, Connection conn)
			throws SQLException {
		String sql = "update course set Course_Name = " + "'" + name + "'"
				+ " , Course_Term = " + "'" + term + "'"
				+ " where Course_ID = " + id;
		// ResultSet rs;
		System.out.println("修改为:" + id + "   " + name + "  " + term);
		System.out.println(sql);
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			// pStatement.setString(1, id);
			// pStatement.setString(2, name);
			// pStatement.setInt(3, course.getCourse_Tag());
			// // pStatement.executeQuery();
			pStatement.execute();

			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("Course update failed !!!!");
		}
	}

	public void updateFile(int id, String name, Connection conn)
			throws SQLException {
		String sql = "update file set File_Name = " + "'" + name + "'"
				+ " where File_ID = " + id;
		// ResultSet rs;
		System.out.println("修改为:" + id + "   " + name + "  ");
		// System.out.println(sql);
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			// pStatement.setString(1, id);
			// pStatement.setString(2, name);
			// pStatement.setInt(3, course.getCourse_Tag());
			// // pStatement.executeQuery();
			pStatement.execute();

			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("Course update failed !!!!");
		}
	}
}
