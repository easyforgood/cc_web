package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import test.mysql.MyConnection;
import util.DBConnection;

import Dao.SourceSearchDao;
import Dao.UploadDao;
import Model.Course;
import Model.FileOfCourse;
import Model.Source;

public class UploadService {

	public UploadService() {

	}

	public void UploadFile(FileOfCourse file) {
		Connection conn = new MyConnection().getCon();
		UploadDao up = new UploadDao();
		try {
			up.uploadFile(file, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UploadCource(Course course) {
		// System.out.println("connection«∞!!!!!!!!!!");
		// Connection conn = DBConnection.getConnection();
		Connection conn = new MyConnection().getCon();
		// System.out.println("connection∫Û!!!!!!!!!!");
		UploadDao up = new UploadDao();
		try {
			up.uploadCourse(course, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
