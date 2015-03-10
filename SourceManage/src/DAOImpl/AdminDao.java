package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Admin;
import Model.Course;

public class AdminDao {

	public void add(Admin admin, Connection conn) throws SQLException {
		String sql = "insert into administrator (Admin_Name,Admin_Password,isSuper)"
				+ "values(?,?,?)";
		ResultSet rs;
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, admin.getUsername());
			pStatement.setString(2, admin.getPassword());
			pStatement.setInt(3, admin.getAuthority());
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("admin add failed !!!!");
		}
	}

	public void delete(String username, Connection conn) {
		// 将isSuper字段改成2，意味不存在
		String sql = "update administrator set isSuper = 2 WHERE Admin_Name = '"
				+ username +"'";
		System.out.println(sql);
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.execute();
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {

		}
	}

	public ArrayList<Admin> search(String username, Connection conn) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		String sql = "SELECT * FROM administrator WHERE Admin_Name like '%"
				+ "" + username + "" + "%' and isSuper != 2";
		System.out.println(sql);
		ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {

				Admin admin = new Admin();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setAuthority(rs.getInt(3));
				list.add(admin);
			}
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("search admin failed");
		}
		return list;
	}

}
