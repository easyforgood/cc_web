package Service;

import java.sql.Connection;

import util.DBConnection;
import DBAccess.DBAccess;
import Dao.DeleteSourceDao;
import Dao.UploadDao;
import Model.Source;

public class DeleteService {
	public void DeleteCourse(int id) {
		Connection conn = DBAccess.getConnection();
		DeleteSourceDao deleteDao = new DeleteSourceDao();
		deleteDao.deleteCourse(id, conn);
	}

	public void DeleteFile(int id) {
		Connection conn = DBAccess.getConnection();
		DeleteSourceDao deleteDao = new DeleteSourceDao();
		deleteDao.deleteFile(id, conn);
	}
}
