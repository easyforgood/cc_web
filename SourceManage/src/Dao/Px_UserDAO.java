/**    
* @Title: Px_UserDAO.java  
* @Package Dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月3日 下午7:30:14  
* @version V1.0    
*/
package Dao;

import java.util.List;

import Model.Px_User;

/**  
 * @ClassName: Px_UserDAO  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月3日 下午7:30:14  
 *    
 */
public interface Px_UserDAO {
	public List<Px_User> queryAll();
	public boolean update(Px_User user);
	public boolean insert(Px_User user);
	public boolean delete(Px_User user);
}
