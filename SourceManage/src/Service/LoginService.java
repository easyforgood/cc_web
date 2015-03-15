package Service;

import java.sql.Connection;

import DAOImpl.LoginDao;
import DBAccess.DBAccess;
import Model.Admin;

public class LoginService {
	public Admin login(String username, String password) {
		Admin admin = new Admin();
		Connection conn = DBAccess.getConnection();
		LoginDao logindao = new LoginDao();
		admin = logindao.login(username, password, conn);
		return admin;
	}
}
