package DBAccess;

import java.sql.Connection;

import DBConnection.DBConnection;
import DBConnection.DBConnectionFactory;
/**
 * 
 * @author sunyibo
 *
 */
public class DBAccess {
	/**
	 * 获取数据库连接实例
	 * @return
	 */
	  public static Connection getConnection() {
		  	DBConnectionFactory dbFactorySingleton=DBConnectionFactory.getFactoryInstance();
	        DBConnection service = dbFactorySingleton.getInstance();
	        Connection conn = service.getConnection();
	        return conn;
	  }
	  
	  /**
	   * 销毁数据库连接实例
	   * @param conn
	   * @return
	   */
	  public static Boolean closeConnection(Connection conn) {
		  	DBConnectionFactory dbFactorySingleton=DBConnectionFactory.getFactoryInstance();
    		DBConnection service = dbFactorySingleton.getInstance();
    		return service.closeConnection(conn);
	  }
}
