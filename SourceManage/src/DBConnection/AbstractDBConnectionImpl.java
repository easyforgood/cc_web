package DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 
 * @author sunyibo
 *
 */
public abstract class AbstractDBConnectionImpl implements DBConnection{
	 public Boolean closeConnection(Connection conn) {
        try {
        	if(conn!=null){
	            conn.close();
	            System.out.println("成功关闭数据库连接");
        	}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库连接关闭失败！");
            return false;
        }
        return true;
     }
     public Connection getConnection() {
         // TODO Auto-generated method stub
        return null;
     }
}
