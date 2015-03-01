package Service;

import java.sql.Connection;

import test.mysql.MyConnection;
import util.DBConnection;
import Dao.DeleteSourceDao;
import Dao.UploadDao;
import Model.Source;

public class DeleteService {
	public void DeleteCourse(int id) {
		Connection conn = new MyConnection().getCon();
		DeleteSourceDao deleteDao = new DeleteSourceDao();
		deleteDao.deleteCourse(id, conn);
	}

	public void DeleteFile(int id) {
		Connection conn = new MyConnection().getCon();
		DeleteSourceDao deleteDao = new DeleteSourceDao();
		deleteDao.deleteFile(id, conn);
	}
}
