package DBConnection;

import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author sunyibo
 *
 */
public class MysqlConnectionConfig {
	/**
	 * 读取数据库连接参数配置
	 */
	  private static Properties prop = new Properties();
	    static {
	        try {
	            prop.load(MysqlConnectionConfig.class
	                    .getResourceAsStream("MysqlConnectionConfig.properties"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
      public static String driver = prop.getProperty("driver");
      public static String url = prop.getProperty("url");
      public static String user = prop.getProperty("user");
      public static String password = prop.getProperty("password");
}
