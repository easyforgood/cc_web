package DAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Admin;

public class LoginDao {
	public Admin login(String username, String password, Connection conn) {
		Admin admin = new Admin();
		String sql = "SELECT * FROM administrator WHERE Admin_Name= ? and Admin_Password=?";
		ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			rs = pStatement.executeQuery();
			if (rs.next()) {
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setAuthority(rs.getInt(3));
				//System.out.println("admin uthority dao:" + admin.getAuthority());
			}else{
				//2��ʾ�û������벻����
				admin.setAuthority(2);
			}
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {

		}
		return admin;
	}
}
