package Service;

import java.sql.Connection;
import java.sql.SQLException;

import DBAccess.DBAccess;
import Dao.UploadDao;
import Model.Course;
import Model.FileOfCourse;

public class UploadService {

	public UploadService() {

	}

	public void UploadFile(FileOfCourse file) {
		Connection conn = DBAccess.getConnection();
		UploadDao up = new UploadDao();
		try {
			up.uploadFile(file, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UploadCource(Course course) {
		// System.out.println("connectionǰ!!!!!!!!!!");
		// Connection conn = DBConnection.getConnection();
		Connection conn = DBAccess.getConnection();
		// System.out.println("connection��!!!!!!!!!!");
		UploadDao up = new UploadDao();
		try {
			up.uploadCourse(course, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
