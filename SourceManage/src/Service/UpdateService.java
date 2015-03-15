package Service;

import java.sql.Connection;
import java.sql.SQLException;

import DBAccess.DBAccess;
import Dao.DeleteSourceDao;
import Dao.UpdateDao;
import Dao.UploadDao;

public class UpdateService {

	public void updateCourse(int id, String name, String term) {
		Connection conn = DBAccess.getConnection();
		UpdateDao updateDao = new UpdateDao();
		try {
			updateDao.updateCourse(id, name, term, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateFile(int id, String name) {
		Connection conn = DBAccess.getConnection();
		UpdateDao updateDao = new UpdateDao();
		try {
			updateDao.updateFile(id, name, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
