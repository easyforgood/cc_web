/**    
* @Title: Px_UserNickName.java  
* @Package Model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月2日 下午10:53:48  
* @version V1.0    
*/
package Model;

/**  
 * @ClassName: Px_UserNickName  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月2日 下午10:53:48  
 *    
 */
public class Px_UserNickName {
	Long nick_id;
	String nick_name;
	/** 
	
	 * @return nick_id 
	
	 */
	public Long getNick_id() {
		return nick_id;
	}
	/** 
	
	 * @param nick_id 要设置的 nick_id 
	
	 */
	public void setNick_id(Long nick_id) {
		this.nick_id = nick_id;
	}
	/** 
	
	 * @return nick_name 
	
	 */
	public String getNick_name() {
		return nick_name;
	}
	/** 
	
	 * @param nick_name 要设置的 nick_name 
	
	 */
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
}
