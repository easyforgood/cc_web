package DBConnection;

import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author sunyibo
 *
 */
public class DBConnectionConfig {
	/**
	 * 读取数据库配置
	 */
	 private static Properties prop = new Properties();
	    static {
	        try {
	            prop.load(DBConnectionConfig.class
	                    .getResourceAsStream("DBConnectionConfig.properties"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
     public static String className = prop.getProperty("className");
     public static String dbname = prop.getProperty("dbname");
}
