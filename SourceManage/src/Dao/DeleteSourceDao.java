package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Source;

public class DeleteSourceDao {
	public void deleteCourse(int id, Connection conn) {
		String sql = "update course set Course_Tag = 0 WHERE Course_ID = " + id;
		// ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			// pStatement.setString(1, source.getName());
			// pStatement.setString(2, source.getType());
			// pStatement.setString(3, source.getPath());
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {

		}
	}

	public void deleteFile(int id, Connection conn) {
		String sql = "update file set File_Tag = 0 WHERE File_ID = " + id;
		// ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			// pStatement.setString(1, source.getName());
			// pStatement.setString(2, source.getType());
			// pStatement.setString(3, source.getPath());
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {

		}
	}

}
