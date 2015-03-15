/**    
* @Title: BaseDAO.java  
* @Package Dao  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com    
* @date 2015��1��5�� ����8:48:02  
* @version V1.0    
*/
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**  
 * @ClassName: BaseDAO  
 * @Description: TODO(ʵ��DAO����ݿ����Ӳ���)  
 * @author Siplexy easyforgood@hotmail.com   
 * @date 2015��1��5�� ����8:48:02  
 *    
 */
public class MySQLDAO implements DAO{

	final String COLUMN_USER="username";
	final String COLUMN_PWD="pwd";
	String driverName="com.mysql.jdbc.Driver";
	String user="root"; //root
	String pwd="root";
	String url="jdbc:mysql://127.0.0.1:3306/cc";
	Connection conn;
	/* (�� Javadoc) 
	
	* <p>Title: openConnection</p> 
	
	* <p>Description: </p> 
	
	* @return 
	
	* @see Dao.DAO#openConnection() 
	
	*/ 
	@Override
	public Connection openConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url,user,pwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("this is openDBConnection");

		
		return conn;
	}

	/* (�� Javadoc) 
	
	* <p>Title: closeConnection</p> 
	
	* <p>Description: </p> 
	
	* @return 
	
	* @see Dao.DAO#closeConnection() 
	
	*/ 
	@Override
	public boolean closeConnection() {
		// TODO Auto-generated method stub
		 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
	}
	


	

}
