package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author sunyibo
 *
 */
public class MysqlConnectionImp extends AbstractDBConnectionImpl {
	public Connection getConnection() {
	        // TODO Auto-generated method stub
	        Connection conn = null;
	        try {
	            Class.forName(MysqlConnectionConfig.driver);
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	        	System.out.println("Mysql数据库连接建立失败");
	        	e.printStackTrace();
	        }
	        try {
	            conn = DriverManager.getConnection(MysqlConnectionConfig.url,
	            		MysqlConnectionConfig.user, MysqlConnectionConfig.password);
	            System.out.println("成功建立Mysql数据库连接");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("Mysql数据库连接建立失败");
	        }
	        return conn;
	}
    @Override
    public Boolean closeConnection(Connection conn) {
        // TODO Auto-generated method stub
        return super.closeConnection(conn);
    }
}
