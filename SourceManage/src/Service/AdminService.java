package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import test.mysql.MyConnection;
import DAOImpl.AdminDao;
import Model.Admin;

public class AdminService {
	public void add(Admin admin) throws SQLException {
		Connection conn = new MyConnection().getCon();
		AdminDao ad = new AdminDao();
		ad.add(admin, conn);
	}

	public void delete(String username) throws SQLException {
		Connection conn = new MyConnection().getCon();
		AdminDao ad = new AdminDao();
		ad.delete(username, conn);
	}

	public ArrayList<Admin> search(String username) throws SQLException {
		Connection conn = new MyConnection().getCon();
		ArrayList<Admin> list = new ArrayList<Admin>();
		AdminDao ad = new AdminDao();
		list = ad.search(username, conn);
		return list;
	}
}
