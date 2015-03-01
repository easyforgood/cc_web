package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	private static DBConnection db = new DBConnection();
	private static String sidordbname;
	private static String port;
	private static String ip;
	private static String connString;

	private static String username;

	private static String password;

	private static String database;

	public DBConnection() {
		// Properties p = new Properties();
		System.out.println("test!!!!!!!!!!");
		try {
			// p.load(this.getClass().getResourceAsStream("init.properties"));
			/*
			 * String sidordbname = p.getProperty("sidordbname"); String port =
			 * p.getProperty("port"); String ip = p.getProperty("ip"); database
			 * = p.getProperty("database"); username =
			 * p.getProperty("username"); password = p.getProperty("password");
			 */
			sidordbname = "test";
			port = "3306";
			ip = "localhost";
			database = "mysql";
			username = "root";
			password = "";

			if (database.equalsIgnoreCase("oracle")) {
				connString = "jdbc:oracle:thin:@" + ip + ":" + port + ":"
						+ sidordbname;
			} else if (database.equalsIgnoreCase("mysql")) {
				//connString = "jdbc:mysql://" + ip + ":" + port + "/" +sidordbname + "?user=" + username + "&password=" 
				  //+ password;
				connString = "jdbc:mysql://localhost:3306/test";

			} else {
				connString = "jdbc:oracle:thin:@" + ip + ":" + port + ":"
						+ sidordbname;
			}
			System.out.println(connString);
		} catch (Exception e) {
			System.out.println("     쳣  ");
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			if (database.equals("oracle")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(connString, username,
						password);
			} else if (database.equals("mysql")) {
				System.out.println("aaaaaaaaaaadddddddddddd");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("cccc");
				conn = DriverManager.getConnection(connString, "root", "1234");
				
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("aaaaaaaaaaa");
		}
		return conn;
	}

	public static void disConnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر      쳣");
		}
		return;
	}

	public static void disConnect(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر statement 쳣");
		}
		return;
	}

	public static void disConnect(Statement statement, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر  α  쳣");
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر statement 쳣");
		}
		return;
	}

	public static void disConnect(Connection conn, Statement statement,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر  α  쳣");
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر statement 쳣");
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" ر      쳣");
		}
		return;
	}
}