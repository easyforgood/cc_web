package DBConnection;

import java.sql.Connection;

/**
 * 
 * @author sunyibo
 *
 */
public interface DBConnection {
	public abstract Connection getConnection();
	public abstract Boolean closeConnection(Connection conn); 
}
