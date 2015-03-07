/**    
* @Title: Px_User.java  
* @Package Model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月2日 下午10:10:09  
* @version V1.0    
*/
package Model;

/**  
 * @ClassName: Px_User  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月2日 下午10:10:09  
 *    
 */
public class Px_User {
	String user_name;
	String user_password;
	String user_email;
	Px_UserNickName nickname;
	Px_UserRank rank;
	/** 
	
	 * @return user_name 
	
	 */
	public String getUser_name() {
		return user_name;
	}
	/** 
	
	 * @param user_name 要设置的 user_name 
	
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/** 
	
	 * @return user_password 
	
	 */
	public String getUser_password() {
		return user_password;
	}
	/** 
	
	 * @param user_password 要设置的 user_password 
	
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/** 
	
	 * @return user_email 
	
	 */
	public String getUser_email() {
		return user_email;
	}
	/** 
	
	 * @param user_email 要设置的 user_email 
	
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/** 
	
	 * @return nickname 
	
	 */
	public Px_UserNickName getNickname() {
		return nickname;
	}
	/** 
	
	 * @param nickname 要设置的 nickname 
	
	 */
	public void setNickname(Px_UserNickName nickname) {
		this.nickname = nickname;
	}
	/** 
	
	 * @return rank 
	
	 */
	public Px_UserRank getRank() {
		return rank;
	}
	/** 
	
	 * @param rank 要设置的 rank 
	
	 */
	public void setRank(Px_UserRank rank) {
		this.rank = rank;
	}
}
