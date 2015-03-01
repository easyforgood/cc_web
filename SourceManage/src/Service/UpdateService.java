package Service;

import java.sql.Connection;
import java.sql.SQLException;

import test.mysql.MyConnection;
import Dao.DeleteSourceDao;
import Dao.UpdateDao;
import Dao.UploadDao;

public class UpdateService {

	public void updateCourse(int id, String name, String term) {
		Connection conn = new MyConnection().getCon();
		UpdateDao updateDao = new UpdateDao();
		try {
			updateDao.updateCourse(id, name, term, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateFile(int id, String name) {
		Connection conn = new MyConnection().getCon();
		UpdateDao updateDao = new UpdateDao();
		try {
			updateDao.updateFile(id, name, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
